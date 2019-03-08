package com.mine.mishi.mishi.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.util.Util;
import com.example.liangmutian.mypicker.DataPickerDialog;
import com.example.liangmutian.mypicker.DatePickerDialog;
import com.example.liangmutian.mypicker.DateUtil;
import com.mine.mishi.mishi.BuildConfig;
import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.base.BaseActivity;
import com.mine.mishi.mishi.databinding.ActivitySettingBinding;
import com.mine.mishi.mishi.utils.Constants;
import com.mine.mishi.mishi.utils.InfoPrefs;
import com.mine.mishi.mishi.utils.PictureUtil;
import com.mine.mishi.mishi.view.CustomDatePicker;
import com.mine.mishi.mishi.view.PhotoPopupWindow;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "SettingActivity";
    private ActivitySettingBinding binding;

    private CustomDatePicker customDatePicker;
    private String now;
    PhotoPopupWindow mPhotoPopupWindow;
    private Dialog dateDialog, timeDialog, chooseDialog;
    private List<String> list = new ArrayList<>();

    private static final int REQUEST_PERMISSIONS = 1000;
    private static final int REQUEST_IMAGE_GET = 1003;
    private static final int REQUEST_IMAGE_CAPTURE = 1001;
    private static final int REQUEST_SMALL_IMAGE_CUTTING = 1002;
    private static final int REQUEST_CHANGE_USER_NICK_NAME = 1010;
    private static final String IMAGE_FILE_NAME = "user_head_icon.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_setting);
        initView();
        InfoPrefs.init("user_info");
    }



    private void initView() {
        binding.llHead.setOnClickListener(this);
        binding.llAbout.setOnClickListener(this);
        binding.llBirthday.setOnClickListener(this);
        binding.llClear.setOnClickListener(this);
        binding.llDesc.setOnClickListener(this);
        binding.llName.setOnClickListener(this);
        binding.llSex.setOnClickListener(this);
        binding.llMobile.setOnClickListener(this);
        binding.outLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_head:
                initPermission();
                break;
            case R.id.ll_about:
                break;
            case R.id.ll_birthday:
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                //获取当前时间
                now = sdf.format(new Date());

                if (TextUtils.isEmpty(binding.birthday.getText().toString().trim())) {
                    showDateDialog(DateUtil.getDateForString(now));
                }else { // 日期格式为yyyy-MM-dd
                    showDateDialog(DateUtil.getDateForString(binding.birthday.getText().toString()));
                }
                break;
            case R.id.ll_clear:
                break;
            case R.id.ll_desc:
                gotoActivity(this,SettingPersonDescActivity.class,null);
                break;
            case R.id.ll_name:
                gotoActivity(this,SettingNameActivity.class,null);
                break;
            case R.id.ll_sex:
                list.clear();
                String[] data = getResources().getStringArray(R.array.list);
                for (String str : data) {
                    list.add(str);
                }
                showChooseDialog(list);
                break;
            case R.id.ll_mobile:
                gotoActivity(this,SettingMobileActivity.class,null);
                break;
            case R.id.out_login:
                break;
        }
    }


    private void showDateDialog(List<Integer> date) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {

                binding.birthday.setText(dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                        + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));

            }

            @Override
            public void onCancel() {

            }
        })

                .setSelectYear(date.get(0) - 1)
                .setSelectMonth(date.get(1) - 1)
                .setSelectDay(date.get(2) - 1);

        builder.setMaxYear(DateUtil.getYear());
        builder.setMaxMonth(DateUtil.getDateForString(DateUtil.getToday()).get(1));
        builder.setMaxDay(DateUtil.getDateForString(DateUtil.getToday()).get(2));
        dateDialog = builder.create();
        dateDialog.show();
    }

    private void showChooseDialog(List<String> mlist) {
        DataPickerDialog.Builder builder = new DataPickerDialog.Builder(this);
        chooseDialog = builder.setData(mlist).setSelection(1).setTitle("取消")
                .setOnDataSelectedListener(new DataPickerDialog.OnDataSelectedListener() {
                    @Override
                    public void onDataSelected(String itemValue, int position) {
                        binding.sex.setText(itemValue);

                    }

                    @Override
                    public void onCancel() {

                    }
                }).create();

        chooseDialog.show();
    }

    /**
     * 初始化相机相关权限
     * 适配6.0+手机的运行时权限
     */
    private void initPermission() {
        /*String[] permissions = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};
        //检查权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // 之前拒绝了权限，但没有点击 不再询问 这个时候让它继续请求权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                Toast.makeText(this, "用户曾拒绝打开相机权限", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSIONS);
            } else {
                //注册相机权限
                ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSIONS);
            }
        }*/
        //创建存放头像的文件夹
        PictureUtil.mkdirMyPetRootDirectory();
        mPhotoPopupWindow = new PhotoPopupWindow(SettingActivity.this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 文件权限申请
                if (ContextCompat.checkSelfPermission(SettingActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // 权限还没有授予，进行申请
                    ActivityCompat.requestPermissions(SettingActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200); // 申请的 requestCode 为 200
                } else {
                    // 如果权限已经申请过，直接进行图片选择
                    mPhotoPopupWindow.dismiss();
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    // 判断系统中是否有处理该 Intent 的 Activity
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, REQUEST_IMAGE_GET);
                    } else {
                        Toast.makeText(SettingActivity.this, "未找到图片查看器", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                // 拍照及文件权限申请
                if (ContextCompat.checkSelfPermission(SettingActivity.this,
                        Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(SettingActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // 权限还没有授予，进行申请
                    ActivityCompat.requestPermissions(SettingActivity.this,
                            new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 300); // 申请的 requestCode 为 300
                } else {
                    // 权限已经申请，直接拍照
                    mPhotoPopupWindow.dismiss();
                    imageCapture();
                }
            }
        });
        View rootView = LayoutInflater.from(SettingActivity.this).inflate(R.layout.activity_setting, null);
        mPhotoPopupWindow.showAtLocation(rootView,
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    private void showHeadImage() {
        boolean isSdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);// 判断sdcard是否存在
        if (isSdCardExist) {

            String path = InfoPrefs.getData(Constants.UserInfo.HEAD_IMAGE);// 获取图片路径

            File file = new File(path);
            if (file.exists()) {
                Bitmap bm = BitmapFactory.decodeFile(path);
                // 将图片显示到ImageView中
                binding.head.setImageBitmap(bm);
            }else{
                Log.e(TAG,"no file");
                binding.head.setImageResource(R.mipmap.ic_launcher);
            }
        } else {
            Log.e(TAG,"no SD card");
            binding.head.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 回调成功
        if (resultCode == RESULT_OK) {
            switch (requestCode) {

                // 切割
                case REQUEST_SMALL_IMAGE_CUTTING:
                    Log.e(TAG,"before show");
                    File cropFile = new File(PictureUtil.getMyPetRootDirectory(),"crop.jpg");

                    Uri cropUri = Uri.fromFile(cropFile);
                    setPicToView(cropUri);
                    break;

                // 相册选取
                case REQUEST_IMAGE_GET:
                    Uri uri= PictureUtil.getImageUri(this,data);
                    startPhotoZoom(uri);
                    break;

                // 拍照
                case REQUEST_IMAGE_CAPTURE:
                    File pictureFile = new File(PictureUtil.getMyPetRootDirectory(), IMAGE_FILE_NAME);
                    Uri pictureUri;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        pictureUri = FileProvider.getUriForFile(this,
                                BuildConfig.APPLICATION_ID + ".fileprovider", pictureFile);
                        Log.e(TAG,"picURI=" + pictureUri.toString());
                    } else {
                        pictureUri = Uri.fromFile(pictureFile);
                    }
                    startPhotoZoom(pictureUri);
                    break;

                case REQUEST_CHANGE_USER_NICK_NAME:
                    String returnData = data.getStringExtra("data_return");
                    InfoPrefs.setData(Constants.UserInfo.NAME,returnData);
                    //textView_user_nick_name.setText(InfoPrefs.getData(Constants.UserInfo.NAME));
                    break;
                default:
            }
        }else{
            Log.e(TAG,"result = "+resultCode+",request = "+requestCode);
        }
    }

    private void showHeadImage(File cropFile) {
        Glide.with(mContext)
                .load(Uri.fromFile(cropFile))
                .asBitmap()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(new BitmapImageViewTarget(binding.head){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(5); //设置圆角弧度
                        binding.head.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    private void startPhotoZoom(Uri uri) {
        Log.d(TAG,"Uri = "+uri.toString());
        //保存裁剪后的图片
        File cropFile=new File(PictureUtil.getMyPetRootDirectory(),"crop.jpg");
        try{
            if(cropFile.exists()){
                cropFile.delete();
                Log.e(TAG,"delete");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        Uri cropUri;
        cropUri = Uri.fromFile(cropFile);

        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1); // 裁剪框比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300); // 输出图片大小
        intent.putExtra("outputY", 300);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", false);

        Log.e(TAG,"cropUri = "+cropUri.toString());

        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        startActivityForResult(intent, REQUEST_SMALL_IMAGE_CUTTING);

    }

    /** public void startBigPhotoZoom(Uri uri) {
     // 创建大图文件夹
     Uri imageUri = null;
     File file;
     if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
     String storage = Environment.getExternalStorageDirectory().getPath();
     File dirFile = new File(storage + "/bigIcon");
     if (!dirFile.exists()) {
     if (!dirFile.mkdirs()) {
     Log.e("TAG", "文件夹创建失败");
     } else {
     Log.e("TAG", "文件夹创建成功");
     }
     }
     file = new File(dirFile, System.currentTimeMillis() + ".jpg");
     imageUri = Uri.fromFile(file);
     }
     // 开始切割
     Intent intent = new Intent("com.android.camera.action.CROP");
     //intent.setDataAndType(uri, "image/*");
     intent.setDataAndType(FileProvider.getUriForFile(this,"com.example.mypet.fileprovider",file),"image/*");
     intent.putExtra("crop", "true");
     intent.putExtra("aspectX", 1); // 裁剪框比例
     intent.putExtra("aspectY", 1);
     intent.putExtra("outputX", 600); // 输出图片大小
     intent.putExtra("outputY", 600);
     intent.putExtra("scale", true);
     intent.putExtra("return-data", false); // 不直接返回数据
     intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri); // 返回一个文件
     intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
     startActivityForResult(intent, REQUEST_BIG_IMAGE_CUTTING);
     }*/

    private void imageCapture() {
        Intent intent;
        Uri pictureUri;
        //getMyPetRootDirectory()得到的是Environment.getExternalStorageDirectory() + File.separator+"MyPet"
        //也就是我之前创建的存放头像的文件夹（目录）
        File pictureFile = new File(PictureUtil.getMyPetRootDirectory(), IMAGE_FILE_NAME);
        // 判断当前系统
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //这一句非常重要
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            //""中的内容是随意的，但最好用package名.provider名的形式，清晰明了
            pictureUri = FileProvider.getUriForFile(this,
                    BuildConfig.APPLICATION_ID + ".fileprovider", pictureFile);
        } else {
            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            pictureUri = Uri.fromFile(pictureFile);
        }
        // 去拍照,拍照的结果存到oictureUri对应的路径中
        intent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
        Log.e(TAG,"before take photo"+pictureUri.toString());
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    public void setPicToView(Uri uri)  {
        if (uri != null) {
            Bitmap photo = null;
            try {
                photo = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            // 创建 smallIcon 文件夹
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                //String storage = Environment.getExternalStorageDirectory().getPath();
                File dirFile = new File(PictureUtil.getMyPetRootDirectory(),  "Icon");
                if (!dirFile.exists()) {
                    if (!dirFile.mkdirs()) {
                        Log.d(TAG, "in setPicToView->文件夹创建失败");
                    } else {
                        Log.d(TAG, "in setPicToView->文件夹创建成功");
                    }
                }
                File file = new File(dirFile, IMAGE_FILE_NAME);
                InfoPrefs.setData(Constants.UserInfo.HEAD_IMAGE,file.getPath());
                Log.d("result",file.getPath());
                 Log.d("result",file.getAbsolutePath());
                // 保存图片
                if (file.exists()){
                    file.delete();
                }
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(file);
                    photo.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //showHeadImage(file);
            }

            // 在视图中显示图片
            showHeadImage();
            //circleImageView_user_head.setImageBitmap(InfoPrefs.getData(Constants.UserInfo.GEAD_IMAGE));
        }
    }

    /**public void setPicToView(Intent data) {
     Bundle extras = data.getExtras();
     if (extras != null) {
     Bitmap photo = extras.getParcelable("data"); // 直接获得内存中保存的 bitmap
     // 创建 smallIcon 文件夹
     if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
     //String storage = Environment.getExternalStorageDirectory().getPath();
     File dirFile = new File(PictureUtil.getMyPetRootDirectory(),  "Icon");
     if (!dirFile.exists()) {
     if (!dirFile.mkdirs()) {
     Log.d(TAG, "in setPicToView->文件夹创建失败");
     } else {
     Log.d(TAG, "in setPicToView->文件夹创建成功");
     }
     }
     File file = new File(dirFile, IMAGE_FILE_NAME);
     InfoPrefs.setData(Constants.UserInfo.HEAD_IMAGE,file.getPath());
     //Log.d("result",file.getPath());
     // Log.d("result",file.getAbsolutePath());
     // 保存图片
     FileOutputStream outputStream = null;
     try {
     outputStream = new FileOutputStream(file);
     photo.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
     outputStream.flush();
     outputStream.close();
     } catch (Exception e) {
     e.printStackTrace();
     }
     }
     // 在视图中显示图片
     showHeadImage();
     //circleImageView_user_head.setImageBitmap(InfoPrefs.getData(Constants.UserInfo.GEAD_IMAGE));
     }
     }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 200:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mPhotoPopupWindow.dismiss();
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    // 判断系统中是否有处理该 Intent 的 Activity
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, REQUEST_IMAGE_GET);
                    } else {
                        Toast.makeText(SettingActivity.this, "未找到图片查看器", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    mPhotoPopupWindow.dismiss();
                }
                break;
            case 300:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mPhotoPopupWindow.dismiss();
                    imageCapture();
                } else {
                    mPhotoPopupWindow.dismiss();
                }
                break;
        }
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



    @Subscribe(threadMode = ThreadMode.POSTING)
    public void getMessage(String message){
        Log.d(TAG,message);
    }


}

package com.mine.mishi.mishi.url;

import android.util.Log;

import com.google.gson.Gson;
import com.mine.mishi.mishi.HttpRequestLocal.HttpLogin;
import com.mine.mishi.mishi.HttpRequestLocal.HttpNoteSIMPort;
import com.mine.mishi.mishi.HttpRequestLocal.HttpRequestBase;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSGdetalis;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSMyOrder;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSiscoveryH;
import com.mine.mishi.mishi.bean.BaseRequest;
import com.mine.mishi.mishi.bean.SGdetalis;
import com.mine.mishi.mishi.bean.SMyOrder;
import com.mine.mishi.mishi.bean.SiscoveryH;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okio.Buffer;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by liush on 2019/2/28.
 */

public class RetrofitLoader extends ObjectLoader {
    private RetrofitService mRetrofitService;
    Gson gson;
    public RetrofitLoader() {
        mRetrofitService = RetrofitServiceManager.getInstance().create(RetrofitService.class);
        gson = new Gson();
    }

    private void printRequestJson(String methodName, HttpRequestBase json){
        Log.e(methodName + "------>responseJson",gson.toJson(json));
        //RequestBody requestBody= request.body();
        /*Buffer buffer = new Buffer();
        try {
            requestBody.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
           *//* MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }*//*
            String paramsStr = buffer.readString(charset);
            Log.e(methodName + "------>requestJson",paramsStr);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    private void printResponseJson(String methodName, String json){
        Log.e(methodName + "------>responseJson",json);


    }


    public Observable<BaseRequest<String>> goVer(HttpNoteSIMPort requestBody) {
        printRequestJson("goVer", requestBody);
        return observe(mRetrofitService.getVer(requestBody)
                .map(new Func1<BaseRequest<String>, BaseRequest<String>>() {
                    @Override
                    public BaseRequest<String> call(BaseRequest<String> stringBaseRequest) {
                        printResponseJson("goVer", gson.toJson(stringBaseRequest));
                        return stringBaseRequest;
                    }
                })
        );

    }



    public Observable<BaseRequest<String>> goLogin(HttpLogin requestBody) {
        printRequestJson("goLogin", requestBody);
        return observe(mRetrofitService.goLogin(requestBody)
                .map(new Func1<BaseRequest<String>, BaseRequest<String>>() {
                    @Override
                    public BaseRequest<String> call(BaseRequest<String> stringBaseRequest) {
                        printResponseJson("goLogin", gson.toJson(stringBaseRequest));
                        return stringBaseRequest;
                    }
                })
        );

    }



    public Observable<BaseRequest<List<SiscoveryH>>> getSiscoveryH(HttpSiscoveryH requestBody){
        printRequestJson("getSiscoveryH", requestBody);
        return observe(mRetrofitService.getSiscoveryH(requestBody).map(new Func1<BaseRequest<List<SiscoveryH>>, BaseRequest<List<SiscoveryH>>>() {
            @Override
            public BaseRequest<List<SiscoveryH>> call(BaseRequest<List<SiscoveryH>> listBaseRequest) {
                printResponseJson("getSiscoveryH",gson.toJson(listBaseRequest));
                return listBaseRequest;
            }
        }));
    }

    public Observable<BaseRequest<List<SMyOrder>>> getSMyOrder(HttpSMyOrder requestBody){
        printRequestJson("getSMyOrder" ,requestBody);
        return observe(mRetrofitService.getSMyOrder(requestBody).map(
                new Func1<BaseRequest<List<SMyOrder>>, BaseRequest<List<SMyOrder>>>() {
                    @Override
                    public BaseRequest<List<SMyOrder>> call(BaseRequest<List<SMyOrder>> listBaseRequest) {
                        printResponseJson("getSMyOrder",gson.toJson(listBaseRequest));
                        return listBaseRequest;
                    }
                }));
    }

    public Observable<BaseRequest<SGdetalis>> getSGdetalis(HttpSGdetalis requestBody){
        printRequestJson("getSGdetalis" ,requestBody);
        return observe(mRetrofitService.getSGdetalis(requestBody).map(
                new Func1<BaseRequest<SGdetalis>, BaseRequest<SGdetalis>>() {
                    @Override
                    public BaseRequest<SGdetalis> call(BaseRequest<SGdetalis> listBaseRequest) {
                        printResponseJson("getSGdetalis",gson.toJson(listBaseRequest));
                        return listBaseRequest;
                    }
                }));
    }
}
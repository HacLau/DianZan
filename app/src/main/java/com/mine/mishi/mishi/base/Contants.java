package com.mine.mishi.mishi.base;


import com.mine.mishi.mishi.R;
import com.mine.mishi.mishi.entity.CitySearchResultEntty;
import com.mine.mishi.mishi.entity.IndexSubEntity;
import com.mine.mishi.mishi.entity.MineMenuEntity;
import com.mine.mishi.mishi.entity.NewsInterfaceEntity;
import com.mine.mishi.mishi.entity.SecondSubEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/13.
 */

public class Contants {
    public static final List<String> tablayoutTitleList = new ArrayList<String>() {
        {
            add("推荐");
            add("网红");
            add("中餐");
            add("西餐");
            add("火锅");
            add("自助");
            add("日韩");
            add("欧美");
        }
    };

    public static final List<String> mineTitleList = new ArrayList<String>() {
        {
            add("我的笔记");
            add("我的收藏");
        }
    };
    public static final List<String> tabSecondTitleList = new ArrayList<String>() {
        {
            add("全部");
        }
    };
    public static final List<IndexSubEntity> indexEntityList = new ArrayList<IndexSubEntity>(){
        {
            IndexSubEntity beauty;
            for(int i = 0;i< 10;i++) {
                //String imageDesc, String imageIcon, String name, String headIcon, String likeNumber, String likeIcon
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。" + i, "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意" + i, "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb5ec036f.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb63e8117.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意" + i, "http://wx4.sinaimg.cn/large/7eff5f4dgy1ffe5b3bcg3j21hc0u0k0d.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/mobile/2019-01-08/5c346332dae71.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意" + i, "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cmngkbj21hc0xcq5j.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。" + i, "http://i0.article.fd.zol-img.com.cn/g5/M00/0D/0C/ChMkJlltpyeIN1l-AADUwKg_3ZwAAeycAHhuRwAANTY206.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cnknkrj21hc0xcacd.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://uploadfile.bizhizu.cn/2014/0226/20140226042643224.jpg.source.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。" + i, "http://b-ssl.duitang.com/uploads/item/201412/19/20141219132442_JTuSj.jpeg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);

            }
        }

    };

    public static final List<IndexSubEntity> indexEntityList1 = new ArrayList<IndexSubEntity>(){
        {
            IndexSubEntity beauty;
            for(int i = 0;i< 10;i++) {
                beauty = new IndexSubEntity("刘亦菲" + i, "http://uploadfile.bizhizu.cn/2014/0226/20140226042643224.jpg.source.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。" + i, "http://b-ssl.duitang.com/uploads/item/201412/19/20141219132442_JTuSj.jpeg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                //String imageDesc, String imageIcon, String name, String headIcon, String likeNumber, String likeIcon
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。" + i, "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意" + i, "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb5ec036f.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb63e8117.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意" + i, "http://wx4.sinaimg.cn/large/7eff5f4dgy1ffe5b3bcg3j21hc0u0k0d.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://pic1.win4000.com/mobile/2019-01-08/5c346332dae71.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意" + i, "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cmngkbj21hc0xcq5j.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("幸福其实真的很简单：有人爱;有事做;有所期待。" + i, "http://i0.article.fd.zol-img.com.cn/g5/M00/0D/0C/ChMkJlltpyeIN1l-AADUwKg_3ZwAAeycAHhuRwAANTY206.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);
                beauty = new IndexSubEntity("刘亦菲" + i, "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cnknkrj21hc0xcacd.jpg", "XXXXXXX" + i, R.mipmap.ic_launcher + "", "12" + i, R.mipmap.ic_launcher + "");
                add(beauty);


            }
        }

    };

    public static final List<SecondSubEntity> secondEntityList = new ArrayList<SecondSubEntity>(){
        {
            SecondSubEntity beauty;
            for (int i = 0; i < 10; i++) {
                //String imageDesc, String imageIcon, String name, String headIcon, String likeNumber, String likeIcon
                beauty = new SecondSubEntity("http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","伤禽恶弦惊，倦客恶离声。","北京" + i,"22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb5ec036f.jpg","离声断客情，宾御皆涕零。","海南" + i,"22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity( "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb63e8117.jpg","涕零心断绝，将去复还诀。","天津" + i, "22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://wx4.sinaimg.cn/large/7eff5f4dgy1ffe5b3bcg3j21hc0u0k0d.jpg","青山隐隐水迢迢，秋尽江南草未凋。","上海" + i,"22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://pic1.win4000.com/mobile/2019-01-08/5c346332dae71.jpg","众生视我为草木，唯你视我为青地声走。","黑龙江" + i,"22km","&12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity( "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cmngkbj21hc0xcq5j.jpg","就当花没开过也没败过，你没来过我也没爱过。","漠河" + i,"22km","&12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://i0.article.fd.zol-img.com.cn/g5/M00/0D/0C/ChMkJlltpyeIN1l-AADUwKg_3ZwAAeycAHhuRwAANTY206.jpg","幸福其实真的很简单：有人爱;有事做;有所期待。","英国" + i, "22km","$12" + i,"155");
                add(beauty);
                beauty = new SecondSubEntity( "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cnknkrj21hc0xcacd.jpg","在乎一个人不需要太多，只需要她心里有你!","印度" + i, "22km","$12" + i,"");
                add(beauty);
                beauty = new SecondSubEntity("http://uploadfile.bizhizu.cn/2014/0226/20140226042643224.jpg.source.jpg","我可以耐心等，幸福可以来的慢一些，只要它是真的!","泰国" + i, "22km","$12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://b-ssl.duitang.com/uploads/item/201412/19/20141219132442_JTuSj.jpeg","你在我心里最柔软的地方，也是最软弱的地方。","非洲" + i,"22km","$12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","月亮" + i,"22km","$12" + i,"150");
                add(beauty);


            }
        }
    };

    public static final List<SecondSubEntity> secondEntityList2 = new ArrayList<SecondSubEntity>(){
        {
            SecondSubEntity beauty;
            for (int i = 0; i < 10; i++) {
                //String imageDesc, String imageIcon, String name, String headIcon, String likeNumber, String likeIcon
                beauty = new SecondSubEntity("http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","伤禽恶弦惊，倦客恶离声。","新疆" + i,"22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb5ec036f.jpg","离声断客情，宾御皆涕零。","新疆" + i,"22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity( "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb63e8117.jpg","涕零心断绝，将去复还诀。","新疆" + i, "22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://wx4.sinaimg.cn/large/7eff5f4dgy1ffe5b3bcg3j21hc0u0k0d.jpg","青山隐隐水迢迢，秋尽江南草未凋。","新疆" + i,"22km","￥12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://pic1.win4000.com/mobile/2019-01-08/5c346332dae71.jpg","众生视我为草木，唯你视我为青地声走。","新疆" + i,"22km","&12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity( "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cmngkbj21hc0xcq5j.jpg","就当花没开过也没败过，你没来过我也没爱过。","新疆" + i,"22km","&12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://i0.article.fd.zol-img.com.cn/g5/M00/0D/0C/ChMkJlltpyeIN1l-AADUwKg_3ZwAAeycAHhuRwAANTY206.jpg","幸福其实真的很简单：有人爱;有事做;有所期待。","新疆" + i, "22km","$12" + i,"155");
                add(beauty);
                beauty = new SecondSubEntity( "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cnknkrj21hc0xcacd.jpg","在乎一个人不需要太多，只需要她心里有你!","新疆" + i, "22km","$12" + i,"");
                add(beauty);
                beauty = new SecondSubEntity("http://uploadfile.bizhizu.cn/2014/0226/20140226042643224.jpg.source.jpg","我可以耐心等，幸福可以来的慢一些，只要它是真的!","新疆" + i, "22km","$12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://b-ssl.duitang.com/uploads/item/201412/19/20141219132442_JTuSj.jpeg","你在我心里最柔软的地方，也是最软弱的地方。","新疆" + i,"22km","$12" + i,"150");
                add(beauty);
                beauty = new SecondSubEntity("http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","新疆" + i,"22km","$12" + i,"150");
                add(beauty);


            }
        }
    };

    public static final List<CitySearchResultEntty> cityImageList = new ArrayList<CitySearchResultEntty>(){
        {

            add(new CitySearchResultEntty("http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","北京"));
            add(new CitySearchResultEntty("http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg","上海"));
            add(new CitySearchResultEntty("http://uploadfile.bizhizu.cn/2014/0226/20140226042643224.jpg.source.jpg","天津"));
            add(new CitySearchResultEntty("http://pic1.win4000.com/mobile/2019-01-08/5c346332dae71.jpg","重庆"));


        }
    };

    public static final List<CitySearchResultEntty> cityTextList = new ArrayList<CitySearchResultEntty>(){
        {
            add(new CitySearchResultEntty("","北京"));
            add(new CitySearchResultEntty("","上海"));
            add(new CitySearchResultEntty("","天津"));
            add(new CitySearchResultEntty("","重庆"));
            add(new CitySearchResultEntty("","北京"));
            add(new CitySearchResultEntty("","上海"));
            add(new CitySearchResultEntty("","天津"));
            add(new CitySearchResultEntty("","重庆"));
            add(new CitySearchResultEntty("","北京"));
            add(new CitySearchResultEntty("","上海"));
            add(new CitySearchResultEntty("","天津"));
            add(new CitySearchResultEntty("","重庆"));
            add(new CitySearchResultEntty("","北京"));
            add(new CitySearchResultEntty("","上海"));
            add(new CitySearchResultEntty("","天津"));
            add(new CitySearchResultEntty("","重庆"));
            add(new CitySearchResultEntty("","北京"));
            add(new CitySearchResultEntty("","上海"));
            add(new CitySearchResultEntty("","天津"));
            add(new CitySearchResultEntty("","重庆"));


        }
    };

    public static final List<CitySearchResultEntty> cityHistoryList = new ArrayList<CitySearchResultEntty>(){
        {
            add(new CitySearchResultEntty("","北京"));
            add(new CitySearchResultEntty("","上海"));
            add(new CitySearchResultEntty("","天津"));
            add(new CitySearchResultEntty("","重庆"));
        }
    };


    public static final List<NewsInterfaceEntity> newsEntityList = new ArrayList<NewsInterfaceEntity>(){
        {
            NewsInterfaceEntity beauty;
            for (int i = 0; i < 10; i++) {
                //String imageDesc, String imageIcon, String name, String headIcon, String likeNumber, String likeIcon
                beauty = new NewsInterfaceEntity("http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","今天");
                add(beauty);
                beauty = new NewsInterfaceEntity("http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb5ec036f.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","今天");
                add(beauty);
                beauty = new NewsInterfaceEntity( "http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb63e8117.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","今天");
                add(beauty);
                beauty = new NewsInterfaceEntity("http://wx4.sinaimg.cn/large/7eff5f4dgy1ffe5b3bcg3j21hc0u0k0d.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","今天");
                add(beauty);
                beauty = new NewsInterfaceEntity("http://pic1.win4000.com/mobile/2019-01-08/5c346332dae71.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","今天");
                add(beauty);
                beauty = new NewsInterfaceEntity( "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cmngkbj21hc0xcq5j.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","今天");
                add(beauty);
                beauty = new NewsInterfaceEntity("http://i0.article.fd.zol-img.com.cn/g5/M00/0D/0C/ChMkJlltpyeIN1l-AADUwKg_3ZwAAeycAHhuRwAANTY206.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","今天");
                add(beauty);
                beauty = new NewsInterfaceEntity( "http://wx2.sinaimg.cn/large/7eff5f4dgy1ffe5cnknkrj21hc0xcacd.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","昨天");
                add(beauty);
                beauty = new NewsInterfaceEntity("http://uploadfile.bizhizu.cn/2014/0226/20140226042643224.jpg.source.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","昨天");
                add(beauty);
                beauty = new NewsInterfaceEntity("http://b-ssl.duitang.com/uploads/item/201412/19/20141219132442_JTuSj.jpeg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","昨天");
                add(beauty);
                beauty = new NewsInterfaceEntity("http://pic1.win4000.com/mobile/2018-01-13/5a59b24ea2f44.jpg","百度大佬","专一不是一辈子只喜欢一个人，而是喜欢一个人的时候一心一意。","http://pic1.win4000.com/wallpaper/2017-12-19/5a38bb622c7ad.jpg","前天");
                add(beauty);


            }
        }
    };

    public static final List<MineMenuEntity> mineEntityList = new ArrayList<MineMenuEntity>(){
        {
            add(new MineMenuEntity(R.mipmap.ic_launcher,"我的蜂蜜"));
            add(new MineMenuEntity(R.mipmap.ic_launcher,"我的订单"));
            add(new MineMenuEntity(R.mipmap.ic_launcher,"邀请有礼"));
        }
    };

    public static final List<String> orderTitleList = new ArrayList<String>() {
        {
            add("全部订单");
            add("待评价");
            add("待使用");
            add("退款中");
        }
    };



}

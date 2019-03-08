package com.mine.mishi.mishi.url;

import com.mine.mishi.mishi.HttpRequestLocal.HttpLogin;
import com.mine.mishi.mishi.HttpRequestLocal.HttpNoteSIMPort;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSGdetalis;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSMyOrder;
import com.mine.mishi.mishi.HttpRequestLocal.HttpSiscoveryH;
import com.mine.mishi.mishi.bean.BaseRequest;
import com.mine.mishi.mishi.bean.SGdetalis;
import com.mine.mishi.mishi.bean.SMyOrder;
import com.mine.mishi.mishi.bean.SiscoveryH;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by liush on 2019/2/28.
 */

public interface RetrofitService {
   /* @GET("top250")
    Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count")int count);*/


    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("delicious/Login/NoteSIMPort")
    Observable<BaseRequest<String>> getVer(@Body HttpNoteSIMPort route);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("delicious/Login/UserLoging")
    Observable<BaseRequest<String>> goLogin(@Body HttpLogin route);


    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("delicious/Goods/SiscoveryH")
    Observable<BaseRequest<List<SiscoveryH>>> getSiscoveryH(@Body HttpSiscoveryH route);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("delicious/Order/SMyOrder")
    Observable<BaseRequest<List<SMyOrder>>> getSMyOrder(@Body HttpSMyOrder route);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("delicious/Goods/SGdetalis")
    Observable<BaseRequest<SGdetalis>> getSGdetalis(@Body HttpSGdetalis route);

    /*@FormUrlEncoded
    @POST("/x3/weather")
    Observable<String> login(@FieldMap Map<String, String> options);*/
}

package com.lkl.ansuote.modulemodel.di.module;

import android.util.Log;

import com.blankj.utilcode.util.NetworkUtils;
import com.lkl.ansuote.modulemodel.BuildConfig;
import com.lkl.ansuote.modulemodel.base.ModelConstants;
import com.lkl.ansuote.modulemodel.core.http.api.Apis;
import com.lkl.ansuote.modulemodel.core.http.cookies.CookiesManager;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author huangdongqiang
 * @date 2018/4/3
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, Apis.HOST);
    }


    @Singleton
    @Provides
    Apis provideGeeksApi(Retrofit retrofit) {
        return retrofit.create(Apis.class);
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }


    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message ->
                    Log.i("lkl", "message = " + message));
            loggingInterceptor.setLevel(BuildConfig.DEBUG ?HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(ModelConstants.Companion.getPATH_CACHE());
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = chain -> {
            Request request = chain.request();
            //NetworkUtils.isConnected()
            //CommonUtils.isNetworkConnected()
            if (!NetworkUtils.isConnected()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (NetworkUtils.isConnected()) {
                int maxAge = 0;
                // 有网络时, 不缓存, 最大保存时长为0
                response.newBuilder()
                        //.header("Cache-Control", "public, max-age=" + maxAge)
                        //.header("Content-Type", "application/x-protobuf")
                        .removeHeader("Pragma")
                        .build();
            } else {
                int maxStale = Apis.MAX_STALE;
                response.newBuilder()
                        //.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        //.header("Content-Type", "application/x-protobuf")
                        .removeHeader("Pragma")
                        .build();
            }

            return response;
        };

        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        //增加数据校验拦截器
        //builder.addInterceptor(verifyInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(Apis.CONNECT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(Apis.READ_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(Apis.WRITE_TIME_OUT, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        //cookie认证
        builder.cookieJar(new CookiesManager());
        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.addConverterFactory(GsonConverterFactory.create())
                //.addConverterFactory(ProtoConverterFactory.create())
                .build();
    }
}

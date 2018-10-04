package com.weatherdetails.apis;

import com.weatherdetails.constant.NetworkConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class creates retrofit object and creates the retrofit services.
 * It also returns the retrofit callback.
 */
public class ApiManager {
    private static ApiManager sInstance;
    private static Retrofit mRetrofit;
    private static String mToken;

    public static ApiManager getInstance() {
        if (sInstance == null) {
            sInstance = new ApiManager();
        }
        return sInstance;
    }

    private ApiManager() {

    }

    public static <T> T createService(Class<T> service) {
        return getRetrofit().create(service);
    }

    public static Retrofit getRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(NetworkConstants.BASE_URL)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }

    public <RESULT> Callback<RESULT> addCallback(IResponseListener<RESULT> listener) {
        return new ApiCallback<RESULT>(listener);
    }

    private static OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder request = original.newBuilder()
                        .header("Content-Type", "application/json");
                if (mToken != null) {
                    request.header("authHash", mToken);
                }
                return chain.proceed(request.build());
            }
        });
        httpClient.readTimeout(NetworkConstants.TIME_OUT, TimeUnit.SECONDS);
        httpClient.connectTimeout(NetworkConstants.TIME_OUT, TimeUnit.SECONDS);
        httpClient.writeTimeout(NetworkConstants.TIME_OUT, TimeUnit.SECONDS);
        httpClient.retryOnConnectionFailure(true);
        return httpClient.build();
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String mToken) {
        this.mToken = mToken;
    }
}

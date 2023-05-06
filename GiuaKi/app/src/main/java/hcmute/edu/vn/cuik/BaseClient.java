package hcmute.edu.vn.cuik;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class BaseClient {
    private static HttpLoggingInterceptor sLogging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder sHttpClient = new OkHttpClient.Builder();
    static<S> S createService(Class<S> serviceClass, String baseUrl) {
        sHttpClient.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        if (!sHttpClient.interceptors().contains(sLogging)) {
            sHttpClient.addInterceptor(sLogging);
            builder.client(sHttpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }
}

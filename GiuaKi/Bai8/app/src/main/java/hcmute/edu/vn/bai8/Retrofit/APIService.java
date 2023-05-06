package hcmute.edu.vn.bai8.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("registrationapi.php?apicall=login")
    Call<ResponseBody> login (@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("registrationapi.php?apicall=signup")
    Call<ResponseBody> signup (@Field("username") String username, @Field("password") String password, @Field("email") String email, @Field("gender") String gender);
}

package hcmute.edu.vn.cuik;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
        @FormUrlEncoded
        @POST("register.php")
        Call<String> registerUser(@Field("first_name") String firstName,
                                  @Field("last_name") String lastName,
                                  @Field("email") String email,
                                  @Field("password") String password,
                                  @Field("username") String username,
                                  @Field("phone_number") String phoneNumber,
                                  @Field("address") String address);

        @POST("registrationapi.php?apicall=login")
        @FormUrlEncoded
        Call<ResponseBody> login(@Field("username") String username, @Field("password") String password);
}



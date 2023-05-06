package hcmute.edu.vn.bai8.Retrofit;

public class RetrofitClient extends BaseClient {
    private static final String BASE_URL = "http://app.iotstar.vn/shoppingapp/";
    private static APIService apiService;
    public static APIService getInstance() {
        if (apiService == null) return createService(APIService.class, BASE_URL);
        return apiService;
    }
//    private static Retrofit retrofit;
//
//    public static Retrofit getRetrofit() {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl("http://app.iotstar.vn/shoppingapp/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
}


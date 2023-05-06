package hcmute.edu.vn.cuik;

public class LoginClient extends BaseClient{
    private static final String BASE_URL = "http://app.iotstar.vn/shoppingapp/";

    private static APIService apiService;
    public static APIService getInstance() {
        if (apiService == null) return createService(APIService.class, BASE_URL);
        return apiService;
    }
}

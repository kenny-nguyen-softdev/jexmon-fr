package until;

public class Server {
    public static String localhost = "10.253.223.4";
    public static String Đuonganloaisp = "http://" + localhost + "/ch_tien_loi_api/getloaisp.php";
    public static String Đuongấnnphammoinhat = "http://" + localhost + "/ch_tien_loi_api/getsanpham.php";
    public static String Đuongandienthoai = "http://" + localhost + "/ch_tien_loi_api/gettheosp.php?page=";
    public static String Duongdandonhang = "http://" + localhost + "/ch_tien_loi_api/thongtinkhachhang.php";
    public static String Duongdanchitietdonhang = "http://" + localhost + "/ch_tien_loi_api/chitietdonhang.php";

    public static String loginRequestUrl = String.format("http://%s/ch_tien_loi_api/login.php", localhost);
    public static String regRequestUrl = String.format("http://%s/ch_tien_loi_api/reg.php", localhost);

}

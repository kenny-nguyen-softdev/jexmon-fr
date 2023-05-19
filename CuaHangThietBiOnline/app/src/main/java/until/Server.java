package until;

public class Server {
    public static String localhost = "172.17.20.35";
    public static String Đuonganloaisp = "http://" + localhost + "/jexmon-bk/getloaisp.php";
    public static String Đuongấnnphammoinhat = "http://" + localhost + "/jexmon-bk/getsanpham.php";
    public static String Đuongandienthoai = "http://" + localhost + "/jexmon-bk/gettheosp.php?page=";
    public static String Duongdandonhang = "http://" + localhost + "/jexmon-bk/thongtinkhachhang.php";
    public static String Duongdanchitietdonhang = "http://" + localhost + "/jexmon-bk/chitietdonhang.php";

    public static String loginRequestUrl = String.format("http://%s//jexmon-bk/login.php", localhost);
    public static String regRequestUrl = String.format("http://%s//jexmon-bk/reg.php", localhost);

}

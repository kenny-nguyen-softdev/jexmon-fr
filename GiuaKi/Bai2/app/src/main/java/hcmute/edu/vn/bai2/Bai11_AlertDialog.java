package hcmute.edu.vn.bai2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Bai11_AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }

    // tạo hộp thoại thông báo đơn giản
    private void showSimpleAlertDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        alert.setMessage("Bạn có muốn đăng xuất không?");
        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // xử lý khi người dùng chọn "Có"
            }
        });
        alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // xử lý khi người dùng chọn "Không"
            }
        });
        alert.show();
    }

    // tạo hộp thoại tùy chỉnh
    private void showCustomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(false);

        // ánh xạ các thành phần trong hộp thoại tùy chỉnh

        EditText editText1 = (EditText) dialog.findViewById(R.id.editNumber1);
        //...

        // viết code xử lý sự kiện cho các thành phần

        dialog.show();
    }
}
package hcmute.edu.vn.cuik;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private ProgressBar progressBar;
    private APIService apiService = LoginClient.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Nếu người dùng đã đăng nhập trước đó thì chuyển đến màn hình chính
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        // Khởi tạo các thành phần giao diện
        editTextUsername = findViewById(R.id.editusername);
        editTextPassword = findViewById(R.id.editpassword);
        Button buttonLogin = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progressBar);
        TextView textViewSignup = findViewById(R.id.textView10);

        // Xử lý sự kiện khi người dùng nhấn nút "Đăng nhập"
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        // Xử lý sự kiện khi người dùng nhấn vào chữ "Đăng ký"
//        textViewSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//                startActivity(new Intent(getApplicationContext(), SignupActivity.class));
//            }
//        });
        // Khởi tạo đối tượng APIService để gọi API
    }

    private void loginUser() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Kiểm tra người dùng đã nhập đầy đủ thông tin chưa
        if (TextUtils.isEmpty(username)) {
            editTextUsername.setError("Please enter your username");
            editTextUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter your password");
            editTextPassword.requestFocus();
            return;
        }

        // Gọi API để đăng nhập
        apiService.login(username, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject obj = new JSONObject(response.body().string());
                        Toast.makeText(LoginActivity.this, obj.getString("message"),Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Server error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
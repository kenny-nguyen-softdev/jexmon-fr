package hcmute.edu.vn.bai8.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import hcmute.edu.vn.bai8.R;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioGender;
    APIService apiService;
    private Button btnSignUp;
    private String pathImage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhXa();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        findViewById(R.id.textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

    }

    private void registerUser() {
        int selectedId = radioGroupGender.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioGender = (RadioButton) findViewById(selectedId);
        String userName = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String email = editTextName.getText().toString().trim();
        String gender = radioGender.getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            editTextUsername.setError("Please enter your username");
            editTextUsername.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Please enter your password");
            editTextPassword.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            editTextName.setError("Please enter your name");
            editTextName.requestFocus();
            return;
        }

        apiService = RetrofitClient.getInstance();
//        apiService = RetrofitClient.getRetrofit().create(APIService.class);
        apiService.signup(userName, password, email, gender).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, ProfileActivity.class));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void anhXa() {
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextName = (EditText) findViewById(R.id.editTextName);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroup);
        btnSignUp = (Button) findViewById(R.id.btnRegister);
    }
}

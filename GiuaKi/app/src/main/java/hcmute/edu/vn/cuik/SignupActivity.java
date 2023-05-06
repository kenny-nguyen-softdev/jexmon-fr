//package hcmute.edu.vn.cuik;
//
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class SignupActivity extends AppCompatActivity {
//
//    private APIService apiService;
//    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword, editTextUsername, editTextPhoneNumber, editTextAddress;
//    private Button buttonSignup;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signup);
//
//        editTextFirstName = findViewById(R.id.editTextFirstName);
//        editTextLastName = findViewById(R.id.editTextLastName);
//        editTextEmail = findViewById(R.id.editTextEmail);
//        editTextPassword = findViewById(R.id.editTextPassword);
//        editTextUsername = findViewById(R.id.editTextUserName);
//        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
//        editTextAddress = findViewById(R.id.editTextAdress);
//        buttonSignup = findViewById(R.id.btn_sign_up);
//
//        buttonSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                registerUser();
//            }
//        });
//    }
//
//    private void registerUser() {
//        String firstName = editTextFirstName.getText().toString().trim();
//        String lastName = editTextLastName.getText().toString().trim();
//        String email = editTextEmail.getText().toString().trim();
//        String password = editTextPassword.getText().toString().trim();
//        String username = editTextUsername.getText().toString().trim();
//        String phoneNumber = editTextPhoneNumber.getText().toString().trim();
//        String address = editTextAddress.getText().toString().trim();
//
//        if (TextUtils.isEmpty(firstName)) {
//            editTextFirstName.setError("Please enter your first name");
//            editTextFirstName.requestFocus();
//            return;
//        }
//        if (TextUtils.isEmpty(lastName)) {
//            editTextLastName.setError("Please enter your last name");
//            editTextLastName.requestFocus();
//            return;
//        }
//        if (TextUtils.isEmpty(email)) {
//            editTextEmail.setError("Please enter your email");
//            editTextEmail.requestFocus();
//            return;
//        }
//        if (TextUtils.isEmpty(password)) {
//            editTextPassword.setError("Please enter your password");
//            editTextPassword.requestFocus();
//            return;
//        }
//        if (TextUtils.isEmpty(username)) {
//            editTextUsername.setError("Please enter your username");
//            editTextUsername.requestFocus();
//            return;
//        }
//        if (TextUtils.isEmpty(phoneNumber)) {
//            editTextPhoneNumber.setError("Please enter your phone number");
//            editTextPhoneNumber.requestFocus();
//            return;
//        }
//
//        // create new user
//        User user = new User(firstName, lastName, email, password, username, phoneNumber, address);
//        // call API to register user
//        apiService = RetrofitClient2.getRetrofit().registerUser(APIService.class);
//        Call<String> call = apiService.registerUser(user);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                // show response message
//                Toast.makeText(SignupActivity.this, response.body(), Toast.LENGTH_SHORT).show();
//                if (response.isSuccessful()) {
//                    // start MainActivity
//                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                // show error message
//                Toast.makeText(SignupActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

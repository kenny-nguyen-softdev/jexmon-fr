package hcmute.edu.vn.bai8.Volley;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

import hcmute.edu.vn.bai8.Contants;
import hcmute.edu.vn.bai8.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioGender;
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
        // get selected radio button from radioGroup
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
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Contants.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(RegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, ProfileActivity.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("username", userName);
                map.put("password", password);
                map.put("email", email);
                map.put("gender", gender);
                return map;
            }
        };
        VolleySingle.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void anhXa() {
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextName = (EditText) findViewById(R.id.editTextName);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroup);
        btnSignUp = (Button) findViewById(R.id.btnRegister);
    }
}

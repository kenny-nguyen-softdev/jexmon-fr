package hcmute.edu.vn.bai6;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivitySharedPreferenceActivity_V1 extends AppCompatActivity {

    Button buttonTxt;
    EditText usernameTxt, passwordTxt;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference_v1);
        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        usernameTxt.setText(sharedPreferences.getString("username", ""));
        passwordTxt.setText(sharedPreferences.getString("password", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        buttonTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();

                if (username.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivitySharedPreferenceActivity_V1.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    if (cbRemember.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }
                    else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.commit();
                    }
                }
                else {
                    Toast.makeText(MainActivitySharedPreferenceActivity_V1.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        buttonTxt = (Button) findViewById(R.id.buttonTxt);
        usernameTxt = (EditText) findViewById(R.id.usernameTxt);
        passwordTxt = (EditText) findViewById(R.id.passwordTxt);
        cbRemember = (CheckBox) findViewById(R.id.cbmemberme);
    }
}

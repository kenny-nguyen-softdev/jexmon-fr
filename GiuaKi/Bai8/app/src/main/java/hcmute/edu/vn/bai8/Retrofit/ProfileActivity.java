package hcmute.edu.vn.bai8.Retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.bai8.R;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    TextView id;
    TextView userName;
    TextView userEmail;
    TextView gender;
    Button btnLogout;
    ImageView imageViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            id = findViewById(R.id.textViewId);
            userName = findViewById(R.id.textViewUserName);
            userEmail = findViewById(R.id.textViewEmail);
            gender = findViewById(R.id.textViewGender);
            btnLogout = findViewById(R.id.buttonLogout);
            imageViewProfile = findViewById(R.id.imageViewProfile);
            User user = SharedPrefManager.getInstance(this).getUser();
            id.setText(String.valueOf(user.getId()));
            userName.setText(user.getName());
            userEmail.setText(user.getEmail());
            gender.setText(user.getGender());
//            Glide.with(getApplicationContext())
//                    .load(user.getImages())
//                    .into(imageViewProfile);

            btnLogout.setOnClickListener(this);
        }
        else {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        SharedPrefManager.getInstance(getApplicationContext()).logout();
        finish();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }
}

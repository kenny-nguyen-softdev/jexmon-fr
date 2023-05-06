package hcmute.edu.vn.bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai3_ImageButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img1= (ImageView)
                findViewById(R.id.imageView1);
        ImageButton img2 = (ImageButton)
                findViewById(R.id.imageButton1);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.dart);
                img1.getLayoutParams().width=550;
                img1.getLayoutParams().height=550;
            }
        });
    }
}
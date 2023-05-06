package hcmute.edu.vn.bai2;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai1_ImageView extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ImageView img1= (ImageView)
                    findViewById(R.id.imageView1);
            img1.setImageResource(R.drawable.kotlin);
        }
    }

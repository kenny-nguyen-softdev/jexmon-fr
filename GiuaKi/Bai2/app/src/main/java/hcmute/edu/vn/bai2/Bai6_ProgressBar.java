package hcmute.edu.vn.bai2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bai6_ProgressBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton img2 = (ImageButton)
                findViewById(R.id.imageButton1);
        //progrebar
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//tự đếm progress
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
//chạy đều đều >100 quay về 0
                        if (current>= progressBar.getMax()){
                            current=0;
                        }
                        progressBar.setProgress(current + 10); //thiết lập progress
                    }
                    @Override
                    public void onFinish() {
                        Toast.makeText(Bai6_ProgressBar.this,"Hết giờ",Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }
}

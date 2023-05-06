package hcmute.edu.vn.bai8.loadactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import hcmute.edu.vn.bai8.R;
import hcmute.edu.vn.bai8.loadmoredata.MainActivity;


public class IntroActivity extends AppCompatActivity {
    private ConstraintLayout btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // hide title bar
        getSupportActionBar().hide();

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                int n = 0;
                try {
                    do {
                        if (n >= 2000) {
                            IntroActivity.this.finish();
                            Intent intent = new Intent(IntroActivity.this.getApplicationContext(), MainActivity.class);
                            IntroActivity.this.startActivity(intent);
                            return;
                        }
                        Thread.sleep((long) 100);
                        n += 100;
                    } while(true);
                } catch (InterruptedException e) {
                    IntroActivity.this.finish();
                    Intent intent = new Intent(IntroActivity.this.getApplicationContext(), MainActivity.class);
                    IntroActivity.this.startActivity(intent);
                    return;
                } catch (Throwable throwable) {
                    IntroActivity.this.finish();
                    Intent intent = new Intent(IntroActivity.this.getApplicationContext(), MainActivity.class);
                    IntroActivity.this.startActivity(intent);
                    throw throwable;
                }
            }
        }).start();
    }
}
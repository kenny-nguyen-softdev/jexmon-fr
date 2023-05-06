package hcmute.edu.vn.bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtSoN;
    private Button btnRnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSoN = (TextView) findViewById(R.id.textView);
        btnRnd = (Button) findViewById(R.id.buttonR);
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int number = random.nextInt(10);
                txtSoN.setText(number + ""); //number + ""
            }
        });
    }
}
package hcmute.edu.vn.bai2;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bai4_Switch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //switch
        Switch sw = (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ //isChecked = true
                    Toast.makeText(Bai4_Switch.this,"Wifi đang bật",Toast.LENGTH_LONG).show();}
                else{
                    Toast.makeText(Bai4_Switch.this,"Wifi đang tắt",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
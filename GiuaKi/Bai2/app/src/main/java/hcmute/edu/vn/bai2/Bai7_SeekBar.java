package hcmute.edu.vn.bai2;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class Bai7_SeekBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Seekbar
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//progress: giá trị của seekbar
                Log.d("AAA","Giá trị:" + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Start");
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("AAA","Stop");
            }});
    }
}

package hcmute.edu.vn.bai8.asynctask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.bai8.R;

public class AsyncTaskActivity extends AppCompatActivity {
    Button btnStart;
    MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        btnStart = findViewById(R.id.btnBegin);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAsyncTask = new MyAsyncTask(AsyncTaskActivity.this);
                myAsyncTask.execute();
            }
        });
    }
}
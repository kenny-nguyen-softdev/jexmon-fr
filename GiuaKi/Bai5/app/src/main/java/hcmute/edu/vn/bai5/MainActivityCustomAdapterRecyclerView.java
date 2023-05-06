package hcmute.edu.vn.bai5;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityCustomAdapterRecyclerView extends AppCompatActivity {

    public static final String TAG = "MainActivityCustomAdapterRecyclerView";
    private RecyclerView rvMultiViewType;
    private List<Object> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // hide status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        createData();

        UserAdapter adapter = new UserAdapter(this, mData);
        this.rvMultiViewType.setAdapter(adapter);
        rvMultiViewType.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
    private void createData() {
        this.rvMultiViewType = (RecyclerView) findViewById(R.id.rv_multiple_view_type);
        this.mData = new ArrayList<>();
        this.mData.add(new UserModel("Nguyen Van Nghia", "Quan 11"));
        this.mData.add(R.drawable.profile);
        this.mData.add("Text 0");
        this.mData.add("Text 1");


        this.mData.add(new UserModel("Nguyen Hoang Minh", "Quan 3"));
        this.mData.add("Text 2");
        this.mData.add(R.drawable.profile);
        this.mData.add(R.drawable.profile);

        this.mData.add(new UserModel("Nguyen Van Nam", "Quan 2"));
        this.mData.add("Text 3");
        this.mData.add("Text 4");

        this.mData.add(new UserModel("Nguyen Van Hoa", "Quan 1"));
        this.mData.add(R.drawable.profile);
    }
}

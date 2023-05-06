package hcmute.edu.vn.bai6;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.LinearLayoutManager;



import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.bai6.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements ListUserAdapter.OnItemClickListener {

    public ObservableField<String> title = new ObservableField<>("Home");
    private ListUserAdapter listUserAdapter;
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // hide status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setHome(this);
        setData();
        binding.rcView.setLayoutManager(new LinearLayoutManager(this));
        binding.rcView.setAdapter(listUserAdapter);
        listUserAdapter.setOnItemClickListener(this);

    }

    private void setData() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();

            user.setFirstName("Quoc" + i);
            user.setLastName("Toan" + i);
            userList.add(user);
        }
        listUserAdapter = new ListUserAdapter(userList);
    }

    @Override
    public void itemClick(User user) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}

package hcmute.edu.vn.bai5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class MainActivityAnimation extends AppCompatActivity {

    private Button btnAddItem;
    private RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_main);
        btnAddItem = findViewById(R.id.btn_add_item);
        rvItems = findViewById(R.id.rv_items);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add("Item " + i);
        }

        final CustomAnimationAdapter adapter = new CustomAnimationAdapter(data);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        rvItems.setItemAnimator(new DefaultItemAnimator());

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem("New Item");
                rvItems.scrollToPosition(adapter.getItemCount() - 1);
            }
        });
    }
}

package hcmute.edu.vn.bai5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityListView extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> arrayList = null;
    private ArrayAdapter adapter;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnUpdate;
    private EditText editText;
    private int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_demo);

        // hide status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        createData();
        adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                this.arrayList
        );
        this.listView.setAdapter(adapter);

        // onclick on each item
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivityListView.this, "You are press: " + arrayList.get(i), Toast.LENGTH_SHORT).show();
                editText.setText(arrayList.get(i));
                pos = i;
            }
        });

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = editText.getText().toString();
                arrayList.add(subject);
                adapter.notifyDataSetChanged();
            }
        });

        this.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(pos, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        this.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void createData() {
        this.listView = findViewById(R.id.listView);
        this.btnAdd = findViewById(R.id.btnAdd);
        this.btnDelete = findViewById(R.id.btnDelete);
        this.btnUpdate = findViewById(R.id.btnUpdate);
        this.editText = findViewById(R.id.editText);


        arrayList = new ArrayList<>();

        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("Kotlin");
        arrayList.add("Flutter");
        arrayList.add("Dart");
    }
}


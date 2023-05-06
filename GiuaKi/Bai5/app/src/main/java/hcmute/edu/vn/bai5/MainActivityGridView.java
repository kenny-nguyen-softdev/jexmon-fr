package hcmute.edu.vn.bai5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityGridView extends AppCompatActivity {

    private ArrayList<String> arrayList = null;

    private GridView gridView;

    private ArrayAdapter adapter;

    private Button btnAdd;
    private Button btnDelete;
    private Button btnUpdate;
    private EditText editText;

    private int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_demo);

        // hide status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        createData();
        this.adapter = new ArrayAdapter(
                MainActivityGridView.this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
        this.gridView.setAdapter(adapter);

        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivityGridView.this, "You are press: " + arrayList.get(i), Toast.LENGTH_SHORT).show();
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
                String subject = editText.getText().toString();
                arrayList.set(pos, subject);
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
        this.gridView = (GridView) findViewById(R.id.gridView);
        this.editText = (EditText) findViewById(R.id.editText);
        this.btnAdd = (Button) findViewById(R.id.btnAdd);
        this.btnDelete = (Button) findViewById(R.id.btnDelete);
        this.btnUpdate = (Button) findViewById(R.id.btnUpdate);

        arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");
    }

}
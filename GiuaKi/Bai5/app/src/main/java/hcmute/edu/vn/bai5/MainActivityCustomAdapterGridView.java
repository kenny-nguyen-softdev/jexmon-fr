package hcmute.edu.vn.bai5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivityCustomAdapterGridView extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<MonHoc> arrayList = null;
    private MonHocAdapter adapter;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnUpdate;
    private TextView txtName;
    private TextView txtDesc;
    private ImageView imagePic;
    private int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_custom);

        // hide status bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        createData();
        adapter = new MonHocAdapter(
                MainActivityCustomAdapterGridView.this,
                R.layout.row_monhoc_gridview,
                arrayList
        );
        this.gridView.setAdapter(adapter);

        // onclick on each item
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivityCustomAdapterGridView.this, "You are press: " + arrayList.get(i), Toast.LENGTH_SHORT).show();
                txtName.setText(arrayList.get(i).getName());
                txtDesc.setText(arrayList.get(i).getDesc());
                imagePic.setImageResource(arrayList.get(i).getPic());
                pos = i;
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
        this.gridView = findViewById(R.id.gridView);
        this.btnAdd = findViewById(R.id.btnAdd);
        this.btnDelete = findViewById(R.id.btnDelete);
        this.btnUpdate = findViewById(R.id.btnUpdate);

        this.txtName = findViewById(R.id.txtName);
        this.txtDesc = findViewById(R.id.txtDesc);
        this.imagePic = findViewById(R.id.imagePic);


        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java","Java 1",R.drawable.java));
        arrayList.add(new MonHoc("C#","C# 1",R.drawable.c));
        arrayList.add(new MonHoc("PHP","PHP 1",R.drawable.php));
        arrayList.add(new MonHoc("Kotlin","Kotlin 1",R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart","Dart 1",R.drawable.dart));
    }
}


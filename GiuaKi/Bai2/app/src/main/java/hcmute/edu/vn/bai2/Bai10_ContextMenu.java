package hcmute.edu.vn.bai2;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Bai10_ContextMenu extends AppCompatActivity {

    private Button btnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_button);

        btnButton = findViewById(R.id.button);
        registerForContextMenu(btnButton);

        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSetting:
                Toast.makeText(this, "Bạn đang chọn Setting", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuShare:
                btnButton.setText("Chia sẻ");
                return true;
            case R.id.menuLogout:
                // Handle logout action
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void showPopupMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.getMenuInflater().inflate(R.menu.menu_setting, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return onContextItemSelected(item);
            }
        });
        popup.show();
    }
}




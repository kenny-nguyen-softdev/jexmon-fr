package hcmute.edu.vn.bai2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bai9_PopMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_button);

        Button btnButton = findViewById(R.id.button);
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupMenu();
            }
        });
    }

    private void ShowPopupMenu() {
        Button btnButton = findViewById(R.id.button);
        PopupMenu popupMenu = new PopupMenu(this, btnButton);
        popupMenu.getMenuInflater().inflate(R.menu.menu_setting, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuSetting:
                        Toast.makeText(Bai9_PopMenu.this, "Bạn đang chọn Setting", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menuShare:
                        btnButton.setText("Chia sẻ");
                        break;
                    case R.id.menuLogout:
                        // Handle logout action
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}

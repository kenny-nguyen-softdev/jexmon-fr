package hcmute.edu.vn.bai2;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Bai8_Menu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSetting:
//lệnh
                break;
            case R.id.menuShare:
                break;
            case R.id.menuLogout:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
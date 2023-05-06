package hcmute.edu.vn.bai5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityRecyclerView extends AppCompatActivity {
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<SongModel> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvSongs = (RecyclerView) findViewById(R.id.rv_songs);

        mSongs = new ArrayList<>();
        mSongs.add(new SongModel("60696", "NEU EM CON TON TAI", "Khi anh bat dau 1 tinh yeu la luc anh tu chay", "Trinh Dinh Quang"));
        mSongs.add(new SongModel("60701", "NGOC", "Co rat nhieu nhung cau chuyen", "Khac Viet"));
        mSongs.add(new SongModel("60650", "HAY TIN ANH LAN NUA", "Dau cho anh tin em them lan nua", "Nguyen Dang Khoa"));
        mSongs.add(new SongModel("60610", "CHUOI NGAY VANG EM", "Dau cho ta di sai khi o ben nhau", "Thien Dung"));
        mSongs.add(new SongModel("60656", "KHI NGUOI MINH YEU KHOC", "Tu khi em buoc ra di coi long anh ngap tran", "Duy Cuong"));
        mSongs.add(new SongModel("60685", "MO", "Anh so gap em anh mo", "Trinh Thang Binh"));
        mSongs.add(new SongModel("60752", "TINH YEU CHAP VA", "Muon di xa noi yeu thuong minh tung", "Mr. Siro"));
        mSongs.add(new SongModel("60608", "CHO NGAY MUA TAN", "1 ngay mua va em khuat xa noi anh", "Trung Duc"));
        mSongs.add(new SongModel("60603", "CAU HOI EM CHUA TRA LOI", "Can noi em 1 loi giai thich that long dung lang im", "Yuki Huy Nam"));
        mSongs.add(new SongModel("60720", "QUA DI LANG LE", "Doi khi den voi nhau yeu thuong chang duoc lau", "Phan Manh Quynh"));
        mSongs.add(new SongModel("60856", "QUEN ANH LA DIEU EM KHONG THE - REMIX", "Can them bao lau de em quen di niem dau", "Thien Ngon"));

        mSongAdapter = new SongAdapter(this, mSongs);
        rvSongs.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);



    }
}

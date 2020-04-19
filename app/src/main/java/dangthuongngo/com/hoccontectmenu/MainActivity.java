package dangthuongngo.com.hoccontectmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    /*
    Bước 1: Tạo menu Resource XLM
    B2: Oncreate để nạp file menu vào bộ nhớ
    B3: Đăng kí context menu cho control nào đó
     */

    //B3: Đăng kí context menu cho control nào đó
    private void addControls() {
        btn1 = (Button) findViewById(R.id.btn1);
        registerForContextMenu(btn1);
    }

    //B2: Oncreate để nạp file menu vào bộ nhớ
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //b4 xử lí xự kiện người dùng
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuMauDo:
                btn1.setTextColor(Color.RED);
                break;
            case R.id.mnuMauVang:
                btn1.setTextColor(Color.YELLOW);
                break;
            case R.id.mnuMauXanh:
                btn1.setTextColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }
}

package <PACKACGE NAME>;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityWithRecyclerView extends AppCompatActivity {

    Button backBtn;
    ArrayList<OBJECT> details = new ArrayList<>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        backBtn = findViewById(R.id.BackBtn);

        initBackBtn();
    }

    @Override
    public void onResume() {
        super.onResume();
        details = PrefConfig.readListFromPref(this);
        if (details.size() > 0) {
            RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new Adapter(details);
            recyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(ActivityWithRecyclerView.this, "SERVER ERROR!", Toast.LENGTH_SHORT).show();
        }
    }

    private void initBackBtn() {
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityWithRecyclerView.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
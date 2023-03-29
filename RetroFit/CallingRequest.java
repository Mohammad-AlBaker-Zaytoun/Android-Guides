package <PACKAGENAME>;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallingRequest extends AppCompatActivity {

    interface interface;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getHistory();
    }

    private void getHistory() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ip:port/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        interface = retrofit.create(RetrofitINTER.class);

        Call<ArrayList<OBJECT>> call = interface.executeGetHistory();
        call.enqueue(new Callback<ArrayList<OBJECT>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<OBJECT>> call, @NonNull Response<ArrayList<OBJECT>> response) {
                if (response.isSuccessful()) {
                    ArrayList<OBJECT> data = response.body();
                    PrefConfig.writeListInPref(getApplicationContext(), data);
                    Log.e("Response Data Response", String.valueOf(response.body()));
                } else {
                    Log.e("Response RESULT", "ERROR RETRIEVING DATA");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<OBJECT>> call, @NonNull Throwable t) {
                Log.d("FAILED", String.valueOf(t));
            }
        });
    }
}
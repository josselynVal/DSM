package sv.edu.udb.guia9_discusion;

import androidx.annotation.Nullable;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import sv.edu.udb.guia9_discusion.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    ListView repoListView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        repoListView = findViewById(R.id.repo_list);
        progressBar = findViewById(R.id.pb_main);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();
        ApiService gitHubUser = retrofit.create(ApiService.class);
        Call<List<GitRepository>> call =  gitHubUser.repoForUser("JosselynVal");
        Toast.makeText(this, "Repositorio de: JosselynVal", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<List<GitRepository>>() {
            @Override
            public void onResponse(Call<List<GitRepository>> call, Response<List<GitRepository>> response) {

                progressBar.setVisibility(View.INVISIBLE);
                List<GitRepository> list = response.body();
                GitAdapter arrayAdapter = new GitAdapter(MainActivity.this,list);
                repoListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<GitRepository>> call, Throwable t) {

                progressBar.setVisibility(View.INVISIBLE);

            }
        });

    }

}


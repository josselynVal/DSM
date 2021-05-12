package sv.edu.udb.guia12app.content.provider;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private StudentsAdapter adaptador;

    Button Registro;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adaptador = new StudentsAdapter(this);
        Registro = findViewById(R.id.fab_agregar);
        lista = findViewById(R.id.lista);
        lista.setAdapter(adaptador);
        VerEstudiantes();


    }

    @Override
    protected void onResume() {
        super.onResume();
        VerEstudiantes();
    }

    public void VerEstudiantes() {
        String URL = "content://sv.edu.udb.guia12app.content.provider/students";
        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, null);
        adaptador.swapCursor(c);
        adaptador.notifyDataSetChanged();
    }

    public void abrir(View view) {
        Intent i = new Intent(MainActivity.this, AgregarUsuario.class);
        startActivity(i);
    }
}

package sv.edu.udb.guia12app.content.provider;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AgregarUsuario extends AppCompatActivity {
    EditText campocarne, camponombre, campoapellido;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        campocarne = findViewById(R.id.campocarne);
        camponombre = findViewById(R.id.camponombre);
        campoapellido = findViewById(R.id.campoapellido);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(v -> {
            agregar();
        });
    }

    protected void agregar() {
        ContentValues agregar = new ContentValues();

        agregar.put(StudentsContract.Columnas.CARNET, campocarne.getText().toString());
        agregar.put(StudentsContract.Columnas.NOMBRE, camponombre.getText().toString());
        agregar.put(StudentsContract.Columnas.APELLIDO, campoapellido.getText().toString());

        Uri uri = getContentResolver().insert(StudentsContract.CONTENT_URI, agregar);

        Toast.makeText(getBaseContext(), "Resgistro realizado con exito", Toast.LENGTH_SHORT).show();
    }



}

package sv.edu.udb.guia4_discusionresultados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=(EditText)findViewById(R.id.txtNombre);
        etHoras=(EditText)findViewById(R.id.txtHoras);
    }

        public void segundaActividad (View v){
            Intent i=new Intent(this,segundaActivida.class);
            i.putExtra("txtNombre", etNombre.getText().toString());
            i.putExtra("txtHoras", etHoras.getText().toString());
            startActivity(i);
        }
}
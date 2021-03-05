package sv.edu.udb.ejercicioguia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    public int suma=0;
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        resultado = (TextView)findViewById(R.id.txtSuma);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle estado) {
        super.onSaveInstanceState(estado);
        r = resultado.getText().toString();
        suma = Integer.parseInt(r);
        estado.putString("text", r);
    }

    @Override
    protected void onRestoreInstanceState(Bundle estado2) {
        super.onRestoreInstanceState(estado2);
        r = estado2.getString("text");
        suma = Integer.parseInt(r);
        resultado.setText(r);
    }

    //creando actividad incrementar (una actividad/en el mismo Main)
    public void incrementar(View view) {
        suma = suma +1;
        if(suma == 10){
            suma = 0;
        }
        String valor2 = valueOf(suma);
        resultado.setText(valor2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
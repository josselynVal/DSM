package sv.edu.udb.discusion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  EditText et1, et2, et3, et4, et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        et5=(EditText)findViewById(R.id.et5);
    }

    public void alta(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et1.getText().toString();
        String nom = et2.getText().toString();
        String ape = et3.getText().toString();
        String eda = et4.getText().toString();
        String tele = et5.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo",cod);
        registro.put("nombre", nom);
        registro.put("apellido",ape);
        registro.put("edad", eda);
        registro.put("telefono", tele);
        bd.insert("persona", null,registro);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        Toast.makeText(this, "Datos cargados", Toast.LENGTH_SHORT).show();


    }
    public void consultaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        Cursor fila = bd.rawQuery("select nombre,apellido, edad,telefono from persona where codigo=" + cod, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
            et5.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe registro con ese codigo",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void consultapornombre(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nom = et2.getText().toString();
        Cursor fila = bd.rawQuery("select nombre,apellido, edad, telefono from persona where nombre='" + nom
                +"'", null);
        if (fila.moveToFirst()) {
            et1.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
            et5.setText(fila.getString(3));
        } else
            Toast.makeText(this, "No existe registro",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }
    public void bajaporcodigo(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod= et1.getText().toString();
        int cant = bd.delete("persona", "codigo=" + cod, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró el registro",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe registro con ese codigo",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = et1.getText().toString();
        String nom = et2.getText().toString();
        String ape = et3.getText().toString();
        String eda = et4.getText().toString();
        String tele = et5.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("nombre", nom);
        registro.put("apellido", ape);
        registro.put("edad", eda);
        registro.put("telefono", tele);
        int cant = bd.update("persona", registro, "codigo=" + cod, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe registro con el código ingresado",
                    Toast.LENGTH_SHORT).show();
    }



}
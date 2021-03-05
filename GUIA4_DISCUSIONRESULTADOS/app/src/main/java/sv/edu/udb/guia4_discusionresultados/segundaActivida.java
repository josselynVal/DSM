package sv.edu.udb.guia4_discusionresultados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class segundaActivida extends AppCompatActivity {
    private TextView tviss;
    private TextView tvafp;
    private TextView tvrenta;
    private TextView tvsneto;
    private TextView tvbruto;

    double isss=0,renta=0,afp=0,bruto=0,neto=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_activida);

        tviss=(TextView)findViewById(R.id.txtvISS);
        tvafp=(TextView)findViewById(R.id.txtvAFP);
        tvrenta=(TextView)findViewById(R.id.txtvRenta);
        tvsneto=(TextView)findViewById(R.id.txtvSNeto);
        tvbruto=(TextView)findViewById(R.id.txtvSBruto);

        //creando un objeto bundle para traer los datos de la actividad mendiante Intent
        Bundle bundle = getIntent().getExtras();
        String nombre1 =bundle.getString("txtNombre");
        String horas1 =bundle.getString("txtHoras");

        //comvirtiendo horas tipo string a enteros
        int horas = Integer.parseInt(horas1);
        bruto   = horas*8.50;
        isss    = (bruto*0.02);
        afp     = (bruto*0.03);
        renta   = (bruto*0.04);
        neto    = bruto- (isss+afp+renta);

        //convirtiendo de double a string
        String Sbruto = valueOf(bruto);
        String Sneto = valueOf(neto);
        String diss = valueOf(isss);
        String dafp = valueOf(afp);
        String drenta = valueOf(renta);

        tvbruto.setText(Sbruto);
        tviss.setText(diss);
        tvafp.setText(dafp);
        tvrenta.setText(drenta);
        tvsneto.setText(Sneto);
    }

    public void finalizar(View v){
        finish();
    }
}
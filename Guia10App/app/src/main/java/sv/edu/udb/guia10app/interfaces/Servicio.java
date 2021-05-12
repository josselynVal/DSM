package sv.edu.udb.guia10app.interfaces;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface Servicio {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://18.206.142.59:5000/sql/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static APIService service =
            retrofit.create(APIService.class);
}

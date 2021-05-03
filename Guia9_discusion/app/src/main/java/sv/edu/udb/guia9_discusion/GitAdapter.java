package sv.edu.udb.guia9_discusion;

import sv.edu.udb.guia9_discusion.ApiService;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class GitAdapter extends ArrayAdapter<GitRepository>{
    public GitAdapter(@NonNull Context context,  @NonNull List<GitRepository> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        GitRepository user = getItem(position);


        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user,parent,false);
        }

        TextView tvName =  convertView.findViewById(R.id.tvRepo);


        tvName.setText(user.getName());
        return convertView;



    }

}

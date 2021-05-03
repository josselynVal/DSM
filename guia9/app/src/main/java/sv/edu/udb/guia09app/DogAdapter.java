package sv.edu.udb.guia09app;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogViewHolder>{
    private List<String> images = null;

    public DogAdapter(List<String> images){
        this.images = images;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    public void onBindViewHolder(DogViewHolder holder, int position) {
        holder.bind(images.get(position));
    }

    public int getItemCount() {
        return images != null ? images.size() : 0;
    }
}

package dev.jay.pokedex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.jay.pokedex.PokemonDetails;
import dev.jay.pokedex.R;
import dev.jay.pokedex.models.Pokemon;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder> {

    private Context context;
    private List<Pokemon> pokemons = new ArrayList<>();

    public PokedexAdapter(Context context, List<Pokemon> pokemons) {
        this.context = context;
        this.pokemons = pokemons;
    }

    @NonNull
    @Override
    public PokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokedexViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokedexViewHolder holder, int position) {
        holder.bind(pokemons.get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    class PokedexViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivThumb, ivTypeOne, ivTypeTwo;
        private final TextView tvName;

        public PokedexViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumb = itemView.findViewById(R.id.ivThumbnail);
            tvName = itemView.findViewById(R.id.tvName);

            ivTypeOne = itemView.findViewById(R.id.ivTypeOne);
            ivTypeTwo = itemView.findViewById(R.id.ivTypeTwo);
        }

        public void bind(Pokemon pokemon) {
            ivThumb.setImageResource(pokemon.getImage().getThumbnail());
            tvName.setText(pokemon.getName());

            int[]typeIcons = pokemon.getTypeIcons();
            ivTypeOne.setImageResource(typeIcons[0]);
            if(typeIcons.length > 1){
                ivTypeTwo.setVisibility(View.VISIBLE);
                ivTypeTwo.setImageResource(typeIcons[1]);
            } else {
                ivTypeTwo.setVisibility(View.GONE);
            }
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, PokemonDetails.class);
                intent.putExtra("id", pokemon.getId());
                context.startActivity(intent);
            });
        }
    }
}

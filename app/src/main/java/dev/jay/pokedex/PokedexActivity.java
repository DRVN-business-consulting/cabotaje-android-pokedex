package dev.jay.pokedex;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.jay.pokedex.adapters.PokedexAdapter;
import dev.jay.pokedex.data.PokemonData;

public class PokedexActivity extends AppCompatActivity {

    private PokemonData pokemonData;
    private PokedexAdapter pokedexAdapter;
    private RecyclerView rvPokemons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokedex);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rvPokemons = findViewById(R.id.rvPokemons);
        pokemonData = new PokemonData();
        pokedexAdapter = new PokedexAdapter(this, pokemonData.getPokemons());

        rvPokemons.setLayoutManager(new LinearLayoutManager(this));
        rvPokemons.setAdapter(pokedexAdapter);
    }

}
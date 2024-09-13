package dev.jay.pokedex;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import dev.jay.pokedex.data.PokemonData;
import dev.jay.pokedex.models.Pokemon;

public class PokemonDetails extends AppCompatActivity {

    private PokemonData pokemonData;
    private ImageView ivHiRes, ivTypeOne, ivTypeTwo;
    private TextView tvName, tvTypeOne, tvTypeTwo, tvAbilityOne, tvAbilityTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemon_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivHiRes = findViewById(R.id.ivHiRes);
        ivTypeOne = findViewById(R.id.ivTypeOne);
        ivTypeTwo = findViewById(R.id.ivTypeTwo);

        tvName = findViewById(R.id.tvName);
        tvTypeOne = findViewById(R.id.tvTypeOne);
        tvTypeTwo = findViewById(R.id.tvTypeTwo);
        tvAbilityOne = findViewById(R.id.tvAbilityOne);
        tvAbilityTwo = findViewById(R.id.tvAbilityTwo);

        findViewById(R.id.ivBack).setOnClickListener(view -> finish());
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadDetails();
    }

    private void loadDetails(){
        int id = getIntent().getIntExtra("id", -1);
        if(id > 0) {
            pokemonData = new PokemonData();
            Pokemon pokemon = pokemonData.findPokemon(id);
            if(pokemon != null){
                ivHiRes.setImageResource(pokemon.getImage().getHiRes());
                tvName.setText(pokemon.getName());

                int[]types = pokemon.getTypeIcons();
                ivTypeOne.setImageResource(types[0]);
                if(types.length > 1) { ivTypeTwo.setImageResource(types[1]);}

                String[] strTypes = pokemon.getTypes();
                tvTypeOne.setText(strTypes[0]);
                if(strTypes.length > 1) { tvTypeTwo.setText(strTypes[1]); }

                String[] abilities = pokemon.getAbilities();
                tvAbilityOne.setText(abilities[0]);
                tvAbilityTwo.setText(abilities[1]);
            }
        }
    }
}
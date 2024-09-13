package dev.jay.pokedex.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dev.jay.pokedex.R;
import dev.jay.pokedex.models.Image;
import dev.jay.pokedex.models.Pokemon;

public class PokemonData {
    public static List<Pokemon> pokemons = new ArrayList<>();

    public PokemonData() {
        pokemons.add(
                new Pokemon(
                        1,
                        new Image(R.drawable.bulbasaur_thumb, R.drawable.bulbasaur_hi_res),
                        "Bulbasaur",
                        new String[]{"Grass", "Poison"},
                        new int[]{R.drawable.type_grass, R.drawable.type_poison},
                        new String[]{"Overgrow", "Chlorophyll"}
                )
        );
        pokemons.add(
                new Pokemon(
                        4,
                        new Image(R.drawable.charmander_thumb, R.drawable.charmander_hi_res),
                        "Charmander",
                        new String[]{"Fire"},
                        new int[]{R.drawable.type_fire},
                        new String[]{"Blaze", "Solar Power"}
                )
        );
        pokemons.add(
                new Pokemon(
                        7,
                        new Image(R.drawable.squirtle_thumb, R.drawable.squirtle_hi_res),
                        "Squirtle",
                        new String[]{"Water"},
                        new int[]{R.drawable.type_water},
                        new String[]{"Torrent", "Rain Dish"}
                )
        );
    }

    public Pokemon findPokemon(int id){
        Optional<Pokemon> optionalPokemon = pokemons.stream().filter(pokemon -> pokemon.getId() == id).findFirst();
        return optionalPokemon.orElse(null);
    }

    public List<Pokemon> getPokemons(){ return  pokemons; }
}

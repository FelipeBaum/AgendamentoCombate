package com.example.agendamentocombate;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {
        private static final String TAG = "ParseJson";
        private List<Usuario> usuario;
        private List<Combate> combate;
        private List<Arena> arena;
        private List<Robo> robo;

        public ParseUsuario() {
            usuario = new ArrayList<>();
        }
        public ParseCombate() {
        combate = new ArrayList<>();
    }
        public ParseArena() {
        arena = new ArrayList<>();
    }
        public ParseRobo() {
        robo = new ArrayList<>();
    }

        public List<Usuario> getUsuario() {
            return usuario;
        }
        public List<Combate> getCombate() {
        return combate;
    }
        public List<Arena> getArena() {
        return arena;
    }
        public List<Robo> getRobo() {
        return robo;
    }


    public boolean parse(String jsonString) {
            try {
                JSONObject json = new JSONObject(jsonString);
                JSONArray pokemons = json.getJSONArray("pokemon");

                for (int i = 0; i < pokemons.length(); i++) {
                    JSONObject pokemon = pokemons.getJSONObject(i);
                    Pokemon p = new Pokemon();
                    p.setId(pokemon.getInt("id"));
                    p.setNome(pokemon.getString("name"));
                    p.setImageUrl(pokemon.getString("img"));
                    p.setNumero(pokemon.getString("num"));
                    p.setPeso(pokemon.getString("weight"));
                    p.setAltura(pokemon.getString("height"));
                    JSONArray tipos = pokemon.getJSONArray("type");
                    for (int j = 0; j < tipos.length(); j++) {
                        p.addTipo(tipos.getString(j));
                    }
                    this.pokemons.add(p);
                }
                return true;
            } catch (JSONException e) {
                Log.e(TAG, "parse: erro ao fazer parse do JSON: " + e.getMessage());
                return false;
            }
        }
    }

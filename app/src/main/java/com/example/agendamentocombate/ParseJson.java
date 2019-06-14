package com.example.agendamentocombate;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJson {
    private static final String TAG = "ParseJson";
    private List<Usuario> usuarios;
    private List<Robo> robos;
    private List<Combate> combates;
    private List<Arena> arenas;

    public ParseJson() {
        usuarios = new ArrayList<>();
        robos = new ArrayList<>();
        combates = new ArrayList<>();
        arenas = new ArrayList<>();
    }

    public List<Usuario> getUsuario() {
        return usuarios;
    }
    public List<Robo> getRobo() {
        return robos;
    }
    public List<Combate> getCombate() {
        return combates;
    }
    public List<Arena> getArena() {
        return arenas;
    }


    public boolean parseUsuario(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONArray usuarios = json.getJSONArray("usuario");
            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);
                Usuario u = new Usuario();
                u.setId_Usuario(Integer.parseInt(usuario.getString("id")));
                u.setNome(usuario.getString("nome"));
                u.setUsuario(usuario.getString("usuario"));
                u.setSenha(usuario.getString("senha"));
                u.setNivel(usuario.getString("nivel"));
                this.usuarios.add(u);
            }
            return true;
        } catch (JSONException e) {
            Log.e(TAG, "parse: erro ao fazer parse do JSON: " + e.getMessage());
            return false;
        }
    }

    public boolean parseRobo(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONArray robos = json.getJSONArray("robo");
            for (int i = 0; i < robos.length(); i++) {
                JSONObject robo = robos.getJSONObject(i);
                Robo r = new Robo();
                r.setId_Robo(Integer.parseInt(robo.getString("id")));
                r.setNome(robo.getString("nome"));
                r.setCategoria(robo.getString("categoria"));
                r.setId_Usuario(Integer.parseInt(robo.getString("usuario")));
                this.robos.add(r);
            }
            return true;
        } catch (JSONException e) {
            Log.e(TAG, "parse: erro ao fazer parse do JSON: " + e.getMessage());
            return false;
        }
    }

    public boolean parseArena(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONArray arenas = json.getJSONArray("arenas");
            for (int i = 0; i < arenas.length(); i++) {
                JSONObject arena = arenas.getJSONObject(i);
                Arena a = new Arena();
                a.setId_Arena(Integer.parseInt(arena.getString("id")));
                a.setNome(arena.getString("nome"));
                this.arenas.add(a);
            }
            return true;
        } catch (JSONException e) {
            Log.e(TAG, "parse: erro ao fazer parse do JSON: " + e.getMessage());
            return false;
        }
    }

    public boolean parseCombate(String jsonString) {
        try {
            JSONObject json = new JSONObject(jsonString);
            JSONArray combates = json.getJSONArray("combate");
            for (int i = 0; i < combates.length(); i++) {
                JSONObject combate = combates.getJSONObject(i);
                Combate c = new Combate();
                c.setId_Combate(Integer.parseInt(combate.getString("id")));
                c.setCategoria(combate.getString("categoria"));
                c.setId_robo1(Integer.parseInt(combate.getString("robo1")));
                c.setId_robo2(Integer.parseInt(combate.getString("robo2")));
                this.combates.add(c);
            }
            return true;
        } catch (JSONException e) {
            Log.e(TAG, "parse: erro ao fazer parse do JSON: " + e.getMessage());
            return false;
        }
    }
}

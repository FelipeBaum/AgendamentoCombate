package com.example.agendamentocombate;

import java.util.Date;

public class Combate {

    int id_Combate;
    int id_robo1;
    int id_robo2;
    Date data;
    String categoria;
    int id_arena;

    public Combate(int id_Combate, int id_robo1, int id_robo2, Date data, String categoria, int id_arena){
        this.id_Combate = id_Combate;
        this.id_robo1 = id_robo1;
        this.id_robo2 = id_robo2;
        this.data = data;
        this.categoria = categoria;
        this.id_arena = id_arena;
    }

    public void setId_Combate(int id_Combate) {
        this.id_Combate = id_Combate;
    }

    public void setId_robo1(int id_robo1) {
        this.id_robo1 = id_robo1;
    }

    public void setId_robo2(int id_robo2) {
        this.id_robo2 = id_robo2;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setId_arena(int id_arena) {
        this.id_arena = id_arena;
    }

    public int getId_Combate() {
        return id_Combate;
    }

    public int getId_robo1() {
        return id_robo1;
    }

    public int getId_robo2() {
        return id_robo2;
    }

    public Date getData() {
        return data;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getId_arena() {
        return id_arena;
    }
}

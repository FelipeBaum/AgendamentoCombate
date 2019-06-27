package com.example.agendamentocombate;

import java.util.Date;

public class CombatesList {
    String nome_robo1;
    String nome_robo2;
    String status_robo1;
    String status_robo2;
    String usuario_robo1;
    String usuario_robo2;
    String data;
    String arena;
    String categoria;

    @Override
    public String toString() {
        return nome_robo1+';'+nome_robo2+';'+status_robo1+';'+status_robo2+';'+usuario_robo1+';'+usuario_robo2+';'+data+';'+arena+';'+categoria;
    }

    public CombatesList(String nome_robo1, String nome_robo2, String status_robo1, String status_robo2, String data, String arena,String categoria) {
        this.nome_robo1 = nome_robo1;
        this.nome_robo2 = nome_robo2;
        this.status_robo1 = status_robo1;
        this.status_robo2 = status_robo2;
        this.data = data;
        this.arena = arena;
        this.categoria = categoria;
    }

    public CombatesList(){

    }

    public String getUsuario_robo1() {
        return usuario_robo1;
    }

    public void setUsuario_robo1(String usuario_robo1) {
        this.usuario_robo1 = usuario_robo1;
    }

    public String getUsuario_robo2() {
        return usuario_robo2;
    }

    public void setUsuario_robo2(String usuario_robo2) {
        this.usuario_robo2 = usuario_robo2;
    }

    public String getNome_robo1() {
        return nome_robo1;
    }

    public void setNome_robo1(String nome_robo1) {
        this.nome_robo1 = nome_robo1;
    }

    public String getNome_robo2() {
        return nome_robo2;
    }

    public void setNome_robo2(String nome_robo2) {
        this.nome_robo2 = nome_robo2;
    }

    public String getStatus_robo1() {
        return status_robo1;
    }

    public void setStatus_robo1(String status_robo1) {
        this.status_robo1 = status_robo1;
    }

    public String getStatus_robo2() {
        return status_robo2;
    }

    public void setStatus_robo2(String status_robo2) {
        this.status_robo2 = status_robo2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }
}

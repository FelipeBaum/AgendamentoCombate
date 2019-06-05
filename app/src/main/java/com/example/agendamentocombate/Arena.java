package com.example.agendamentocombate;

public class Arena {
    int id_Arena;
    String nome;

    public Arena(int id, String nome){
    this.id_Arena = id_Arena;
    this.nome = nome;
    }

    public void setId_Arena(int id_Arena) {
        this.id_Arena = id_Arena;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_Arena(){
        return this.id_Arena;
    }
    public String getNome(){
        return this.nome;
    }
}

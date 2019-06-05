package com.example.agendamentocombate;

public class Robo{

    int id_Robo;
    String nome;
    String categoria;
    String status;
    int id_Usuario;


    public  Robo(int id_Robo, String nome, String categoria, String status, int id_Usuario){
    this.id_Robo = id_Robo;
    this.nome = nome;
    this.categoria = categoria;
    this.status = status;
    this.id_Usuario = id_Usuario;
    }

    public void setId_Robo(int id_Robo) {
        this.id_Robo = id_Robo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_Robo() {
        return id_Robo;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }


}

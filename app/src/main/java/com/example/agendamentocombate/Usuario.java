package com.example.agendamentocombate;

public class Usuario {

    int id_Usuario;
    String nome;
    String usuario;
    String senha;
    String nivel;

    public Usuario(int id_Usuario, String nome, String usuario, String senha, String nivel){
        this.id_Usuario = id_Usuario;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNivel() {
        return nivel;
    }
}

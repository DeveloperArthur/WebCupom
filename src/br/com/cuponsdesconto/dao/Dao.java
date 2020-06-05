package br.com.cuponsdesconto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class Dao {
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    protected PreparedStatement stmt;
    protected Connection conn;

    public Dao() {
        this.servidor = "127.0.0.1:3306";
        this.banco = "bdcupom";
        this.usuario = "root";
        this.senha = "";
    }

    public void conectar() {
        String url = "jdbc:mysql://" + servidor + "/" + banco;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = (Connection) DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
        }
    }
}

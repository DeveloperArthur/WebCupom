package br.com.cuponsdesconto.entidades;

public class Cupom extends Entidade {
    private int id;
    private int codigoCupom;
    private String descricao;
    private int numeroDePontos;

    public Cupom() {
    }
    
    public Cupom(int codigoCupom, String descricao, int numeroDePontos) {
    	this.codigoCupom = codigoCupom;
    	this.descricao = descricao;
    	this.numeroDePontos = numeroDePontos;
    }
    
    public Cupom(int id, int codigoCupom, String descricao, int numeroDePontos) {
    	this.id = id;
    	this.codigoCupom = codigoCupom;
    	this.descricao = descricao;
    	this.numeroDePontos = numeroDePontos;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoCupom() {
        return codigoCupom;
    }

    public void setCodigoCupom(int codigoCupom) {
        this.codigoCupom = codigoCupom;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroDePontos() {
        return numeroDePontos;
    }

    public void setNumeroDePontos(int numeroDePontos) {
        this.numeroDePontos = numeroDePontos;
    }

    
}

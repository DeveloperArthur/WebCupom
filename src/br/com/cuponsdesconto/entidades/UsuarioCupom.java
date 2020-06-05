package br.com.cuponsdesconto.entidades;

public class UsuarioCupom extends Entidade {
	private int id;
	private int idUsuario;
	private int idCupom;
	
    public UsuarioCupom() {
    }
    
    public UsuarioCupom(int id, int idUsuario, int idCupom) {
    	this.id = id;
    	this.idUsuario = idUsuario;
    	this.idCupom = idCupom;
    }
    
    public UsuarioCupom(int idUsuario, int idCupom) {
    	this.idUsuario = idUsuario;
    	this.idCupom = idCupom;
    }
	
    public int getId() {
        return id;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public int getIdCupom() {
        return idCupom;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setIdCupom(int idCupom) {
        this.idCupom = idCupom;
    }
}

package br.com.cuponsdesconto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.cuponsdesconto.entidades.Cupom;
import br.com.cuponsdesconto.entidades.Entidade;
import br.com.cuponsdesconto.entidades.UsuarioCupom;

public class UsuarioCupomDao extends Dao implements FuncoesDao{

	@Override
    public boolean adicionar(Entidade entidade) {
        UsuarioCupom usuarioCupom = (UsuarioCupom) entidade;
        String sql = "insert into usuariocupons (id_usuario, id_cupom) values (?,?)";
        try{
        	this.conectar();
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setInt(1, usuarioCupom.getIdUsuario());
            this.stmt.setInt(2, usuarioCupom.getIdCupom());
            this.stmt.execute();
            System.out.println("Usuario cupom criado com sucesso!");
        } catch(SQLException ex){
            System.out.println("Erro ao inserir Usuario cupom "+ex.getMessage());
            return false;
        }
        finally{
            try {
                this.conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "delete from usuariocupons where id = ?";
        try {
        	this.conectar();
        	this.stmt = this.conn.prepareStatement(sql);
        	this.stmt.setInt(1, id);
        	this.stmt.execute();
        }catch(SQLException ex) {
        	System.out.println("Erro ao deletar Usuario cupom: "+ex.getMessage());
        	return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Entidade entidade) {
    	UsuarioCupom usuarioCupom = (UsuarioCupom) entidade;
        String sql = "update usuariocupons set id_usuario = ?, id_cupom = ? where id = ?";
        try {
        	this.conectar();
        	this.stmt = this.conn.prepareStatement(sql);
        	this.stmt.setInt(1, usuarioCupom.getIdUsuario());
            this.stmt.setInt(2, usuarioCupom.getIdCupom());
        	this.stmt.setInt(3, usuarioCupom.getId());
        	this.stmt.execute();
        }catch(SQLException ex) {
        	System.out.println("Erro ao atualizar Usuario: "+ex.getMessage());
        	return false;
        }
        return true;
    }

    @Override
    public Entidade buscar(int id) {
        String sql = "select * from usuariocupons where id = ?";
        try {
        	this.conectar();
        	this.stmt = this.conn.prepareStatement(sql);
        	this.stmt.setInt(1, id);
        	ResultSet rs = this.stmt.executeQuery();
        	if(rs.next()) {
        		UsuarioCupom usuarioCupom = new UsuarioCupom();;
        		usuarioCupom.setId(rs.getInt("id"));
        		usuarioCupom.setId(rs.getInt("id_usuario"));
        		usuarioCupom.setId(rs.getInt("id_cupom"));
        		return usuarioCupom;
        	}
        }catch(SQLException ex) {
        	System.out.println("Erro ao buscar Usuario: "+ex.getMessage());
        	return null;
        }
        return null;
    }

    @Override
    public List<Entidade> buscarTodos() {
        String sql = "Select * from usuario";
        List<Entidade> usuarioscupons = new ArrayList<>();
        try {
        	this.conectar();
        	this.stmt = this.conn.prepareStatement(sql);
        	ResultSet rs = this.stmt.executeQuery();
        	while(rs.next()){
        		UsuarioCupom usuarioCupom = new UsuarioCupom();
        		usuarioCupom.setId(rs.getInt("id"));
        		usuarioCupom.setId(rs.getInt("id_usuario"));
        		usuarioCupom.setId(rs.getInt("id_cupom"));
        		usuarioscupons.add(usuarioCupom);
        	}
        }catch(SQLException ex) {
        	return null;
        }
        return usuarioscupons;
    }
    
    public List<Cupom> buscarCuponsPorUsuario(int id){
		List<Cupom> cupons = new ArrayList<>();
		String sql = "select c.id, c.cdcupon, c.descricao, c.numpontos "
				+ "from usuariocupons uc, cupons c "
				+ "where uc.idusuario = ? and uc.idcupom = c.id";
		try {
			this.conectar();
			this.stmt = this.conn.prepareStatement(sql);
			this.stmt.setInt(1, id);
			ResultSet rs = this.stmt.executeQuery();
			while(rs.next()) {
				Cupom cupom = new Cupom();
        		cupom.setId(rs.getInt("id"));
        		cupom.setCodigoCupom(rs.getInt("codigoCupom"));
        		cupom.setDescricao(rs.getString("descricao"));
        		cupom.setNumeroDePontos(rs.getInt("numeroDePontos"));
        		cupons.add(cupom);
			}
        }catch(SQLException ex) {
        	return null;
        }
        return cupons;
    }
}
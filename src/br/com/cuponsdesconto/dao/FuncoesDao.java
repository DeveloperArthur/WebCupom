package br.com.cuponsdesconto.dao;

import br.com.cuponsdesconto.entidades.Entidade;
import java.util.List;

public interface FuncoesDao {

    public boolean adicionar(Entidade entidade);

    public boolean deletar(int id);

    public boolean atualizar(Entidade entidade);

    public Entidade buscar(int id);

    public List<Entidade> buscarTodos();
}
package br.com.makersweb.oauth.security.service;

import br.com.makersweb.oauth.security.model.Cliente;

import java.util.List;

/**
 * @author aaristides
 */
public interface IClienteService {

    List<Cliente> listar();

    Cliente buscar(Long codigo);

    Cliente salvar(Cliente cliente);

    Cliente atualizar(Long codigo, Cliente cliente);

    void remover(Long codigo);

    void atualizaPropriedadeAtivo(Long codigo, Boolean ativo);
}

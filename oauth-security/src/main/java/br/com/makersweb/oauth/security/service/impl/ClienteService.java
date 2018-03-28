package br.com.makersweb.oauth.security.service.impl;

import br.com.makersweb.oauth.security.model.Cliente;
import br.com.makersweb.oauth.security.repository.IClienteRepository;
import br.com.makersweb.oauth.security.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aaristides
 */
@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public Cliente buscar(Long codigo) {
        return null;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente atualizar(Long codigo, Cliente cliente) {
        return null;
    }

    @Override
    public void remover(Long codigo) {

    }

    @Override
    public void atualizaPropriedadeAtivo(Long codigo, Boolean ativo) {

    }
}

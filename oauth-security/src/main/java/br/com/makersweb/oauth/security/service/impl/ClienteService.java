package br.com.makersweb.oauth.security.service.impl;

import br.com.makersweb.oauth.security.model.Cliente;
import br.com.makersweb.oauth.security.model.Usuario;
import br.com.makersweb.oauth.security.repository.IClienteRepository;
import br.com.makersweb.oauth.security.service.IClienteService;
import br.com.makersweb.oauth.security.service.exception.BusinessException;
import br.com.makersweb.oauth.security.service.exception.ClienteInexistenteOuInativaException;
import br.com.makersweb.oauth.security.service.exception.EmailUsuarioJaCadastradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author aaristides
 */
@Service
public class ClienteService implements IClienteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> listar() {
        LOGGER.info("Iniciou método listar.");

        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscar(Long codigo) {
        LOGGER.info("Iniciou método buscar.");
        Optional<Cliente> clienteOptional = clienteRepository.findById(codigo);
        Cliente cliente = clienteOptional
                .orElseThrow(() -> new BusinessException(String.format("Nenhum Cliente encontrado para o código %s informado", codigo)));

        return cliente;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        LOGGER.info("Iniciou método salvar.");
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(cliente.getEmail());
        if (clienteOptional.isPresent() && !clienteOptional.get().equals(cliente)) {
            LOGGER.warn(String.format("O e-mail %s já esta cadastrado.", cliente.getEmail()));
            throw new EmailUsuarioJaCadastradoException("E-mail já cadastrado.");
        }

        if (!cliente.isNovo() && null == cliente.getAtivo()) {
            cliente.setAtivo(clienteOptional.get().getAtivo());
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Long codigo, Cliente cliente) {
        LOGGER.info("Iniciou método alterar.");
        Cliente clienteSave = buscar(codigo);
        BeanUtils.copyProperties(cliente, clienteSave, "codigo");

        return clienteRepository.save(cliente);
    }

    @Override
    public void remover(Long codigo) {
        LOGGER.info("Iniciou método deletar.");
        try {
            clienteRepository.deleteById(codigo);
        } catch (EmptyResultDataAccessException e) {
            throw new BusinessException(String.format("Nenhum Cliente encontrado com código %s informado.", codigo));
        }
    }

    @Override
    public void atualizaPropriedadeAtivo(Long codigo, Boolean ativo) {
        Cliente cliente = buscar(codigo);
        if (null == cliente || cliente.isInativo()) {
            throw new ClienteInexistenteOuInativaException();
        }
    }
}

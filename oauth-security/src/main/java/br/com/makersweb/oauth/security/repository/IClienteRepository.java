package br.com.makersweb.oauth.security.repository;

import br.com.makersweb.oauth.security.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}

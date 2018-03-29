package br.com.makersweb.oauth.security.repository;

import br.com.makersweb.oauth.security.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author aaristides
 */
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);

}

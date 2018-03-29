package br.com.makersweb.oauth.security.resource;

import br.com.makersweb.oauth.security.model.Cliente;
import br.com.makersweb.oauth.security.resource.constants.ResourceApiConstants;
import br.com.makersweb.oauth.security.resource.event.RecursoCriadoEvent;
import br.com.makersweb.oauth.security.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author aaristides
 */
@RestController
@RequestMapping(ResourceApiConstants.Api.Page.ClienteResources)
public class ClienteResource {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> buscar(@PathVariable("codigo") Long codigo) {
        Cliente cliente = clienteService.buscar(codigo);

        return !ObjectUtils.isEmpty(cliente) ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente, HttpServletResponse response) {
        Cliente clienteSave = clienteService.salvar(cliente);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, cliente.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSave);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable("codigo") Long codigo, @RequestBody @Valid Cliente cliente) {
        Cliente clienteSave = clienteService.atualizar(codigo, cliente);

        return ResponseEntity.ok(clienteSave);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable("codigo") Long codigo) {
        clienteService.remover(codigo);
    }

    @PatchMapping("/{codigo}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        clienteService.atualizaPropriedadeAtivo(codigo, ativo);
    }

}

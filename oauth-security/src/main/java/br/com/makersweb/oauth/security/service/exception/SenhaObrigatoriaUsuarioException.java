package br.com.makersweb.oauth.security.service.exception;

/**
 * @author aaristides
 */
public class SenhaObrigatoriaUsuarioException extends RuntimeException {

    public SenhaObrigatoriaUsuarioException(String message) {
        super(message);
    }
}

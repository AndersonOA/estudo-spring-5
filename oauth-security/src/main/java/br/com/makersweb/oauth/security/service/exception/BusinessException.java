package br.com.makersweb.oauth.security.service.exception;

/**
 * @author aaristides
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}

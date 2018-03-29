package br.com.makersweb.oauth.security.resource.constants;

/**
 * @author aaristides
 */
public interface ResourceApiConstants {

    interface Api {

        interface Page {

            String _Version = "v1";
            String _Prefix = "/api/" + _Version;

            String UsuarioResources = _Prefix + "/usuarios";
            String UserResources = _Prefix + "/users";

            String ClienteResources = _Prefix + "/clientes";
        }

    }

}

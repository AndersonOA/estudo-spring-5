package br.com.makersweb.oauth.security.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author aaristides
 */
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String descricao;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permissao permissao = (Permissao) o;

        return codigo != null ? codigo.equals(permissao.codigo) : permissao.codigo == null;
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}

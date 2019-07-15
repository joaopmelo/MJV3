package server.dominio;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Endereco implements Serializable {

    @Column(length = 50)
    private String cidade;

    @Column(length = 2)
    private String uf;

    @Column(length = 8)
    private int cep;

    @Column(length = 3)
    private int numero;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return getCep() == endereco.getCep() &&
                getNumero() == endereco.getNumero() &&
                Objects.equals(getCidade(), endereco.getCidade()) &&
                Objects.equals(getUf(), endereco.getUf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCidade(), getUf(), getCep(), getNumero());
    }
}

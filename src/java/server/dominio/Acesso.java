package server.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="acesso")
public class Acesso implements Serializable, CadastroId{

    @Id
    @SequenceGenerator(name = "acesso_id_seq", sequenceName = "acesso_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acesso_id_seq")
    private int id;

    @Column(length = 15, nullable = false)
    private String login;

    @Column(length = 15, nullable = false)
    private String senha;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(name="receber_noticia")
    private boolean receberNoticia;

    @Override
    public int getId() {

        return this.id;
    }

    @Override
    public void setId(int id) {

        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isReceberNoticia() {
        return receberNoticia;
    }

    public void setReceberNoticia(boolean receberNoticia) {
        this.receberNoticia = receberNoticia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acesso acesso = (Acesso) o;
        return getId() == acesso.getId() &&
                isReceberNoticia() == acesso.isReceberNoticia() &&
                Objects.equals(getLogin(), acesso.getLogin()) &&
                Objects.equals(getSenha(), acesso.getSenha()) &&
                Objects.equals(getEmail(), acesso.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getSenha(), getEmail(), isReceberNoticia());
    }
}

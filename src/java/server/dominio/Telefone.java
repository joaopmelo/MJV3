package server.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "telefone")
public class Telefone implements Serializable, CadastroId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefone_id_seq")
    @SequenceGenerator(name = "telefone_id_seq", sequenceName = "telefone_id_seq", allocationSize = 1)
    private int id;

    @Column(length = 3, nullable = false)
    private int ddd;

    @Column(length = 9, nullable = false)
    private int numero;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_telefone")
    private TipoTelefone tipoTelefone;

    @Override
    public int getId() {

        return this.id;
    }

    @Override
    public void setId(int id) {

        this.id = id;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return getId() == telefone.getId() &&
                getDdd() == telefone.getDdd() &&
                getNumero() == telefone.getNumero() &&
                getTipoTelefone() == telefone.getTipoTelefone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDdd(), getNumero(), getTipoTelefone());
    }
}

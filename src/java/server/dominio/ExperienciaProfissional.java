package server.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "experiencia_profissional")
public class ExperienciaProfissional implements Serializable, CadastroId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experiencia_profissional_id_seq")
    @SequenceGenerator(name = "experiencia_profissional_id_seq", sequenceName = "experiencia_profissional_id_seq", allocationSize = 1)
    private int id;

    @Column(name="nome_empresa",length = 80)
    private String nomeEmpresa;

    @Column(length = 80)
    private String cargo;

    @Column(name="tarefas_executadas", length = 150)
    private String tarefasExecutadas;

    @Column(name="data_inicio", length = 8)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInicio;

    @Column(name="data_fim", length = 8)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFim;

    @Enumerated(EnumType.STRING)
    @Column(name="forma_contratacao")
    private FormaContratacao formaDeContratacao;

    @ManyToOne
    @JoinColumn(name = "candidato_id",referencedColumnName = "id")
    private Candidato candidato;


    @Override
    public int getId() {

        return this.id;
    }

    @Override
    public void setId(int id) {

        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeDaEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTarefasExecutadas() {
        return tarefasExecutadas;
    }

    public void setTarefasExecutadas(String tarefasExecutadas) {
        this.tarefasExecutadas = tarefasExecutadas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataInicio);
        this.dataInicio = date;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim)  throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataFim);
        this.dataFim = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienciaProfissional that = (ExperienciaProfissional) o;
        return getId() == that.getId() &&
                Objects.equals(getNomeEmpresa(), that.getNomeEmpresa()) &&
                Objects.equals(getCargo(), that.getCargo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomeEmpresa(), getCargo());
    }
}

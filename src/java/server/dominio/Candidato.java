package server.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="candidato")
public class Candidato implements Serializable, CadastroId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidato_id_seq")
    @SequenceGenerator(name = "candidato_id_seq", sequenceName = "candidato_id_seq", allocationSize = 1)
    private int id;

    @Column(length = 50)
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(name="data_nascimento", length = 8)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToOne(cascade = CascadeType.ALL)
    private Acesso acesso;

    @OneToOne(cascade = CascadeType.ALL)
    private Telefone telefone;

    @Enumerated(EnumType.STRING)
    @Column(name="estado_civil")
    private EstadoCivil estadoCivil;

    @OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
    @Column(name="experiencias_profissionais")
    private List<ExperienciaProfissional> experienciasProfissionais= new ArrayList<>();

    @Embedded
    private Rg rg;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;


    @Override
    public int getId() {

        return this.id;
    }

    @Override
    public void setId(int id) {

        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
        this.dataNascimento = date;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Rg getRg() {
        return rg;
    }

    public void setRg(Rg rg) {
        this.rg = rg;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<ExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

    public Acesso getAcesso() {
        return acesso;
    }

    public void setAcesso(Acesso acesso) {
        this.acesso = acesso;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return getId() == candidato.getId() &&
                getCpf() == candidato.getCpf() &&
                Objects.equals(getNome(), candidato.getNome()) &&
                Objects.equals(getDataNascimento(), candidato.getDataNascimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getDataNascimento());
    }
}

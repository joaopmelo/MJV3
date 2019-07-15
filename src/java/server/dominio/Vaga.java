package server.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="vaga")
public class Vaga implements Serializable, CadastroId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaga_id_seq")
    @SequenceGenerator(name = "vaga_id_seq", sequenceName = "vaga_id_seq", allocationSize = 1)
    private int id;

    @Column(length = 80)
    private String cargo;

    @Column(name="especificacao_cargo", length = 120)
    private String especificacaoCargo;

    @Column(length = 300)
    private String outro;

    @Column(length = 2)
    private String uf;

    @Column(precision = 2)
    private double remuneracao;

    @Column(name="vale_transporte")
    private boolean valeTransporte;

    @Column(name="vale_refeicao")
    private boolean valeRefeicao;

    @Enumerated(EnumType.STRING)
    @Column(name="forma_contratacao")
    private FormaContratacao formaContratacao;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;

    @OneToMany(mappedBy = "vaga", cascade = CascadeType.ALL)
    private List<Candidato> candidatos= new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecificacaoCargo() {
        return especificacaoCargo;
    }

    public void setEspecificacaoCargo(String especificacaoDeCargo) {
        this.especificacaoCargo = especificacaoDeCargo;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public boolean isValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(boolean valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public boolean isValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(boolean valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public FormaContratacao getFormaDeContratacao() {
        return formaContratacao;
    }

    public void setFormaDeContratacao(FormaContratacao formaContratacao) {
        this.formaContratacao = formaContratacao;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return getId() == vaga.getId() &&
                Objects.equals(getCargo(), vaga.getCargo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCargo());
    }
}



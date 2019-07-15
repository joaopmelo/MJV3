package server.dao;

import server.dominio.*;

public class DaoFactory {

    public DaoGenerico<Empresa> getEmpresaDao(){
        return new DaoGenerico<>(Empresa.class);
    }

    public DaoGenerico<Candidato> getCandidatoDao(){
        return new DaoGenerico<>(Candidato.class);
    }

    public DaoGenerico<Telefone> getTelefoneDao(){
        return new DaoGenerico<>(Telefone.class);
    }

    public DaoGenerico<Acesso> getAcessoDao(){
        return new DaoGenerico<>(Acesso.class);
    }

    public DaoGenerico<Vaga> getVagaDao(){ return new DaoGenerico<>(Vaga.class); }

    public DaoGenerico<ExperienciaProfissional> getExperienciaProfDao(){ return new DaoGenerico<>(ExperienciaProfissional.class); }
}

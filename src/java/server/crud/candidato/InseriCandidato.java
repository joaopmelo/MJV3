package server.crud.candidato;

import server.dao.DaoFactory;
import server.dominio.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "InseriCandidato")
public class InseriCandidato extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        Rg rg = new Rg();
        rg.setNumeroRg(12331545);
        rg.setUfExpedicao("TO");
        rg.setOrgaoExpeditor("SSP");
        try {
            rg.setDataExpedicao("20/08/2008");
        } catch (ParseException e) {
            System.out.println("Erro ao inserir data de expedicao do RG");
            e.printStackTrace();
        }


        Endereco endereco = new Endereco();
        endereco.setCep(77645000);
        endereco.setCidade("Lajeado");
        endereco.setNumero(4);
        endereco.setUf("TO");


        Candidato candidato = new Candidato();
        candidato.setCpf("123123123123");
        candidato.setNome("Julia Batista");
        candidato.setSexo(Sexo.FEMININO);
        candidato.setEstadoCivil(EstadoCivil.CASADO);
        candidato.setRg(rg);
        candidato.setDataNascimento("12/09/1998");
        candidato.setEndereco(endereco);

        DaoFactory dao = new DaoFactory();

        Telefone telefone = dao.getTelefoneDao().findById(1);
        candidato.setTelefone(telefone);

        Vaga vaga = dao.getVagaDao().findById(1);
        candidato.setVaga(vaga);

        dao.getCandidatoDao().add(candidato);





    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

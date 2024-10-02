package servicos;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.GuerreiroDAO;
import model.Guerreiro;

public class GuerreiroServicos {

    GuerreiroDAO gDAO = DAOFactory.getGuerreiroDAO();

    public void cadastrarGuerreiro(Guerreiro gVO) {
        gDAO.cadastrarGuerreiro(gVO);
    }

    public ArrayList<Guerreiro> listaGuerreiros() {
        return gDAO.getGuerreiros();
    }// daqui pra cima é para ler e adicinar no banco de dados

    public Guerreiro buscaGuerreiroByNome(String nome) {
        return gDAO.getGuerreiroByNome(nome);
    }

    public void atualizarGuerreiro(Guerreiro gVO) {
        gDAO.atualizarGuerreiro(gVO);
    }

    public boolean deletarGuerreiro(int id) {
        return gDAO.deletarGuerreiro(id);
    }
    
    public Guerreiro getGuerreiroById (int id){
        return gDAO.getGuerreiroById(id);
    }
}// fim clas guerreiros

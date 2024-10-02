package servicos;

import dao.DAOFactory;
import dao.LadraoDAO;
import java.util.ArrayList;
import model.Ladrao;

public class LadraoServicos {

    LadraoDAO lDAO = DAOFactory.getLadraoDAO();

    public void cadastrarLadrao(Ladrao lVO) {
        lDAO.cadastrarLadrao(lVO);
    }

    public ArrayList<Ladrao> listaLadroes(){
        return lDAO.getLadraos();
    }
    
    public Ladrao buscaLadraoByNome (String nome){
        return lDAO.getLadraoByNome(nome);
    }
    
    public void atualizarLadrao(Ladrao lVO){
        lDAO.atualizarLadrao(lVO);
    }
    
    public boolean deletarLadrao(int id) {
        return lDAO.deletarLadrao(id);
    }
    
    public Ladrao getLadraoById (int id){
        return lDAO.getLadraoById(id);
    }
}

package servicos;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.VitimaDAO;
import model.Pessoa;

public class VitimaServicos {
    VitimaDAO vDAO = DAOFactory.getVitimaDAO();

    public void cadastrarVitima(Pessoa vVO) {
        vDAO.cadastrarVitima(vVO);
    }

    public ArrayList<Pessoa> listaVitimas(){
        return vDAO.getVitimas();
    }

    public Pessoa buscaVitimaByNome (String nome){
        return vDAO.getVitimaByNome(nome);
    }

    public void atualizarVitima(Pessoa vVO){
        vDAO.atualizarVitima(vVO);
    }

    public boolean deletarVitima(int id){
        return vDAO.deletarVitima(id);
    }
    
    public Pessoa getVitimaById (int id){
    return vDAO.getVitimaById(id);
    }
}

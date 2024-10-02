package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Ladrao;

public class LadraoDAO {

    public void cadastrarLadrao(Ladrao lVO) {
        try {
            Connection con = Conexao.getConexao();
            // id | nome | olho | cabelo | pele | sexo | armamento | planoDeFuga |
            // pontosDeVida
            String sql = "insert into pessoa values "
                    + "(null, ?, ?, ?, ?, ?, null, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getNome());
            pst.setString(2, lVO.getOlho());
            pst.setString(3, lVO.getCabelo());
            pst.setString(4, lVO.getPele());
            pst.setBoolean(5, lVO.isSexo());
            // pst.setString(6, pVO.getArmamento());
            pst.setString(6, lVO.getPlanoDeFuga());
            pst.setInt(7, lVO.getPontoDeVida());
            pst.execute();
            System.out.println("Ladrão cadastrado com sucesso!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Ladrão.\n"
            + e.getMessage());
        }
    }
    
    public ArrayList<Ladrao> getLadraos() {
        ArrayList<Ladrao> ladraos = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where armamento is null "
                    + "and planoDeFuga is not null ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Ladrao ladrao = new Ladrao();
                
                // lado da aplicação | (lado do banco)
                ladrao.setId(rs.getInt("id"));
                ladrao.setNome(rs.getString("nome"));
                ladrao.setCabelo(rs.getString("cabelo"));
                ladrao.setOlho(rs.getString("olho"));
                ladrao.setPele(rs.getString("pele"));
                ladrao.setSexo(rs.getBoolean("sexo"));
                ladrao.setPontoDeVida(rs.getInt("pontosDeVida"));
                ladrao.setPlanoDeFuga(rs.getString("planoDeFuga"));
                ladraos.add(ladrao);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Ladrão.\n"
                    + e.getMessage());
        }
        return ladraos;
    }//daqui pra cima inserir a vitima no banco de dados
    
    public Ladrao getLadraoByNome(String nome) {
        Ladrao l = new Ladrao();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setCabelo(rs.getString("cabelo"));
                l.setOlho(rs.getString("olho"));
                l.setPele(rs.getString("pele"));
                l.setSexo(rs.getBoolean("sexo"));
                l.setPontoDeVida(rs.getInt("pontosDeVida"));
                l.setPlanoDeFuga(rs.getString("planoDeFuga"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Ladrão.\n" + e.getMessage());
        }
        return l;
    }//daqui pra cima pesquisa por nome no banco de dados
    
    public Ladrao getLadraoById(int id) {
        Ladrao l = new Ladrao();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                l.setId(rs.getInt("id"));
                l.setNome(rs.getString("nome"));
                l.setCabelo(rs.getString("cabelo"));
                l.setOlho(rs.getString("olho"));
                l.setPele(rs.getString("pele"));
                l.setSexo(rs.getBoolean("sexo"));
                l.setPontoDeVida(rs.getInt("pontosDeVida"));
                l.setPlanoDeFuga(rs.getString("planoDeFuga"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Ladrão.\n" + e.getMessage());
        }
        return l;
    }

    public void atualizarLadrao(Ladrao lVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, cabelo = ?, olho = ?, pele = ?, planoDeFuga=? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getNome());
            pst.setString(2, lVO.getCabelo());
            pst.setString(3, lVO.getOlho());
            pst.setString(4, lVO.getPele());
            pst.setString(5, lVO.getPlanoDeFuga());
            pst.setInt(6, lVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Ladrão.\n" + e.getMessage());
        }
    }//atualizar vitima no banco de dados
    
    public boolean deletarLadrao(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar ladrão.\n" + e.getMessage());
        }
        return true;
    }
    
}//fim ladraoDAO

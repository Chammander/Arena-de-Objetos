package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Guerreiro;

public class GuerreiroDAO {
    public void cadastrarGuerreiro(Guerreiro gVO) {
        try {
            Connection con = Conexao.getConexao();
            // id | nome | olho | cabelo | pele | sexo | armamento | planoDeFuga |
            // pontosDeVida
            String sql = "insert into pessoa values "
                    + "(null, ?, ?, ?, ?, ?, ?, null, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getNome());
            pst.setString(2, gVO.getOlho());
            pst.setString(3, gVO.getCabelo());
            pst.setString(4, gVO.getPele());
            pst.setBoolean(5, gVO.isSexo());
            pst.setString(6, gVO.getArmamento());
            // pst.setString(7, pVO.getplanoDeFuga());
            pst.setInt(7, gVO.getPontoDeVida()); 
            pst.execute();
            System.out.println("Guerreiro cadastrado com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Guerreiro.\n" + e.getMessage());
        }
    }

    public ArrayList<Guerreiro> getGuerreiros() {
        ArrayList<Guerreiro> guerreiros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where armamento is not null "
                    + "and planoDeFuga is null ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Guerreiro guerreiro = new Guerreiro();
                guerreiro.setId(rs.getInt("id"));
                guerreiro.setNome(rs.getString("nome"));
                guerreiro.setCabelo(rs.getString("cabelo"));
                guerreiro.setOlho(rs.getString("olho"));
                guerreiro.setPele(rs.getString("pele"));
                guerreiro.setSexo(rs.getBoolean("sexo"));
                guerreiro.setArmamento(rs.getString("armamento"));
                guerreiro.setPontoDeVida(rs.getInt("pontosDeVida"));
                guerreiros.add(guerreiro);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Guerreiro.\n"
                    + e.getMessage());
        }
        return guerreiros;
    }// daqui pra cima é so para ler e importar para o banco de dados

    public Guerreiro getGuerreiroByNome(String nome) {
        Guerreiro g = new Guerreiro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setCabelo(rs.getString("cabelo"));
                g.setOlho(rs.getString("olho"));
                g.setPele(rs.getString("pele"));
                g.setSexo(rs.getBoolean("sexo"));
                g.setArmamento(rs.getString("armamento"));
                g.setPontoDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Guerreiro.\n" + e.getMessage());
        }
        return g;
    }// buscar o guerreiro pelo nome

    public Guerreiro getGuerreiroById(int id) {
        Guerreiro g = new Guerreiro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setCabelo(rs.getString("cabelo"));
                g.setOlho(rs.getString("olho"));
                g.setPele(rs.getString("pele"));
                g.setSexo(rs.getBoolean("sexo"));
                g.setArmamento(rs.getString("armamento"));
                g.setPontoDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Vítima.\n" + e.getMessage());
        }
        return g;
    }//busca guerreiro pelo id
    
    public void atualizarGuerreiro(Guerreiro gVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, cabelo = ?, olho = ?, pele = ?, armamento = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gVO.getNome());
            pst.setString(2, gVO.getCabelo());
            pst.setString(3, gVO.getOlho());
            pst.setString(4, gVO.getPele());
            pst.setString(5, gVO.getArmamento());
            pst.setInt(6, gVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Guerreiro.\n"
                    + e.getMessage());
        }
    }// atualizar cabelo do guerreiro

    public boolean deletarGuerreiro(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deleta Guerreiro.\n"
                    + e.getMessage());
        }
        return true;
    }// deletar guereiro

}// fim guerreiro DAO

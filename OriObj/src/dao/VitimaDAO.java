package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.Conexao;
import model.Pessoa;

public class VitimaDAO {
    public void cadastrarVitima(Pessoa vVO) {
        try {
            Connection con = Conexao.getConexao();
            // id | nome | olho | cabelo | pele | sexo | armamento | planoDeFuga |
            // pontosDeVida
            String sql = "insert into pessoa values "
                    + "(null, ?, ?, ?, ?, ?, null, null, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getOlho());
            pst.setString(3, vVO.getCabelo());
            pst.setString(4, vVO.getPele());
            pst.setBoolean(5, vVO.isSexo());
            // pst.setString(6, pVO.getArmamento());
            pst.setInt(6, vVO.getPontoDeVida());
            // pst.setInt(6, pVO.getPontoDeVida()); ADICIONAR NA TABELA MSQL
            pst.execute();
            System.out.println("Vítima cadastrada com sucesso!!!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Pessoa.\n" + e.getMessage());
        }
    }

    public ArrayList<Pessoa> getVitimas() {
        ArrayList<Pessoa> vitimas = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa "
                    + "where armamento is null "
                    + "and planoDeFuga is null ";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Pessoa vitima = new Pessoa();
                
                // lado da aplicação | (lado do banco)
                vitima.setId(rs.getInt("id"));
                vitima.setNome(rs.getString("nome"));
                vitima.setCabelo(rs.getString("cabelo"));
                vitima.setOlho(rs.getString("olho"));
                vitima.setPele(rs.getString("pele"));
                vitima.setSexo(rs.getBoolean("sexo"));
                vitima.setPontoDeVida(rs.getInt("pontosDeVida"));
                vitimas.add(vitima);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Vítima.\n"
                    + e.getMessage());
        }
        return vitimas;
    }//daqui pra cima inserir a vitima no banco de dados

    public Pessoa getVitimaByNome(String nome) {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where nome like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCabelo(rs.getString("cabelo"));
                v.setOlho(rs.getString("olho"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontoDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Vítima.\n" + e.getMessage());
        }
        return v;
    }//daqui pra cima pesquisa por nome no banco de dados
    
    public Pessoa getVitimaById(int id) {
        Pessoa v = new Pessoa();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // lado da aplicação | (lado do banco)
                v.setId(rs.getInt("id"));
                v.setNome(rs.getString("nome"));
                v.setCabelo(rs.getString("cabelo"));
                v.setOlho(rs.getString("olho"));
                v.setPele(rs.getString("pele"));
                v.setSexo(rs.getBoolean("sexo"));
                v.setPontoDeVida(rs.getInt("pontosDeVida"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Vítima.\n" + e.getMessage());
        }
        return v;
    }

    public void atualizarVitima(Pessoa vVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update pessoa set nome = ?, cabelo = ?, olho = ?, pele = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vVO.getNome());
            pst.setString(2, vVO.getCabelo());
            pst.setString(3, vVO.getOlho());
            pst.setString(4, vVO.getPele());
            pst.setInt(5, vVO.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Vítima.\n" + e.getMessage());
        }
    }//atualizar vitima no banco de dados

    public boolean deletarVitima(int id) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from pessoa where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            return pst.executeUpdate() != 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar vítima.\n" + e.getMessage());
        }
        return true;
    }

}// fim VitimaDAO

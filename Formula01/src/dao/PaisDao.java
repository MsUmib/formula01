package dao;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PaisDao {
    public static List<String[]> consultar() 
    {
        List<String[]> resultados = new ArrayList<>();
        String sql = "SELECT sigla, nome FROM pais";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[2];
                linha[0] = rs.getString("sigla");
                linha[1] = rs.getString("nome");
                resultados.add(linha);
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static boolean inserir(String sigla, String nome)
    {
        String sql = "INSERT INTO pais (sigla, nome) VALUES (?, ?)";
        try
        {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, sigla);
            ps.setString(2, nome);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }
        public static boolean alterar(String sigla, String nome) 
        {
            String sql = "UPDATE pais SET nome = ? WHERE sigla = ?";
            try 
            {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, nome);
                ps.setString(2, sigla);
                ps.executeUpdate();
                return true;
            } 
            catch (SQLException | ClassNotFoundException ex) 
            {
                System.out.println(ex.getMessage());
                return false;
            }
        }
        public static boolean excluir(String sigla)
        {
            String sql = "DELETE FROM pais WHERE sigla = ?";
            try
            {
                PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
                ps.setString(1, sigla);
                ps.executeUpdate();
                return true;
            } 
            catch (SQLException | ClassNotFoundException ex) 
            {
                System.out.println(ex.getMessage());
                return false;
            }
        }
    public static void main(String[] args) {
        boolean resultado = alterar("BR", "Brasil");
        if (resultado){
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}

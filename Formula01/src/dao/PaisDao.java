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
    public static void main(String[] args) {
        boolean resultado = alterar("BR", "brail");
        if (resultado){
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}

package dao;

import apoio.ConexaoBD;
import entidade.Curriculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class CurriculoDAO {
    
    public List<Curriculo> buscarCurriculos(){
        Connection conn = new ConexaoBD().getConnection();
        List<Curriculo> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CURRICULOS";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codId = resultSet.getInt("cod_id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String dataNascimento = resultSet.getString("data_nascimento");
                Curriculo c = new Curriculo(codId.longValue(), nome, email, telefone, dataNascimento);
                lista.add(c);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return lista;
    }
    
    public void editarCurriculo(Curriculo curriculo){
        Connection conn = new ConexaoBD().getConnection();
        try {
            String sql = "UPDATE CURRICULOS SET NOME = ?, EMAIL = ?, TELEFONE = ?, DATA_NASCIMENTO = ? WHERE COD_ID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);            
            preparedStatement.setString(1, curriculo.getNome());
            preparedStatement.setString(2, curriculo.getEmail());
            preparedStatement.setString(3, curriculo.getTelefone());
            preparedStatement.setString(4, curriculo.getDataNascimento());
            preparedStatement.setLong(5, curriculo.getCodId());
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void cadastrarCurriculo(Curriculo curriculo){
        try{
            Connection conn = new ConexaoBD().getConnection();
            String sql = "INSERT INTO CURRICULOS (NOME, EMAIL, TELEFONE, DATA_NASCIMENTO) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);   
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, curriculo.getNome());
            preparedStatement.setString(2, curriculo.getEmail());
            preparedStatement.setString(3, curriculo.getTelefone());
            preparedStatement.setString(4, curriculo.getDataNascimento());
            preparedStatement.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void excluirCurriculo(Long codId){
        Connection conn = new ConexaoBD().getConnection();
        try {
            String sql = "DELETE FROM CURRICULOS WHERE COD_ID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);            
            preparedStatement.setLong(1, codId);
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

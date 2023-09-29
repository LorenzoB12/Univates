package dao;

import apoio.ConexaoBD;
import entidade.Curriculo;
import entidade.Pessoas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author loren
 */
public class PessoasDAO {
    
    public List<Pessoas> buscarPessoas(){
        Connection conn = new ConexaoBD().getConnection();
        List<Pessoas> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM PESSOA";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer codId = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                Pessoas p = new Pessoas(codId.longValue(), nome, email, telefone);
                lista.add(p);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return lista;
    }
    
}

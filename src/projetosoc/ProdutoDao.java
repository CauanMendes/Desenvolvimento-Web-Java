package projetosoc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDao {
	public Produto findById(int id) {
		
		Produto p = new Produto();
		
		try {
			Statement stmt = DatabaseConnector.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, descricao, preco FROM produto WHERE id = " + id);
			
			if(rs.next()) {
				p.setId(rs.getInt(id));
				p.setDescricao(rs.getString("descricao"));
				p.setPreco(rs.getDouble("preco"));
			}
			rs.close();
			stmt.close();
			
			DatabaseConnector.getConnection().close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return p;
		
	}
}
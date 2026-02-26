package projetosoc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDao {
	public Cliente findById(int id) {
		
		Cliente c = new Cliente();
		
		try {
			Statement stmt = DatabaseConnector.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, nome, email FROM cliente WHERE id = " + id);
			
			if(rs.next()) {
				c.setId(rs.getInt(id));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
			}
			rs.close();
			stmt.close();
			
			DatabaseConnector.getConnection().close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return c;
		
	}
}

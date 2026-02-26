package projetosoc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
	
	static {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private int id;
	private String nome;
	private String email;

	public void loadFromDatabase() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/loja", "root", "root");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, nome, email FROM cliente WHERE id = " + this.id);
			
			
			if(rs.next()) {
				this.nome = rs.getString("nome");
				this.email = rs.getString("email");
			}
			rs.close();
			stmt.close();
			
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

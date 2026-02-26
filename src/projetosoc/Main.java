package projetosoc;

public class Main {
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		
		c.setId(1);
		
		c.loadFromDatabase();
		
		System.out.println("Nome: " + c.getNome());
		System.out.println("Email: " + c.getEmail());

	}
}

package projetosoc;

public class Main {
	public static void main(String[] args) {
		
		ClienteDao cDAO = new ClienteDao();
		
		Cliente c = cDAO.findById(1);
		
		System.out.println("Nome: " + c.getNome());
		System.out.println("Email: " + c.getEmail());
		
		ProdutoDao pDAO = new ProdutoDao();
		
		Produto p = pDAO.findById(1);
		
		System.out.println("Descrição: " + p.getDescricao());
		System.out.println("Preço: " + p.getPreco());

	}
}

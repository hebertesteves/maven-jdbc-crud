import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepository repository = new CadastroRepository();
        Cadastro cadastro = new Cadastro("Maria", 17);
        cadastro.setId(4);

        //repository.incluir(cadastro);
        repository.alterar(cadastro);
        repository.excluir(4);

        List<Cadastro> cadastros = repository.listar();
        for (Cadastro c: cadastros) {
            System.out.println("Id: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Idade: " + c.getIdade());
            System.out.println();
        }

        Cadastro cadastro1 = repository.buscar(1);
        if (cadastro1 != null) {
            System.out.println("Id: " + cadastro1.getId());
            System.out.println("Nome: " + cadastro1.getNome());
            System.out.println("Idade: " + cadastro1.getIdade());
        } else {
            System.out.println("Não foi possivel localizar o cadastro pelo id");
        }

    }
}

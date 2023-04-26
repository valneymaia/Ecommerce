import java.util.Scanner;

public class App {
public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);  
    //System.out.print("Digite seu nome: ");
    //String nome = scanner.nextLine();
    //System.out.print("Digite seu CPF: ");
    //String cpf = scanner.nextLine();
    //System.out.print("Digite seu saldo da conta: ");
    // double saldoa = scanner.nextDouble();

    Repositorio estoque = new Repositorio();

    Dados produto1 = new Dados("Redmi note 11");
    Dados produto2 = new Dados("Redmi note 10 pro");
    Dados produto3 = new Dados("Redmi note 11s");
    Dados produto4 = new Dados("Poco M5S");

    estoque.adicionarProduto(produto1);
    estoque.adicionarProduto(produto2);
    estoque.adicionarProduto(produto3);
    estoque.adicionarProduto(produto4);

    System.out.println(estoque.getListaprodutos());
    System.out.println();
    
    int escolha = 0;
    do {
        System.out.println("==== MENU DE OPÇÕES ====");
        System.out.println("1. Comprar");
        System.out.println("2. Lista de produtos");
        System.out.println("3. ");
        System.out.println("4. Sair");

        escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Digite o índice do produto que deseja comprar:");
                int indice = scanner.nextInt();
                estoque.comprar(indice);
                break;
            case 2:
                System.out.println(estoque.getListaprodutos());
                break;
            case 3:
                
            break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    } while (escolha != 4);
}
}

package Teste;
import java.util.Scanner;
import Dados.Cliente;
import Dados.Suporte;
import Repositorio.Repositorio_Produto;


public class Main{

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Repositorio_Produto estoque = new Repositorio_Produto();

        Cliente c1 = new Cliente("Seu ze", "123.444.567.00", 1000);

        Suporte suporte1 = new Suporte();
        c1.criarCartao();

        int escolha = 0;
        int escolha3 = 1, quantidade;
        do {
            menu();

            escolha = teclado.nextInt();

            switch (escolha) {
                case 1:
                    estoque.printar();
                    System.out.print("Digite a opção desejada:\n(1) Comprar por nome\n(2) Comprar por código de barras\n");
                    int escolha2 = teclado.nextInt();
                    teclado.nextLine();

                    if (escolha2 == 1) {
                        for(;;) {
                            System.out.print("Nome: [0] para finalizar ");
                            String nome = teclado.nextLine();

                            if(nome.strip().equals("0"))
                                break;

                            System.out.print("Quantidade: ");
                            quantidade = teclado.nextInt();

                            c1.adicionarAoCarrinho(estoque.estoque, nome, quantidade);
                            teclado.nextLine();
                        }
                        c1.finalizarCompra();
                    }
                    else if (escolha2 == 2) {
                        for(;;) {
                            System.out.print("Codigo: [0] para finalizar ");
                            int codigo = teclado.nextInt();

                            if(codigo == 0)
                                break;
                            System.out.print("Quantidade: ");
                            quantidade = teclado.nextInt();

                            c1.adicionarAoCarrinho(estoque.estoque, codigo, quantidade);
                        }
                        c1.finalizarCompra();
                    }

                    else {
                        System.out.println("opçao inválida.");
                    }
                    break;
                case 2:
                    System.out.println(c1);
                    break;

                case 3:
                    System.out.println("desejar ser vip, pagando 40 reais e ganhar 20% descontos? (1) sim, (2) nao?");
                    escolha3 = teclado.nextInt();
                    teclado.nextLine();

                    if (escolha3 == 1) {
                        c1.tornarVIP();
                    }
                    else {
                        System.out.println("opçao inválida.");
                    }
                    break;

                case 4:
                    c1.cancelarVIP();
                    break;

                case 5:
                    suporte1.alterarEstoque(estoque);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (escolha != 6);
    }


    public static void menu() {
        System.out.println("""
                \n========= ECOMMERCE RV ==========
                ======== MENU DE OPÇÕES =========
                1. Comprar produto
                2. Consultar Perfil
                3. Assinar  vip
                4. Cancelar vip
                5. Modificar estoque(Suporte)
                6. Sair
                =================================\s
                """);
    }
}





 /*
        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();

        System.out.print("Digite seu salário: ");
        float salario = teclado.nextFloat();
        */

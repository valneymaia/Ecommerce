package Teste;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import Dados.Produto;
import Dados.Cliente;
import Dados.Suporte;
import Repositorio.Repositorio_Produto;

public class Main{
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        List<Produto> produtosNovos = new ArrayList<Produto>();
        Scanner scannerProduto = new Scanner(new File("C:\\Users\\usuario\\IdeaProjects\\Ecomerce\\src\\Dados\\produtos.csv"));
        scannerProduto.useDelimiter(";");
        while(scannerProduto.hasNext()) {
            System.out.println(scannerProduto.next());
        }
        /*
        Produto sabonete = new Produto("Sabonete", 2.90f, 123);
        Produto arroz = new Produto("Arroz Branco", 4.90f, 666);
        Produto acucar = new Produto("Açucar", 3.90f, 987);
        */

        Repositorio_Produto estoque = new Repositorio_Produto();
        Cliente c1 = new Cliente("Seu ze", "123.444.567.00", 1000);
        Suporte suporte1 = new Suporte();
        c1.criarCartao();

        int escolha = 0;
        int escolha3 = 1, quantidade;
        do {
            System.out.println("========= ECOMMERCE RV ==========");
            System.out.println("======= MENU DE OPÇÕES ========");
            System.out.println("1. Comprar produtos");
            System.out.println("2. Consultar Perfil");
            System.out.println("3. Assinar  vip");
            System.out.println("4. Cancelar vip");
            System.out.println("5. Modificar estoque");
            System.out.println("6. Sair");
            System.out.println("===============================");

            escolha = teclado.nextInt();

            switch (escolha) {
                case 1:
                    estoque.printar();
                    System.out.print("Digite a opção desejada:\n(1) Comprar por nome\n(2) Comprar por código de barras\n");
                    int escolha2 = teclado.nextInt();
                    teclado.nextLine();

                    if (escolha2 == 1) {
                        for(;;) {
                            System.out.print("digite '0' para finalizar comprar:");
                            System.out.print("Nome: ");
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
                            System.out.println("digite '0' para finalizar comprar:");
                            System.out.print("Codigo: ");
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
                    c1.Perfil();
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
                    suporte1.alterarEstoque(estoque, produtosNovos);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (escolha != 6);
    }}





 /*
        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();

        System.out.print("Digite seu salário: ");
        float salario = teclado.nextFloat();
        */

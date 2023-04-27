package Teste;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

import Dados.Cartao;
import Dados.CartaoPrata;
import Dados.CartaoVIP;
import Dados.Produto;
import Repositorio.Cliente;
import Repositorio.Estoque;

public class Main{
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        List<Produto> produtos = new ArrayList<Produto>();

        /*
        System.out.print("Digite seu nome: ");
        String nome = teclado.nextLine();

        System.out.print("Digite seu salário: ");
        float salario = teclado.nextFloat();
        */


        Cliente c1 = new Cliente("Seu ze", "123.444.567.00", 1000);
        c1.criarCartao();
        c1.printarCartao();

        Produto sabonete = new Produto("Sabonete", 2.90f, 123);
        Produto arroz = new Produto("Arroz branco", 4.90f, 666);
        Produto acucar = new Produto("Açucar", 3.90f, 987);

        produtos.add(sabonete);
        produtos.add(arroz);
        produtos.add(acucar);

        Estoque estoque = new Estoque(produtos);
        estoque.printar();

        int escolha = 0;
        do {
            System.out.println("==== MENU DE OPÇÕES ====");
            System.out.println("1. Comprar");
            System.out.println("2. consultar limite");
            System.out.println("3. Ser vip");
            System.out.println("4. Cancelar vip");
            System.out.println("5. Sair");

            escolha = teclado.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite a opção desejada:\n(1) Comprar por nome\n(2) Comprar por código de barras\n");
                    int escolha2 = teclado.nextInt();
                    teclado.nextLine();
                    if (escolha2 == 1) {
                        System.out.print("Nome: ");
                        String nome = teclado.nextLine();

                        System.out.print("Quantidade: ");
                        int quantidade = teclado.nextInt();
                        c1.comprar(produtos, nome, quantidade);

                    } else if (escolha2 == 2) {
                        System.out.print("Codigo: ");
                        int codigo = teclado.nextInt();

                        System.out.print("Quantidade: ");
                        int quantidade = teclado.nextInt();
                        c1.comprar(produtos, codigo, quantidade);
                    } else {
                        System.out.println("opçao inválida.");
                    }
                    break;

                case 2:
                    System.out.println("o limite do seu cartao e: ");
                    c1.printarCartao();
                    break;
                case 3:
                    System.out.println("desejar ser vip, pagando 50 reais e ganhando descontos? (1) sim, (2) nao?");
                    int escolha3 = teclado.nextInt();
                    teclado.nextLine();
                    if (escolha3 == 1) {
                        c1.tornarVIP();
                    } else {
                        System.out.println("opçao inválida.");
                    }
                    break;
                case 4:
                    c1.cancelarVIP();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (escolha != 5);
    }}

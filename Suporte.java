package Dados;

import Repositorio.Repositorio_Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import  java.util.Scanner;

public class Suporte {

    static Scanner teclado = new Scanner(System.in);


    public void alterarEstoque(Repositorio_Produto estoque, List<Produto> novos) throws IOException {
        String teste = "src/Dados/senha.txt";
        BufferedReader reader = new BufferedReader(new FileReader(teste));
        String senha = reader.readLine();
        reader.close();

        System.out.print("Senha de acesso: ");
        String tentativa = teclado.nextLine();

        if(tentativa.equals(senha)) {
            for(;;) {
                menu();
                int escolha = teclado.nextInt();

                String nome; int codigo;  float preco;
                switch (escolha) {
                    case 1:
                        teclado.nextLine();
                        System.out.print("digite o nome: ");
                        nome = teclado.nextLine();
                        System.out.print("digite o preço: ");
                        preco = teclado.nextFloat();
                        System.out.print("digite o codigo: ");
                        codigo = teclado.nextInt();

                        estoque.adicionarProduto(new Produto(nome, preco, codigo));
                        break;

                    case 2:
                        if(estoque.isEmpty()) {
                            System.out.println("Estoque vazio.");
                            break;
                        }

                        System.out.print("digite o nome do produto que deseja remover:");
                        teclado.nextLine();
                        nome = teclado.nextLine();
                        estoque.remover(nome);
                        break;

                    case 3:
                        estoque.remover();
                        break;

                    case 4:
                        teclado.nextLine();
                        System.out.print("digite o nome: ");
                        nome = teclado.nextLine();
                        System.out.print("digite o novo preço: ");
                        preco = teclado.nextFloat();

                        estoque.alterarProduto(nome, preco);
                        break;

                    case 5:
                        estoque.printar();
                        break;

                    case 6:
                        if(novos.isEmpty()) {
                            System.out.println("Vazio.");
                            break;
                        }

                        for (Produto produto : novos) {
                            estoque.adicionarProduto(produto);
                        }
                        break;

                    default:
                        System.out.println("Saindo...");
                        return;
                }
            }
        }
        else {
            System.out.println("Senha incorreta.");
        }
    }

    private void menu() {
        System.out.println("""
                \n1. Adicionar produto
                2. Remover produto por nome
                3. Remover todos os produtos
                4. Alterar preço
                5. Imprimir
                6. Adicionar por txt.
                7. Sair\s
                """);
    }

    private void clearBuffer() {
        while(teclado.hasNext("\n")) {
            teclado.next();
        }
    }

}

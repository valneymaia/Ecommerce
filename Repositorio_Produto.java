package Repositorio;
import Dados.Produto;

import java.util.ArrayList;
import java.util.List;


public class Repositorio_Produto {

    public List<Produto> estoque = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        estoque.add(produto);
    }


    public void adicionarProduto(String nome, float preco, int codigo) {
        Produto produto = new Produto(nome, preco, codigo);
        estoque.add(produto);
    }


    public void remover(String nome) {
        if(estoque.isEmpty()) {
            System.out.println("Estoque vazio, não foi possível remover.");
            return;
        }

        for(Produto produto : estoque) {
            if(produto.getNome().equals(nome)) {
                estoque.remove(produto);
                System.out.println("Produto removido.");
                return;
            }
        }
    }


    public void remover() {
        if(estoque.isEmpty()) {
            System.out.println("Estoque vazio, não foi possível remover.");
            return;
        }
        estoque.clear();
    }


    public void alterarProduto(String nome, float novoPreco) {
        if(estoque.isEmpty()) {
            System.out.println("Estoque vazio, não foi possível alterar.");
            return;
        }
        for(Produto produto : estoque) {
            if(produto.getNome().equals(nome)) {
                produto.setPreco(novoPreco);
                System.out.println("Produto alterado.");
                return;
            }
        }
    }


    public void printar() {

        if(estoque.isEmpty()) {
            System.out.println("Estoque vazio, não foi possível printar.");
            return;
        }

        System.out.println("====== LISTA DE PRODUTOS ======");
        for (Produto a : this.estoque) {
            System.out.println("Codigo: " + a.getCodigo() + "\t" + a.getNome() +  "  \tPreço: " +a.getPreco());
        }
        System.out.print("\n");
    }

    public boolean isEmpty() {
        return this.estoque.isEmpty();
    }

}

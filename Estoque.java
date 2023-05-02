package Repositorio;
import Dados.Produto;

import java.util.ArrayList;
import java.util.List;


public class Estoque {

    public List<Produto> estoque;

    public Estoque(List<Produto> produtos) {
        this.estoque  = produtos;
    }

    public void printar() {
        System.out.println("====== LISTA DE PRODUTOS ======");
        for (Produto a : this.estoque) {
            System.out.println("Codigo: " + a.getCodigo() + "\t" + a.getNome() +  "  \tPreço: " +a.getPreco());
        }
        System.out.print("\n");
    }
}

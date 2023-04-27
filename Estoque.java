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
        for (Produto a : this.estoque) {
            System.out.println(a.getNome() + "     Codigo: " + a.getCodigo()+ "   Preço: " +a.getPreco());
        }

        System.out.print("\n");
    }
}

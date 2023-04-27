package Dados;

import Dados.Cartao;

public class CartaoVIP extends Cartao {

    public CartaoVIP(String nome, String CPF) {
        super(nome, CPF);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void debitar(float valor) {
        System.out.println("Produto com 20% de desconto.");
        setLimite(getLimite() - valor * 0.8f);
        setFatura(getFatura() + valor * 0.8f);
    }

}

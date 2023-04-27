package Dados;

import Dados.Cartao;

public class CartaoPrata extends Cartao {

    public CartaoPrata(String nome, String CPF) {
        super(nome, CPF);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void debitar(float valor) {
        setLimite(getLimite() - valor);
        setFatura(getFatura() + valor);
    }

}

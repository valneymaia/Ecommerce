package Dados;
import java.util.*;
import Dados.Cartao;

public class CartaoVIP extends Cartao {

    public CartaoVIP(String nome, String CPF, float salario) {
        super(nome, CPF);
        this.setLimite(salario  / 2 - getFatura());
    }

    @Override
    public void debitar(float valor) {
        setLimite(getLimite() - valor * 0.8f);
        setFatura(getFatura() + valor * 0.8f);
    }

}

package Repositorio;

import Dados.Cartao;
import Dados.CartaoPrata;
import Dados.CartaoVIP;
import Dados.Produto;

import java.util.*;

public class Cliente {
    private String nome;
    private String CPF;
    private float salario;
    private boolean VIP;
    Cartao meuCartao;


    public Cliente(String nome, String CPF, float salario) {
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
        this.VIP = false;
    }

    public void criarCartao() {
        if(this.VIP) {
            meuCartao = new CartaoVIP(nome, CPF);
            meuCartao.setNumero(567);
            meuCartao.setLimite(150);
        }
        else {
            meuCartao = new CartaoPrata(nome, CPF);
            meuCartao.setNumero(123);
            meuCartao.setLimite(50);
        }
    }

    public boolean verificar(String cpf) {
        return (cpf.equals(this.CPF));
    }

    public void comprar(List<Produto> estoque, String nome, int quantidade) {
        for(Produto produto : estoque) {
           if(produto.getNome().equals(nome)) {
               if(produto.getPreco() * quantidade <= meuCartao.getLimite()) {
                   System.out.println("Produto " + produto.getNome() + " comprado em " + quantidade + " unidades. " + " No valor : " + produto.getPreco()*quantidade);
                   meuCartao.debitar(produto.getPreco() * quantidade);
                 //  System.out.println(meuCartao.getLimite());
               }
               else {
                   System.out.println("Limite infuficiete");
               }
               return;
           }
        }
        System.out.println("Produto não encontrado");
    }

    public void comprar(List<Produto> estoque, int codigo, int quantidade) {
        for(Produto produto : estoque) {
            if(produto.getCodigo() == codigo) {
                if(produto.getPreco() * quantidade <= meuCartao.getLimite()) {
                    System.out.println("Produto " + produto.getNome() + " comprado em " + quantidade + " unidades."+" No valor : " + produto.getPreco()*quantidade);
                    meuCartao.debitar(produto.getPreco() * quantidade);
                }
                else {
                    System.out.println("Limite insuficiete");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    public void printarCartao() {
        System.out.println(meuCartao.getLimite());
        System.out.println(this.isVIP() + " vip");

    }

    public void tornarVIP() {
        meuCartao.setFatura(meuCartao.getFatura() + 50.0f);
        if(isVIP()) {
            System.out.println("Já é VIP");
        }
        else {
            System.out.println("VIP ativado com sucesso!");
            setVIP(true);
            meuCartao.setLimite(150 - 50);
        }
    }

    public void cancelarVIP() {
        if (!isVIP()) {
            System.out.println("Voce já não é VIP");
        } else {
            System.out.println("VIP cancelado com sucesso!");
            setVIP(false);
            meuCartao.setLimite(50);
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public boolean isVIP() {
        return VIP;
    }
    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }


    public Cartao getMeuCartao() {
        return meuCartao;
    }
    public void setMeuCartao(Cartao meuCartao) {
        this.meuCartao = meuCartao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome = '" + nome + '\'' +
                ", CPF = '" + CPF + '\'' +
                ", salario = " + salario +
                ", VIP=" + VIP +
                ", meuCartao = " + meuCartao +
                '}' +
                "Cartao nome " + meuCartao.getNome() +
                " Cartao cpf:" + meuCartao.getCPF();
    }
}

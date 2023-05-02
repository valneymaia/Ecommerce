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
            meuCartao = new CartaoPrata(nome, CPF, salario);
            meuCartao.setNumero(567);
    }


    public void comprar(List<Produto> estoque, String nome, int quantidade) {
        for(Produto produto : estoque) {
           if(produto.getNome().equals(nome)) {
               if(produto.getPreco() * quantidade <= meuCartao.getLimite()) {
                   notaFiscal(produto, quantidade);
                   meuCartao.debitar(produto.getPreco() * quantidade);
                   System.out.println("=======================\n");
               }
               else {
                   System.out.println("Limite insuficiente");
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
                    notaFiscal(produto, quantidade);
                    meuCartao.debitar(produto.getPreco() * quantidade);
                    System.out.println("=======================\n");
                }
                else {
                    System.out.println("Limite insuficiente");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    public void printarCartao() {
        System.out.println("limite: " + meuCartao.getLimite());
        System.out.println(this.isVIP() + " vip\n");
    }

    public void tornarVIP() {
        if(!isVIP()) {
            meuCartao = new CartaoVIP(this.nome, this.CPF, this.salario);
            meuCartao.debitar(50.0f);
            setVIP(true);
            System.out.println("VIP ativado.");
        }
        else {
            System.out.println("Já é VIP.");
        }
    }

    public void cancelarVIP() {
        if (!isVIP()) {
            System.out.println("Voce já não é VIP");
        } else {
            meuCartao = new CartaoPrata(this.nome, this.CPF, this.salario);
            setVIP(false);
            System.out.println("VIP cancelado com sucesso!");
        }
    }

    public void notaFiscal(Produto produto, int quantidade) {
        System.out.println("\n===== Nota Fiscal =====");
        System.out.println("Nome: " + meuCartao.getNome());
        System.out.println("CPF: "+ meuCartao.getCPF());
        System.out.println("Cartao N: " + meuCartao.getNumero());
        System.out.println("Itens: " + quantidade + " " + produto.getNome());
        System.out.println("Valor Total: " + produto.getPreco()*quantidade);
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

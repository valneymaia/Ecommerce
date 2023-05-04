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

    private final Map<Produto, Integer> carrinho = new HashMap<Produto, Integer>();
    private  Cartao meuCartao;

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


    public void printarCartao() {
        if(isVIP()){
            System.out.println("Seu cartao é VIP");
        }else{
            System.out.println("Seu cartao é PRATA");
        }
        System.out.println("limite disponivel: " + meuCartao.getLimite());
        System.out.println("Divida atual: " + meuCartao.getFatura());
    }


    public void tornarVIP() {
        if(!isVIP()) {
            System.out.println("Divida antes: " + meuCartao.getFatura());
            meuCartao = new CartaoVIP(this.nome, this.CPF, this.salario);
            meuCartao.debitar(50.0f);

            setVIP(true);
            System.out.println("VIP ativado.");

            System.out.println("Divida depois: " + meuCartao.getFatura());

        }
        else {
            System.out.println("Já é VIP.");
        }
    }


    public void cancelarVIP() {
        if (!isVIP()) {
            System.out.println("Voce já não é VIP");
        } else {
            System.out.println("Divida antes: " + meuCartao.getFatura());
            meuCartao = new CartaoPrata(this.nome, this.CPF, this.salario);
            setVIP(false);
            System.out.println("VIP cancelado com sucesso!");

            System.out.println("Divida depois: " + meuCartao.getFatura());
        }
    }


    public void notaFiscal() {
        System.out.println("\n===== Nota Fiscal =====");
        System.out.println("Nome: " + meuCartao.getNome());
        System.out.println("CPF: "+ meuCartao.getCPF() );
        System.out.println("Compra:");
    }


    public void adicionarAoCarrinho(List<Produto> estoque, String nome, int quantidade) {
        for(Produto produto : estoque) {
           if(produto.getNome().strip().equalsIgnoreCase(nome)) {
               if(produto.getPreco() * quantidade <= meuCartao.getLimite()) {
                   carrinho.put(produto, quantidade);
               }
               else {
                   System.out.println("Limite insuficiente");
               }
               return;
           }
        }
        System.out.println("Produto não encontrado");
    }


    public void adicionarAoCarrinho(List<Produto> estoque, int codigo, int quantidade) {
        for(Produto produto : estoque) {
            if(produto.getCodigo() == codigo) {
                if(produto.getPreco() * quantidade <= meuCartao.getLimite()) {
                    carrinho.put(produto, quantidade);
                }
                else {
                    System.out.println("Limite insuficiente");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }


    public void finalizarCompra() {
        Produto produto;
        float total = 0.0f;

        notaFiscal();
        for(Map.Entry<Produto, Integer> carrinho : this.carrinho.entrySet()) {
            produto = carrinho.getKey();

            System.out.print(produto.getNome() + "  \t" + " Qtd:" + " "
                    + carrinho.getValue() +  " R$: "+ produto.getPreco() +" unidade \n");
            total += produto.getPreco() * carrinho.getValue();
        }

        if(total <= meuCartao.getLimite()) {
            System.out.println("\nPreço Total: R$" + total + "\nCompra efetuada com sucesso!");
            System.out.println("========================");
            meuCartao.debitar(total);
        }
        else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void Perfil(){
        System.out.println("=========== Perfil ===========");
        System.out.println(""+ getNome() + "  CPF: " + getCPF());
        printarCartao();
        System.out.println("==============================");
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

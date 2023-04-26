import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repositorio {
    private List<Dados> estoque ;

    public Repositorio() {
        this.estoque = new ArrayList<Dados>();
    }

    public void adicionarProduto(Dados item){
        this.estoque.add(item);
    }

    public String getListaprodutos() {
        StringBuilder sb = new StringBuilder();
        int posicao = 1;
        for (Dados estoque : estoque) {
            sb.append("\n============================================================");
            sb.append("\n"+posicao + "| " + estoque.getNome());
            posicao++;
        } 
        return sb.toString();
    }


    public void comprar(int index) {
        Scanner scanner = new Scanner(System.in);
        Dados produto = this.estoque.get(index);
    
        System.out.println("Produto selecionado: " + produto.getNome());
        System.out.println("Preço: R$1200,00");
    
        System.out.print("Quantidade desejada: ");
        int quantidade = scanner.nextInt();
    
        if (quantidade > 0 && quantidade <= estoque.size()) {
            double precoTotal = quantidade * 1200.00; //coloca o preco
            if (produto.getSaldo() >= precoTotal) {
                produto.setSaldo(produto.getSaldo() - precoTotal);
                Recibo recibo = new Recibo(produto.getNome(), quantidade, precoTotal);
                System.out.println("Compra realizada com sucesso.\n");
                System.out.println("Novo saldo: R$\n" + produto.getSaldo());
                
                System.out.println("\n==== RECIBO ====");
                System.out.println("Produto: " + recibo.getNomeProduto());
                System.out.println("Quantidade: " + recibo.getQuantidade());
                System.out.println("Preço Total: R$" + recibo.getPrecoTotal());
                System.out.println();
            } else {
                System.out.println("Saldo insuficiente.\n");
            }
        } else {
            System.out.println("Quantidade inválida.\n");
        }
    }

    public class Recibo {
        private String nomeProduto;
        private int quantidade;
        private double precoTotal;
    
        public Recibo(String nomeProduto, int quantidade, double precoTotal) {
            this.nomeProduto = nomeProduto;
            this.quantidade = quantidade;
            this.precoTotal = precoTotal;
        }
    
        public String getNomeProduto() {
            return nomeProduto;
        }
    
        public int getQuantidade() {
            return quantidade;
        }
    
        public double getPrecoTotal() {
            return precoTotal;
        }
    }

}


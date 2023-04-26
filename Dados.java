public class Dados {
    private String nome;
    private String cpf;
    private double saldo;


    public Dados(String nome) {
        this.nome = nome;
        this.cpf = "0999999";
        this.saldo = 5000;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double saldoAtual(double precoTotal){
        return saldo -= precoTotal;

    }
}

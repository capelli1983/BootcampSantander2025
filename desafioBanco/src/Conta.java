import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    protected String agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    protected List<String> transacoes = new ArrayList<>();

    private static final String AGENCIA_PADRAO = "11111-5";

    public Conta(int numero, Cliente cliente, double saldoInicial) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldoInicial;

        if (saldoInicial > 0) {
            transacoes.add(String.format("Depósito: +R$ %.2f", saldoInicial));
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getNumeroFormatado() {
        if (this instanceof ContaPoupanca) {
            return String.format("%05d", this.numero) + "x";
        } else {
            return String.format("%05d", this.numero);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        transacoes.add(String.format("Depósito: +R$ %.2f", valor));
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            transacoes.add(String.format("Saque: -R$ %.2f", valor));
        } else {
            System.out.println("Saldo insuficiente para saque de R$ " + valor);
        }
    }

    @Override
    public void pagarConta(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            transacoes.add(String.format("Pagamento de conta: -R$ %.2f", valor));
        } else {
            System.out.println("Saldo insuficiente para pagamento de R$ " + valor);
        }
    }

    @Override
public void transferir(double valor, Conta contaDestino) {
    if (valor <= saldo) {
        this.saldo -= valor; // não chama sacar para evitar duplicidade
        transacoes.add(String.format("Transferência enviada: -R$ %.2f para conta %s", valor, contaDestino.getNumeroFormatado()));

        contaDestino.saldo += valor;
        contaDestino.transacoes.add(String.format("Transferência recebida: +R$ %.2f da conta %s", valor, this.getNumeroFormatado()));
    } else {
        System.out.println("Saldo insuficiente para transferência de R$ " + valor);
            }
    }

    protected void imprimirDadosComuns() {
        System.out.println("Titular: " + this.cliente.getNomeCliente());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + getNumeroFormatado());
        System.out.printf("Saldo: R$ %.2f\n", this.saldo);
    }

    @Override
    public abstract void imprimirExtrato();
}

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, Cliente cliente, double saldoInicial) {
        super(numero, cliente, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("*** Extrato da Conta Poupança ***");
        imprimirDadosComuns();

        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
        } else {
            System.out.println("Transações:");
            for (String t : transacoes) {
                System.out.println(t);
            }
        }
        System.out.println();
    }
}





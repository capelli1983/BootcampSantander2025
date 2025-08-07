public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Conta contaDestino);

    void pagarConta(double valor);
    
    void imprimirExtrato();
}

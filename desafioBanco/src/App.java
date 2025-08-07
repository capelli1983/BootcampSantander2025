import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        List<ContaCorrente> contasCorrente = new ArrayList<>();
        List<ContaPoupanca> contasPoupanca = new ArrayList<>();

        System.out.println("Bem vindo ao Dio Bank!");
        System.out.println("Vamos criar sua conta para você aproveitar nossos benefícios ao máximo!");

        criarConta(sc, random, contasCorrente, contasPoupanca);

        boolean sair = false;
        
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Saldo");
            System.out.println("2 - Depósito");
            System.out.println("3 - Saque");
            System.out.println("4 - Extrato");
            System.out.println("5 - Transferência");
            System.out.println("6 - Pagamento de contas");
            System.out.println("7 - Criar nova conta");
            System.out.println("0 - Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    mostrarSaldo(sc, contasCorrente, contasPoupanca);
                    break;

                case 2:
                    realizarDeposito(sc, contasCorrente, contasPoupanca);
                    break;

                case 3:
                    realizarSaque(sc, contasCorrente, contasPoupanca);
                    break;

                case 4:
                    mostrarExtrato(sc, contasCorrente, contasPoupanca);
                    break;

                case 5:
                    realizarTransferencia(sc, contasCorrente, contasPoupanca);
                    break;

                case 6:
                    realizarPagamento(sc, contasCorrente, contasPoupanca);
                    break;

                case 7:
                    sc.nextLine();
                    criarConta(sc, random, contasCorrente, contasPoupanca);
                    break;

                case 0:
                    sair = true;
                    System.out.println("Obrigado por usar o Dio Bank. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }

    private static void criarConta(Scanner sc, Random random, List<ContaCorrente> contasCorrente, List<ContaPoupanca> contasPoupanca) {

        System.out.print("Digite seu nome completo: ");
        String nome = sc.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNomeCliente(nome);

        int numeroConta = random.nextInt(99999) + 1;

        System.out.print("Digite o saldo inicial para conta corrente : R$ ");
        double saldoCC = sc.nextDouble();

        System.out.print("Digite o saldo inicial para conta poupança : R$ ");
        double saldoPoupanca = sc.nextDouble();

        ContaCorrente cc = new ContaCorrente(numeroConta, cliente, saldoCC);
        ContaPoupanca cp = new ContaPoupanca(numeroConta, cliente, saldoPoupanca);

        contasCorrente.add(cc);
        contasPoupanca.add(cp);

        System.out.println("\nParabéns, agora você faz parte do Dio Bank!\n");
        System.out.println("Nome do Titular: " + cliente.getNomeCliente());
        System.out.println("Conta Corrente: " + cc.getNumeroFormatado());
        System.out.println("Conta Poupança: " + cp.getNumeroFormatado());
        System.out.printf("Saldo Conta Corrente: R$ %.2f\n", cc.getSaldo());
        System.out.printf("Saldo Conta Poupança: R$ %.2f\n", cp.getSaldo());
    }

    private static ContaCorrente buscarContaCorrente(Scanner sc, List<ContaCorrente> contasCorrente) {
        System.out.print("Digite o número da conta corrente: ");
        int num = sc.nextInt();
        for (ContaCorrente cc : contasCorrente) {
            if (cc.getNumero() == num) {
                return cc;
            }
        }
        System.out.println("Conta corrente não encontrada.");
        return null;
    }

    private static ContaPoupanca buscarContaPoupanca(Scanner sc, List<ContaPoupanca> contasPoupanca) {
        System.out.print("Digite o número da conta poupança: ");
        int num = sc.nextInt();
        for (ContaPoupanca cp : contasPoupanca) {
            if (cp.getNumero() == num) {
                return cp;
            }
        }
        System.out.println("Conta poupança não encontrada.");
        return null;
    }

    private static void mostrarSaldo(Scanner sc, List<ContaCorrente> contasCorrente, List<ContaPoupanca> contasPoupanca) {
        System.out.println("Mostrar saldo de qual conta? (1 - Conta Corrente, 2 - Conta Poupança)");
        int tipo = sc.nextInt();
        if (tipo == 1) {
            ContaCorrente cc = buscarContaCorrente(sc, contasCorrente);
            if (cc != null)
                System.out.printf("Saldo: R$ %.2f\n", cc.getSaldo());
        } else if (tipo == 2) {
            ContaPoupanca cp = buscarContaPoupanca(sc, contasPoupanca);
            if (cp != null)
                System.out.printf("Saldo: R$ %.2f\n", cp.getSaldo());
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void realizarDeposito(Scanner sc, List<ContaCorrente> contasCorrente, List<ContaPoupanca> contasPoupanca) {
        System.out.println("Depositar em qual conta? (1 - Conta Corrente, 2 - Conta Poupança)");
        int tipo = sc.nextInt();
        if (tipo == 1) {
            ContaCorrente cc = buscarContaCorrente(sc, contasCorrente);
            if (cc != null) {
                System.out.print("Digite o valor do depósito: R$ ");
                double valor = sc.nextDouble();
                cc.depositar(valor);
            }
        } else if (tipo == 2) {
            ContaPoupanca cp = buscarContaPoupanca(sc, contasPoupanca);
            if (cp != null) {
                System.out.print("Digite o valor do depósito: R$ ");
                double valor = sc.nextDouble();
                cp.depositar(valor);
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void realizarSaque(Scanner sc, List<ContaCorrente> contasCorrente, List<ContaPoupanca> contasPoupanca) {
        System.out.println("Sacar de qual conta? (1 - Conta Corrente, 2 - Conta Poupança)");
        int tipo = sc.nextInt();
        if (tipo == 1) {
            ContaCorrente cc = buscarContaCorrente(sc, contasCorrente);
            if (cc != null) {
                System.out.print("Digite o valor do saque: R$ ");
                double valor = sc.nextDouble();
                cc.sacar(valor);
            }
        } else if (tipo == 2) {
            ContaPoupanca cp = buscarContaPoupanca(sc, contasPoupanca);
            if (cp != null) {
                System.out.print("Digite o valor do saque: R$ ");
                double valor = sc.nextDouble();
                cp.sacar(valor);
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void mostrarExtrato(Scanner sc, List<ContaCorrente> contasCorrente, List<ContaPoupanca> contasPoupanca) {
        System.out.println("Mostrar extrato de qual conta? (1 - Conta Corrente, 2 - Conta Poupança)");
        int tipo = sc.nextInt();
        if (tipo == 1) {
            ContaCorrente cc = buscarContaCorrente(sc, contasCorrente);
            if (cc != null) {
                System.out.println("\n--- Extrato Conta Corrente ---");
                cc.imprimirExtrato();
            }
        } else if (tipo == 2) {
            ContaPoupanca cp = buscarContaPoupanca(sc, contasPoupanca);
            if (cp != null) {
                System.out.println("\n--- Extrato Conta Poupança ---");
                cp.imprimirExtrato();
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void realizarTransferencia(Scanner sc, List<ContaCorrente> contasCorrente, List<ContaPoupanca> contasPoupanca) {
        System.out.println("Transferir de qual conta? (1 - Conta Corrente, 2 - Conta Poupança)");
        int tipoOrigem = sc.nextInt();
        Conta origem = null;
        if (tipoOrigem == 1) {
            origem = buscarContaCorrente(sc, contasCorrente);
        } else if (tipoOrigem == 2) {
            origem = buscarContaPoupanca(sc, contasPoupanca);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.println("Transferir para qual conta? (1 - Conta Corrente, 2 - Conta Poupança)");
        int tipoDestino = sc.nextInt();
        Conta destino = null;
        if (tipoDestino == 1) {
            destino = buscarContaCorrente(sc, contasCorrente);
        } else if (tipoDestino == 2) {
            destino = buscarContaPoupanca(sc, contasPoupanca);
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        if (origem == null || destino == null) {
            System.out.println("Conta(s) inválida(s) para transferência.");
            return;
        }

        System.out.print("Digite o valor da transferência: R$ ");
        double valor = sc.nextDouble();

        origem.transferir(valor, destino);
    }

    private static void realizarPagamento(Scanner sc, List<ContaCorrente> contasCorrente, List<ContaPoupanca> contasPoupanca) {
        System.out.println("Pagamento em qual conta? (1 - Conta Corrente, 2 - Conta Poupança)");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            ContaCorrente cc = buscarContaCorrente(sc, contasCorrente);
            if (cc != null) {
                System.out.print("Digite o valor do pagamento: R$ ");
                double valor = sc.nextDouble();
                cc.pagarConta(valor);
            }
        } else if (tipo == 2) {
            ContaPoupanca cp = buscarContaPoupanca(sc, contasPoupanca);
            if (cp != null) {
                System.out.print("Digite o valor do pagamento: R$ ");
                double valor = sc.nextDouble();
                cp.pagarConta(valor);
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
}

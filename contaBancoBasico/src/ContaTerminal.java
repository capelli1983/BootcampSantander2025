/*
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura da agência
        System.out.println("Digite o número da Agência (5 dígitos):");
        String agencia = scanner.nextLine().trim();
        // Formata agência: "00000" -> "0000-0"
        if (agencia.length() == 5) {
            agencia = agencia.substring(0, 4) + "-" + agencia.substring(4);
        }

        // Leitura da conta
        System.out.println("Digite o número da Conta (6 dígitos):");
        String conta = scanner.nextLine().trim();
        // Formata conta: "000000" -> "00.000-0"
        if (conta.length() == 6) {
            conta = conta.substring(0, 2)
                  + "."
                  + conta.substring(2, 5)
                  + "-"
                  + conta.substring(5);
        }

        // Leitura e formatação do nome
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        String[] pequenas = { "da", "de", "do", "dos", "das", "e" };
        Set<String> particulas = new HashSet<>();
        for (String p : pequenas) particulas.add(p);

        String[] partes = nomeCliente.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < partes.length; i++) {
            String parte = partes[i].toLowerCase();
            if (particulas.contains(parte)) {
                sb.append(parte);
            } else {
                sb.append(parte.substring(0,1).toUpperCase())
                  .append(parte.substring(1));
            }
            if (i < partes.length - 1) sb.append(" ");
        }
        String nomeFormatado = sb.toString();

        // Leitura e conversão do saldo
        System.out.println("Digite o saldo inicial (ex: 1.250,45 ou 1250,45):");
        String entrada = scanner.nextLine().replace(",", ".");
        BigDecimal saldo = new BigDecimal(entrada)
                                .setScale(2, RoundingMode.HALF_UP);

        // Exibição final (substitui ponto por vírgula no saldo)
        String saldoFormatado = saldo.toPlainString().replace('.', ',');
        System.out.printf(
            "\nOlá %s, obrigado por criar uma conta em nosso banco,\n" +
            "sua agência é %s, conta %s e seu saldo R$ %s já está disponível para saque.\n",
            nomeFormatado,
            agencia,
            conta,
            saldoFormatado
        );

        scanner.close();
    }
}*/

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número da Agência:");
        String agencia = scanner.nextLine();

        System.out.println("Digite o número da Conta:");
        int numero = scanner.nextInt();
        scanner.nextLine(); // limpar quebra de linha

        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite o saldo inicial:");
        float saldo = scanner.nextFloat();

        // Formata a saída para 2 casas decimais
        System.out.printf(
            "\nOlá %s, obrigado por criar uma conta em nosso banco. Sua agência é %s, conta %d e seu saldo R$ %.2f já está disponível para saque.\n",
            nomeCliente, agencia, numero, saldo
        );

        scanner.close();
    }
}


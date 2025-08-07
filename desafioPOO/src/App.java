import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Iphone iphone = new Iphone();

        boolean executando = true;

        while (executando) {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Reprodutor Musical");
            System.out.println("2 - Aparelho Telefônico");
            System.out.println("3 - Navegador de Internet");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> menuMusical(scanner, iphone);
                case 2 -> menuTelefone(scanner, iphone);
                case 3 -> menuNavegador(scanner, iphone);
                case 0 -> {
                    executando = false;
                    System.out.println("Encerrando...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    public static void menuMusical(Scanner scanner, Iphone iphone) {
        int opcao;
        do {
            System.out.println("\n-- Reprodutor Musical --");
            System.out.println("1 - Tocar");
            System.out.println("2 - Pausar");
            System.out.println("3 - Selecionar Música");
            System.out.println("0 - Voltar");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> iphone.tocar();
                case 2 -> iphone.pausar();
                case 3 -> iphone.selecionarMusica();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public static void menuTelefone(Scanner scanner, Iphone iphone) {
        int opcao;
        do {
            System.out.println("\n-- Aparelho Telefônico --");
            System.out.println("1 - Ligar");
            System.out.println("2 - Atender");
            System.out.println("3 - Correio de Voz");
            System.out.println("0 - Voltar");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> iphone.ligar();
                case 2 -> iphone.atender();
                case 3 -> iphone.iniciarCorreioVoz();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public static void menuNavegador(Scanner scanner, Iphone iphone) {
        int opcao;
        do {
            System.out.println("\n-- Navegador de Internet --");
            System.out.println("1 - Exibir Página");
            System.out.println("2 - Nova Aba");
            System.out.println("3 - Atualizar Página");
            System.out.println("0 - Voltar");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> iphone.exibirPagina();
                case 2 -> iphone.adicionarNovaAba();
                case 3 -> iphone.atualizarPagina();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}



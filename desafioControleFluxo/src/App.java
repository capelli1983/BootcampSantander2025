import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int parametro1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int parametro2 = scanner.nextInt();

        try {
            Contador.contar(parametro1, parametro2);
        } catch (ParametrosInvalidosException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        scanner.close();
    }
}


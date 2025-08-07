public class Contador {
    public static void contar(int parametro1, int parametro2) throws ParametrosInvalidosException {
        if (parametro1 >= parametro2) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        int quantidade = parametro2 - parametro1;

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("Imprimindo número " + i);
        }

        System.out.println("Total de parâmetros: " + quantidade);
    }
}



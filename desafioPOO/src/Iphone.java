public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet {

    // Métodos do reprodutor musical
    public void tocar() {
        System.out.println("Reproduzindo música...");
    }

    public void pausar() {
        System.out.println("Música pausada.");
    }

    public void selecionarMusica() {
        System.out.println("Selecionando música...");
    }

    // Métodos do aparelho telefônico
    public void ligar() {
        System.out.println("Realizando chamada...");
    }

    public void atender() {
        System.out.println("Atendendo chamada...");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz...");
    }

    // Métodos do navegador
    public void exibirPagina() {
        System.out.println("Exibindo página da web...");
    }

    public void adicionarNovaAba() {
        System.out.println("Abrindo nova aba...");
    }

    public void atualizarPagina() {
        System.out.println("Atualizando página...");
    }
}


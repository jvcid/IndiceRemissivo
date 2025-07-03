public class Main {
    public static void main(String[] args) {

        String[] palavrasChave = LerArquivo.lerPalavrasChaveDeArquivo("Palavras.txt");

            LerArquivo leitor = new LerArquivo(palavrasChave);

            leitor.lerArquivo("Paragrafo.txt");

            leitor.exportar("resultado.txt");
    }
}

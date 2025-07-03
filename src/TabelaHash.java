public class TabelaHash {
    private static final int tamanho = 26;
    private BuscaArvore[] catalogo;

    public TabelaHash() {
        catalogo = new BuscaArvore[tamanho];
        for (int i = 0; i < tamanho; i++) {
            catalogo[i] = new BuscaArvore();
        }
    }


    private int calcularIndice(String palavra) {
        return Character.toLowerCase(palavra.charAt(0)) - 'a';
    }

    public void inserir(Palavras palavra) {
        int indice = calcularIndice(palavra.palavra);
        if (indice >= 0 && indice < tamanho) {
            catalogo[indice].insere(palavra);
        }
    }

    public Palavras buscar(String palavra) {
        int indice = calcularIndice(palavra);
        if (indice >= 0 && indice < tamanho) {
            return catalogo[indice].busca(palavra);
        }
        return null;
    }

    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            if (!catalogo[i].estaVazia()) {
                catalogo[i].imprimeNaOrdem();
            }
        }
    }

    public BuscaArvore getArvore(int indice) {
        return catalogo[indice];
    }
}
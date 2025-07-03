public class BuscaArvore {

    class Nodo {
        public Palavras elemento;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(Palavras elemento) {
            this.elemento = elemento;
            this.esquerdo = null;
            this.direito = null;
        }
    }

        private Nodo raiz;
        private int nElementos;

    public BuscaArvore() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public void insere(Palavras nova) {
        this.raiz = insere(nova, this.raiz);
    }

    private Nodo insere(Palavras nova, Nodo nodo) {
        if (nodo == null) {
            nElementos++;
            return new Nodo(nova);
        }

        int comparacao = nova.palavra.compareTo(nodo.elemento.palavra);

        if (comparacao < 0) {
            nodo.esquerdo = insere(nova, nodo.esquerdo);
        } else if (comparacao > 0) {
            nodo.direito = insere(nova, nodo.direito);
        }

        return nodo;
    }

    public Palavras busca(String chave) {
        return busca(chave, this.raiz);
    }

    private Palavras busca(String chave, Nodo nodo) {
        if (nodo == null) return null;

        int comparacao = chave.compareTo(nodo.elemento.palavra);

        if (comparacao < 0) {
            return busca(chave, nodo.esquerdo);
        } else if (comparacao > 0) {
            return busca(chave, nodo.direito);
        } else {
            return nodo.elemento;
        }
    }

    public void imprimeNaOrdem() {
        emOrdem(this.raiz);
    }

    private void emOrdem(Nodo nodo) {
        if (nodo == null) return;

        emOrdem(nodo.esquerdo);
            System.out.print(nodo.elemento.palavra + ": ");
        nodo.elemento.imprimirOcorrencias();
            System.out.println();
        emOrdem(nodo.direito);
    }

    public Nodo getRaiz() {
        return this.raiz;
    }
}

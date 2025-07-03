import java.io.BufferedWriter;
import java.io.IOException;



public class Palavras {

    public String palavra;
    public ListaEncadeada<Integer> ocorrencias;


    //Lista encadeada que vai armazena os numeros das linhas que a palavra aparece.
    public Palavras(String palavra) {
        this.palavra = palavra;
        this.ocorrencias = new ListaEncadeada<>();
    }

 //construtor
    public void exportarOcorrencias(BufferedWriter writer) throws IOException {
        ListaEncadeada<Integer>.No atual = ocorrencias.getPrimeiro();
            while (atual != null) {
            writer.write(atual.dado + " ");
            atual = atual.proximo;
        }
    }

    //Exporta as ocorrências da palavra para um arquivo escrevendo todos os números de linha armazenados na lista.
    public void adicionarOcorrencia(int linha) {
        if (!ocorrencias.contem(linha)) {
            ocorrencias.inserir(linha);
        }
    }

    public void imprimirOcorrencias() {
        ocorrencias.imprimir();
    }

}
import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;


public class LerArquivo {

    // le arquivos e monta o indice remissivo usando TabelaHash
    private TabelaHash tabelaHash;
    private String[] palavrasChave;


    //armazena a estrutura de índice e as palavras-chave.
    public LerArquivo(String[] palavrasChave) {
        this.tabelaHash = new TabelaHash();
        this.palavrasChave = new String[palavrasChave.length];

        //construtor
        for (int i = 0; i < palavrasChave.length; i++) {
                String normalizada = Normalizer.normalize(palavrasChave[i], Normalizer.Form.NFD);
                normalizada = normalizada.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                this.palavrasChave[i] = normalizada.toLowerCase();
        }
    }

    public static String[] lerPalavrasChaveDeArquivo(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
                String linha;
                List<String> lista = new ArrayList<>();

            while ((linha = br.readLine()) != null) {
                linha = Normalizer.normalize(linha, Normalizer.Form.NFD);linha =
                linha.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                lista.add(linha.toLowerCase());
            }

            return lista.toArray(new String[0]);

        } catch (IOException e) {
            System.err.println("Erro ao ler palavras-chave: " + e.getMessage());
            return new String[0];
        }
    }

    public void lerArquivo(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinha = 1;

            while ((linha = br.readLine()) != null) {
                String linhaNormalizada = Normalizer.normalize(linha, Normalizer.Form.NFD);
                linhaNormalizada = linhaNormalizada.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
                linhaNormalizada = linhaNormalizada.toLowerCase().replaceAll("[^a-z\\- ]", "");

                String[] palavras = linhaNormalizada.split("\\s+");

                for (String palavra : palavras) {
                    for (String chave : palavrasChave) {
                        if (palavra.equals(chave)) {
                            Palavras existente = tabelaHash.buscar(chave);
                            if (existente == null) {
                                Palavras nova = new Palavras(chave);
                                nova.adicionarOcorrencia(numeroLinha);
                                tabelaHash.inserir(nova);
                            } else {
                                existente.adicionarOcorrencia(numeroLinha);
                            }
                        }
                    }
                }

                numeroLinha++;
            }

            System.out.println("Leitura do arquivo concluída (>w<)");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void imprimir() {
        tabelaHash.imprimir();
    }

    public void exportar(String caminhoSaida) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoSaida))) {
            for (int i = 0; i < 26; i++) {
                BuscaArvore arvore = tabelaHash.getArvore(i);
                exportaEmOrdem(arvore.getRaiz(), writer);
            }
            System.out.println("Exportado para " + caminhoSaida);
        } catch (IOException e) {
            System.err.println("Erro ao exportar: " + e.getMessage());
        }
    }

    private void exportaEmOrdem(BuscaArvore.Nodo nodo, BufferedWriter writer) throws IOException {
        if (nodo == null) return;

        exportaEmOrdem(nodo.esquerdo, writer);
        writer.write(nodo.elemento.palavra + ": ");
        nodo.elemento.exportarOcorrencias(writer);
        writer.newLine();
        exportaEmOrdem(nodo.direito, writer);
    }
}
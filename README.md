# Índice Remissivo

Projeto em Java desenvolvido para gerar um índice remissivo a partir de um arquivo de texto. Ele identifica as palavras contidas no texto e registra as linhas em que cada uma aparece, organizando os dados em uma estrutura de tabela hash com listas encadeadas.

---

I. Objetivo

Este programa tem como finalidade:
- Ler arquivos `.txt` e extrair palavras.
- Registrar em quais linhas cada palavra ocorre.
- Armazenar os dados usando tabela hash com tratamento de colisão por listas encadeadas.
- Gerar como saída um arquivo `resultado.txt` com o índice remissivo.

---

II. Estrutura do Projeto

```
IndiceRemissivo/
├── src/
│   ├── BuscaArvore.java          ← (não utilizado no momento)
│   ├── LerArquivo.java           ← Responsável pela leitura e pré-processamento do texto
│   ├── ListaEncadeada.java       ← Estrutura de dados auxiliar para tratamento de colisão
│   ├── Main.java                 ← Classe principal (ponto de entrada)
│   ├── Palavras.java             ← Representa uma palavra e suas linhas de ocorrência
│   └── TabelaHash.java           ← Implementação da tabela hash
├── resultado.txt                 ← Arquivo de saída com o índice gerado
├── resultado/                    ← Pasta opcional para outros resultados
├── .gitignore
└── Estrutura De dados.iml
```

---

III. Como Executar

III.i Pré-requisitos

- Java JDK 8 ou superior
- IDE como IntelliJ IDEA, Eclipse ou terminal com `javac`

III.I Compilação

No terminal (Linux/Mac/Windows PowerShell):

```bash
cd src
javac *.java
```

III.II Execução

```bash
java Main
```

> O arquivo `resultado.txt` será gerado no diretório raiz do projeto com o índice remissivo.

---

IV. Exemplo de Saída

Suponha um arquivo com o seguinte conteúdo:

```
A estrutura de dados é essencial.
A árvore binária é uma estrutura hierárquica.
```

Saída esperada no `resultado.txt`:

```
a – linhas: 1, 2  
árvore – linhas: 2  
binária – linhas: 2  
dados – linhas: 1  
estrutura – linhas: 1, 2  
essencial – linhas: 1  
hierárquica – linhas: 2  
uma – linhas: 2  
```

---

V. Autores

- João Victor Martins Cid  
[LinkedIn](https://www.linkedin.com/in/jvcid/)



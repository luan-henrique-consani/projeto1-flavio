public class MergeSort {

    public record Resultados(long[] vetor, long comparacoes, long trocas, double tempoExecucaoMs) {}

    private static long comparacoes;
    private static long trocas;

    public static Resultados ordenar(long[] vetor) {
        comparacoes = 0;
        trocas = 0;

        long[] copia = vetor.clone();

        long inicio = System.nanoTime();

        mergeSort(copia, 0, copia.length - 1);

        long fim = System.nanoTime();
        double tempoExecucaoMs = (fim - inicio) / 1_000_000.0;

        return new Resultados(copia, comparacoes, trocas, tempoExecucaoMs);
    }

    private static void mergeSort(long[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);

            merge(vetor, esquerda, meio, direita);
        }
    }

    private static void merge(long[] vetor, int esquerda, int meio, int direita) {
        int tamanhoEsq = meio - esquerda + 1;
        int tamanhoDir = direita - meio;

        long[] subEsq = new long[tamanhoEsq];
        long[] subDir = new long[tamanhoDir];

        for (int i = 0; i < tamanhoEsq; i++) subEsq[i] = vetor[esquerda + i];
        for (int j = 0; j < tamanhoDir; j++) subDir[j] = vetor[meio + 1 + j];

        int i = 0, j = 0, k = esquerda;

        while (i < tamanhoEsq && j < tamanhoDir) {
            comparacoes++;
            if (subEsq[i] <= subDir[j]) {
                vetor[k] = subEsq[i];
                i++;
            } else {
                vetor[k] = subDir[j];
                j++;
                trocas++; // elemento da direita passou à frente — equivalente a uma "troca"
            }
            k++;
        }

        while (i < tamanhoEsq) { vetor[k++] = subEsq[i++]; }
        while (j < tamanhoDir) { vetor[k++] = subDir[j++]; }
    }
}
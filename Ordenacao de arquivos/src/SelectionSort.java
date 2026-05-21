public class SelectionSort {

    public record Resultados(long[] vetor, long comparacoes, long trocas, double tempoExecucaoMs) {}

    public static Resultados ordenar(long[] vetor) {
        long tamVetor = vetor.length;
        long comparacoes = 0;
        long trocas = 0;

        long inicio = System.nanoTime();
        long[] copia = vetor.clone();

        for (int i = 0; i < tamVetor - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < tamVetor; j++) {
                comparacoes++;
                if (copia[j] < copia[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                long temp = copia[i];
                copia[i] = copia[indiceMenor];
                copia[indiceMenor] = temp;
                trocas++;
            }
        }

        long fim = System.nanoTime();
        double tempoExecucaoMs = (fim - inicio) / 1_000_000.0;

        return new Resultados(copia, comparacoes, trocas, tempoExecucaoMs);
    }
}
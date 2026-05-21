

public class BubbleSort {

    public record Resultados(long[] vetor, long comparacoes, long trocas, double tempoExecucaoMs) {}

    public static Resultados ordenar(long[] vetor) {
        long tamVetor = vetor.length;
        long comparacoes = 0;
        long trocas = 0;

        long[] copia = vetor.clone();

        long inicio = System.nanoTime();

        for (int i = 0; i < tamVetor - 1; i++) {
            for (int j = 0; j < tamVetor - i - 1; j++) {
                comparacoes++;
                if (copia[j] > copia[j + 1]) {
                    long temp = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = temp;
                    trocas++;
                }
            }
        }

        long fim = System.nanoTime();
        double tempoExecucaoMs = (fim - inicio) / 1_000_000.0;

        return new Resultados(copia, comparacoes, trocas, tempoExecucaoMs);
    }
}
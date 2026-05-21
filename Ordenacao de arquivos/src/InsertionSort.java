

public class InsertionSort {

    public record Resultados(long [] vetor, long comparacoes, long trocas, double tempoExecucaoMs){ }

    public static Resultados ordenar(long [] vetor){
        long tamVetor = vetor.length;
        long comparacoes = 0;
        long trocas = 0;

        long inicio = System.nanoTime();
        long[] copia = vetor.clone();

        for(int i = 1; i < tamVetor; i++){
            long chave = copia[i];
            int j = i- 1;
            while(j >= 0 && copia[j] > chave){
                copia[j+1] = copia[j];
                trocas++;
                j--;
                comparacoes++;
            }
            if(j >= 0){
                comparacoes++;
            }
            copia[j+1] = chave;
        }

        long fim = System.nanoTime();
        double tempoExecucaoMs = (fim - inicio) / 1_000_000.0;


        return new Resultados(copia, comparacoes, trocas, tempoExecucaoMs);
    }
}

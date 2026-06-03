public class App {
    public static void main(String[] args) {

        String[] arquivos = {
            "10000_desordenado",
            "10000_inverso",
            "10000_ordenado",
            "100000_desordenado",
            "100000_inverso",
            "100000_ordenado",
            "500000_desordenado",
            "500000_inverso",
            "500000_ordenado",
            "1000000_desordenado",
            "1000000_inverso",
            "1000000_ordenado"
        };

        for (String arquivo : arquivos) {
            long[] vetor = LeitorVetor.lerVetor("./arquivos/" + arquivo + ".txt");

            MergeSort.Resultados resultadoMs = MergeSort.ordenar(vetor);

            System.out.println("------------------------------------");
            System.out.println(arquivo);
            System.out.println("Merge Sort:");
            System.out.println("Comparações: " + resultadoMs.comparacoes());
            System.out.println("Trocas: "      + resultadoMs.trocas());
            System.out.println("Tempo: "       + resultadoMs.tempoExecucaoMs() + " ms");
            System.out.println("------------------------------------");
            System.out.println();
        }
    }
}
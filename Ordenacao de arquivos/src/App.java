public class App {
    public static void main(String[] args) {
        long[] vetor = LeitorVetor.lerVetor("./arquivos/1000000_ordenado.txt");

        System.out.println("Insertion Sort");
        InsertionSort.Resultados resultadoIs = InsertionSort.ordenar(vetor);
        System.out.println("Comparações: " + resultadoIs.comparacoes());
        System.out.println("Trocas: " + resultadoIs.trocas());
        System.out.println("Tempo: " + resultadoIs.tempoExecucaoMs() + " ms");
        System.out.println("");

        System.out.println("Bubble Sort");
        BubbleSort.Resultados resultadoBs = BubbleSort.ordenar(vetor);
        System.out.println("Comparações: " + resultadoBs.comparacoes());
        System.out.println("Trocas: " + resultadoBs.trocas());
        System.out.println("Tempo: " + resultadoBs.tempoExecucaoMs() + " ms");
        System.out.println("");

        System.out.println("Selection Sort");
        SelectionSort.Resultados resultadoSs = SelectionSort.ordenar(vetor);
        System.out.println("Comparações: " + resultadoSs.comparacoes());
        System.out.println("Trocas: " + resultadoSs.trocas());
        System.out.println("Tempo: " + resultadoSs.tempoExecucaoMs() + " ms");
        System.out.println("");

    }
}
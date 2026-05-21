import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorVetor {

    public static long[] lerVetor(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = br.readLine().trim();
            String[] partes = linha.split(",");

            long[] vetor = new long[partes.length];
            for (int i = 0; i < partes.length; i++) {
                vetor[i] = Integer.parseInt(partes[i].trim());
            }

            return vetor;

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return new long[0];
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter número: " + e.getMessage());
            return new long[0];
        }
    }
}
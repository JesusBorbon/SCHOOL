package TonaCastro.Decrypt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException { // read the text from the file, filter it and print the clean text
        String originalText = extractText();

        Decryptor decryptor = new Decryptor(originalText);
        decryptor.filterText();

        System.out.println("Texto desencriptado: " + decryptor.getCleanText());
    }

    public static String extractText() throws IOException {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader("mensaje.txt"))) { // read the text from the file and store it in a string
            String line;
            while ((line = br.readLine()) != null) {
                text += line;
            }
        }
        return text;
    }
}

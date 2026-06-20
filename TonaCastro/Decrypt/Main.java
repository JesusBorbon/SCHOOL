package TonaCastro.Decrypt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static String OriginalText;
    static char[] TextArray;
    static Stack stack;

    public static void main(String[] args) throws IOException { // read the text from the file, filter it and print the clean text
        OriginalText = extractText();

        int size = SizeText(OriginalText);

        stack = new Stack(size);

        FilterText();

        System.out.println("Texto desencriptado: " + SetupText());
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

    public static int SizeText(String text) {
        TextArray = text.toCharArray();
        return TextArray.length;
    }

    public static void FilterText() { // filter using stack to reverse the text between parentheses and remove the parentheses from the original text
        for (int i = 0; i < TextArray.length; i++) {
            if (TextArray[i] == '(') {
                TextArray[i] = 0;
                int inicio = i + 1;
                i++;
                while (i < TextArray.length && TextArray[i] != ')') { // push the characters between parentheses to the stack
                    stack.push(TextArray[i]);
                    i++;
                }
                if (i < TextArray.length && TextArray[i] == ')') { // pop the characters from the stack and replace the original text with the reversed text
                    TextArray[i] = 0;
                    for (int j = inicio; j < i; j++) {
                        TextArray[j] = (char) stack.pop();
                    }
                }
            }
        }
    }
 
    public static String SetupText() { // remove the null characters from the original text and return the clean text
        String textClean = "";
        for (char c : TextArray) {
            if (c != 0) {
                textClean += c;
            }
        }
        return textClean;
    }
}
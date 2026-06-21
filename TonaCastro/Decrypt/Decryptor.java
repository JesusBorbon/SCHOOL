package TonaCastro.Decrypt;

public class Decryptor {

    private char[] textArray;
    private Stack stack;

    public Decryptor(String text) {
        this.textArray = text.toCharArray(); // 
        this.stack = new Stack(textArray.length);
    }

    public void filterText() { // filter using stack to reverse the text between parentheses and remove the parentheses from the original text
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i] == '(') {  // if the current char is an opening parenthesis, push the characters between parentheses to the stack and replace the original text with the reversed text
                textArray[i] = 0;
                int inicio = i + 1;
                i++;
                while (i < textArray.length && textArray[i] != ')') { // push the characters between parentheses to the stack
                    stack.push(textArray[i]);
                    i++;
                }
                if (i < textArray.length && textArray[i] == ')') { // pop the characters from the stack and replace the original text with the reversed text
                    textArray[i] = 0;
                    for (int j = inicio; j < i; j++) {
                        textArray[j] = (char) stack.pop();
                    }
                }
            }
        }
    }

    public String getCleanText() { // remove the null characters from the original text and return the clean text
        String textClean = "";
        for (char c : textArray) {
            if (c != 0) {
                textClean += c;
            }
        }
        return textClean;
    }
}

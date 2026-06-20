package TonaCastro.Decrypt;
import java.util.Arrays;

public class Stack {

    private char[] pila;
    private int tope;
    private int capacidad;

    public Stack(int tamano) {
        this.pila = new char[tamano];
        capacidad = tamano;
        tope = -1;

    }

    public void push(char elemento) {
        if (isFull() == true) {
            System.exit(1);
        }
        pila[++tope] = elemento;
    }

    public int pop() {
        if (pila == null) {
            System.out.println("La pila esta vacia.");
            System.exit(1);
        }
        return pila[tope--];
    }

    public boolean isEmpty() {

        return tope == -1;
    }

    public boolean isFull() {
        return tope == capacidad + 1;
    }

    public int tamano() {
        return tope + 1;
    }

    public int peek() {
        return pila[tope];
    }

    public String mostrarPilas() {
        return Arrays.toString(pila);
    }

}
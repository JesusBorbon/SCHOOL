package TonaCastro.ListasYNodos;

public class Nodo {

    private int Value;
    private Nodo Next;

    public Nodo() {
        this.Value = 0;
        this.Next = null;
    }

    public int GetValue() {
        return this.Value;
    }

    public void SetValue(int value) {
        this.Value = value;
    }

    public Nodo GetNodo() {
        return this.Next;
    }

    public void SetNodo(Nodo newNodo) {
        this.Next = newNodo;
    }
} 
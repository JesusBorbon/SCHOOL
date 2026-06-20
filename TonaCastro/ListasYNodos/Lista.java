package TonaCastro.ListasYNodos;
public class Lista {

    private Nodo Start;
    private int Size;

    public Lista() {
        this.Start = null;
        this.Size = 0;
    }

    public int getSize() {
        return this.Size;
    }

    public boolean isEmpty() {
        return this.Start == null;
    }

    public Nodo addAtEnd(int value) {
        Nodo newNodo = new Nodo();
        newNodo.SetValue(value);

        if (isEmpty()) {
            Start = newNodo;
        } else {
            Nodo aux = Start;
            while (aux.GetNodo() != null) {
                aux = aux.GetNodo();
            }
            aux.SetNodo(newNodo);
        }
        Size++;
        return newNodo;
    }

    public void AddAtStart(int value) {
        Nodo newNodo = new Nodo();
        newNodo.SetValue(value);

        if (isEmpty()) {
            this.Start = newNodo;
        } else {
            newNodo.SetNodo(Start);
            Start = newNodo;
        }
        Size++;
    }

    public void InsertToReference(int reference, int value) {
        Nodo newNodo = new Nodo();
        newNodo.SetValue(value);
        if (!isEmpty()) {
            if (search(reference)) {
                Nodo aux = this.Start;
                while (aux.GetValue() != reference) {
                    aux = aux.GetNodo();
                }
                Nodo next = aux.GetNodo();
                aux.SetNodo(newNodo);
                newNodo.SetNodo(next);
            }
        }
    }

    public void insertForPosition(int position, int value) {
        if (position >= 0 && position <= Size) {
            Nodo newNode = new Nodo();
            newNode.SetValue(value);
            if (position == 0) {
                newNode.SetNodo(Start);
                Start = newNode;
            } else {
                if (position == Size) {
                    Nodo aux = Start;
                    while (aux.GetNodo() != null) {
                        aux = aux.GetNodo();
                    }
                    aux.SetNodo(newNode);

                } else {
                    Nodo aux = Start;
                    for (int i = 0; i < position - 1; i++) {
                        aux = aux.GetNodo();

                    }
                    Nodo nextNodo = aux.GetNodo();
                    aux.SetNodo(newNode);
                    newNode.SetNodo(nextNodo);
                }
            }
            Size++;
        }

    }

    public int getValueForPosition(int position) throws Exception {
        if (position >= 0 && position < Size) {
            if (position == 0) {
                return Start.GetValue();
            } else {
                Nodo aux = Start;
                for (int i = 0; i < position; i++) {
                    aux = aux.GetNodo();
                }
                return aux.GetValue();
            }
        } else {
            throw new Exception("La posicion no existe");
        }
    }

    public boolean search(int reference) {
        Nodo aux = Start;
        boolean isFounded = false;
        while (aux != null && isFounded != true) {
            if (reference == aux.GetValue()) {
                isFounded = true;
            } else {
                aux = aux.GetNodo();
            }
        }
        return isFounded;
    }

    public int getPosition(int reference) throws Exception {
        if (search(reference)) {
            Nodo aux = Start;
            int count = 0;
            while (reference != aux.GetValue()) {
                count++;
                aux = aux.GetNodo();
            }
            return count;
        } else {
            throw new Exception("La position no existe.");
        }
    }

    public void editarPorReferencia(int reference, int value) throws Exception {
        if (search(reference)) {
            Nodo aux = Start;
            while (aux.GetValue() != reference) {
                aux = aux.GetNodo();
            }
            aux.SetValue(value);
        }
    }

    public void editToPosition(int position, int value) throws Exception {
        if (position >= 0 && position < Size) {
            if (position == 0) {
                Start.SetValue(value);
            } else {
                Nodo aux = Start;
                for (int i = 0; i < position; i++) {
                    aux = aux.GetNodo();
                }
                aux.SetValue(value);
            }
        }
    }

    public void removeToReference(int reference) {
        if (search(reference)) {

            if (Start.GetValue() == reference) {
                Start = Start.GetNodo();
            } else {
                Nodo aux = Start;
                while (aux.GetNodo().GetValue() != reference) {
                    aux = aux.GetNodo();
                }
                Nodo Next = aux.GetNodo().GetNodo();
                aux.SetNodo(Next);
            }
            Size--;
        }
    }

    public void DeleteList() {
        Start = null;
        Size = 0;
    }

    public void removeToPosition(int position) {
        if (position >= 0 && position < Size) {
            if (position == 0) {
                Start = Start.GetNodo();
            } else {
                Nodo aux = Start;
                for (int i = 0; i < position - 1; i++) {
                    aux = aux.GetNodo();
                }
                Nodo Next = aux.GetNodo();
                aux.SetNodo(Next.GetNodo());
            }
            Size--;
        }
    }

    public void PrintList() {
        if (!isEmpty()) {
            Nodo aux = Start;
            int i = 0;
            while (aux != null) {
                System.out.println(i + ".[" + aux.GetValue() + " ]" + " -> ");
                aux = aux.GetNodo();
                i++;
            }
        }
    }
}
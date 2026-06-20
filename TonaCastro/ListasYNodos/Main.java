package TonaCastro.ListasYNodos;

public class Main {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Lista lista = new Lista();

        System.out.println("<<-- Ejemplo de lista simple -->>\n");

        // Agregar al final de la lista
        lista.addAtEnd(12);
        lista.addAtEnd(15);
        lista.addAtEnd(9);
        // Agregar in inicio de la lista
        lista.AddAtStart(41);
        lista.AddAtStart(6);

        System.out.println("<<-- Lista -->>");
        lista.PrintList();

        System.out.println("\n\n<<-- Tamaño -->");
        System.out.println(lista.getSize());

        System.out.println("\n<<-- Obtener el valor del nodo en la posicion 3 -->>");
        System.out.println(lista.getValueForPosition(3));

        System.out.println("\nInserta un nodo con valor 16 despues del 15");
        lista.InsertToReference(15, 16);
        lista.PrintList();
        System.out.print(" | Tamaño: ");
        System.out.println(lista.getSize());

        System.out.println("\n\nInserta un nodo con valor 44 en la posición 3");
        lista.insertForPosition(3, 44);
        lista.PrintList();
        System.out.print(" | Tamaño: ");
        System.out.println(lista.getSize());

        System.out.println("\nActualiza el valor 12 del tercer nodo por 13");
        lista.editarPorReferencia(12, 13);
        lista.PrintList();
        System.out.print(" | Tamaño: ");
        System.out.println(lista.getSize());

        System.out.println("\nActualiza el valor nodo en la posición 0 por 17");
        lista.editToPosition(0, 17);
        lista.PrintList();
        System.out.print(" | Tamaño: ");
        System.out.println(lista.getSize());

        System.out.println("\nElimina el nodo con el valor 41");
        lista.removeToReference(41);
        lista.PrintList();
        System.out.print(" | Tamaño: ");
        System.out.println(lista.getSize());

        System.out.println("\nElimina el nodo en la posición 4");
        lista.removeToPosition(4);
        lista.PrintList();
        System.out.print(" | Tamaño: ");
        System.out.println(lista.getSize());

        System.out.println("\nConsulta si existe el valor 30");
        System.out.println(lista.search(30));

        System.out.println("\nConsulta la posicion del valor 9");
        System.out.println(lista.getPosition(9));

        System.out.println("\nElimina la lista");
        lista.DeleteList();

        System.out.println("\nConsulta si la lista está vacia");
        System.out.println(lista.isEmpty());

        System.out.println("\n\n<<-- Fin de ejemplo lista simple -->>");
    }
}
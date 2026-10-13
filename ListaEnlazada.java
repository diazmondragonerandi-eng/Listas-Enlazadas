public class ListaEnlazada {
    public static void main(String[] args){
ListaEnlazada lista = new ListaEnlazada();

System.out.println("¿la lista esta vacia?"+lista.estaVacia());

    
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        System.out.print("Tras insertar 10, 20, 30 al final: ");
        lista.imprimir();

        
        lista.insertarAlInicio(5);
        System.out.print("Tras insertar 5 al inicio: ");
        lista.imprimir();

        
        System.out.println("¿Contiene 20? " + lista.buscar(20));
        System.out.println("¿Contiene 99? " + lista.buscar(99));

       
        System.out.println("Tamaño: " + lista.contar());

        
        System.out.println("Elemento en índice 2: " + lista.obtener(2));

        
        lista.eliminar(10);
        System.out.print("Tras eliminar 10: ");
        lista.imprimir();

        lista.eliminar(5);
        System.out.print("Tras eliminar la cabeza (5): ");
        lista.imprimir();

        lista.eliminar(30);
        System.out.print("Tras eliminar el último (30): ");
        lista.imprimir();

        lista.eliminar(20);
        System.out.print("Tras eliminar todo: ");
        lista.imprimir();
    }

    private static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // ===== ATRIBUTO =====
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    public boolean buscar(int dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public boolean eliminar(int dato) {
        if (cabeza == null) return false;

        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;

        while (actual != null) {
            if (actual.dato == dato) {
                anterior.siguiente = actual.siguiente;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }

    public int contar() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    public int obtener(int indice) {
        if (indice < 0) throw new IndexOutOfBoundsException("Índice negativo");
        Nodo actual = cabeza;
        int posicion = 0;
        while (actual != null) {
            if (posicion == indice) return actual.dato;
            actual = actual.siguiente;
            posicion++;
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
    }

public void imprimir() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) System.out.print("-> ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
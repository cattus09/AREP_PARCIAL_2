package parcial.segundo;

import java.util.List;

public class Search {
    public static int lineal(List<Integer> lista, int n){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == n)return i;
        }
        return -1;
    }

    public static int binari(List<Integer> lista, int n) {
        int inicio = 0;
        int fin = lista.size() - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (lista.get(medio) == n)return medio;
            if (lista.get(medio) < n)inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }

}

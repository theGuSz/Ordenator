package ordena;

public class QuikS {
	public static int[] quicksort(int[] vet, int esq, int dir) {

        int meio;

        if (esq < dir) {

            meio = separa(vet, esq, dir);

            quicksort(vet, esq, meio);
            quicksort(vet, meio + 1, dir);
            
        }
        
        return vet;

    }
	
    public static int separa(int vet[], int esq, int dir) {

        int pivo = vet[esq];
        int top = esq;

        for (int j = esq + 1; j <= dir; j++) {

            if (vet[j] < pivo) {
            	
                vet[top] = vet[j];
                vet[j] = vet[top + 1];
                top =+ 1;

            }

        }

        vet[top] = pivo;

        return top;

    }
}

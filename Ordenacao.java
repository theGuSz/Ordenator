package ordena;

public class Ordenacao {
		
	//QuickSort inicio
	
		 static int separa(int vet[], int esq, int dir)
	    {
	        int pivot = vet[dir]; 
	        int i = (esq-1);
	        for (int j=esq; j<dir; j++)
	        {
	
	            if (vet[j] <= pivot)
	            {
	                i++;
	  
	                int temp = vet[i];
	                vet[i] = vet[j];
	                vet[j] = temp;
	            }
	        }
	  
	        int temp = vet[i+1];
	        vet[i+1] = vet[dir];
	        vet[dir] = temp;
	  
	        return i+1;
	    }
		  
	    	static int[] quicksort(int vet[], int esq, int dir)
	    	{
	    		if (esq < dir)
	    		{

	    			int pivo = separa(vet, esq, dir);

	    			quicksort(vet, esq, pivo-1);
	    			quicksort(vet, pivo+1, dir);
	    		}
	    		return vet;
	    	}	  
	    
	    //QuickSort fim
	    
	
	public static int[] bubbleSort(int[] vet) {
		
		int n = vet.length; 	
        int temp = 0;  
        
        for(int i=0; i < n; i++){  
        	
        	for(int j=1; j < (n-i); j++){  
        		
        		if(vet[j-1] > vet[j]){  
        			
        			temp = vet[j-1];  
        			vet[j-1] = vet[j];  
        			vet[j] = temp;  
        			
                        }                      
                }  	
        }
        return vet;
	}
	
	
	
	
	public static int[] insertsort(int vet[]) {

	       for(int i=1; i < (vet.length); i++) {
	   
	    	   int ajuda = vet[i];
	    	   int j = i - 1;
	    	   
	    	   while((j >= 0) && (vet[j] > ajuda)) {
	    		   
	    		   vet[j+1] = vet[j];
	    		   
	    		   j--;
	    	   }
	    	   
	    	   vet[j+1] = ajuda;
	    	   
	       }	       
	        return vet;
	    }
	
}



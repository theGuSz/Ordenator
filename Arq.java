package ordena;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Arq {
	public int[] lerArq(String endereco, int tamanho) throws FileNotFoundException, IOException {

        File arquivo = new File(endereco);
        int[] vet = new int[tamanho];
        String dados = null;
        
        FileReader lerarquivo = new FileReader(arquivo);
        
        BufferedReader bufferleitor = new BufferedReader(lerarquivo);

        while (bufferleitor.ready())	dados = bufferleitor.readLine();
      
        int i = 0;

        StringTokenizer troca = new StringTokenizer(dados, ";");

        while (troca.hasMoreTokens()) {
            vet[i] = Integer.parseInt(troca.nextToken());
            i++;
        }

        bufferleitor.close();
        lerarquivo.close();

        return vet;
	}
	
	public void gravarArq(String endereco, int[] array) throws IOException {

        File pasta = new File("C://data");
        pasta.mkdir();
        
		
        File arquivo = new File(endereco);
        
        try {

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter lerarquivo = new FileWriter(endereco);

            BufferedWriter bufferleitor = new BufferedWriter(lerarquivo);

            for (int counter = 0; counter < (array.length - 1); counter++) {
            	bufferleitor.write(array[counter]+";");
            }
            

                
            bufferleitor.close();
            lerarquivo.close();

        } catch (IOException ex) {
        }
    }
}

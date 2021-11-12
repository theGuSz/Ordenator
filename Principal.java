package ordena;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Principal implements ActionListener{
	
	Ordenacao ordenar = new Ordenacao();
    Arq arquivo = new Arq();
    
	static JFrame tela = new JFrame();
	JButton BtAuto = new JButton("Iniciar com valores gerados autoamaticamente");
	JButton BtStart = new JButton("Iniciar");
	JButton BtManual = new JButton("Iniciar com valores inseridos manualmente");
	JTextArea TATime = new JTextArea("Tempo de execução dos metodos", 40, 3);
	JTextField TFQuant = new JTextField("Quantas cordenadas serão geradas?");
	JLabel JLtitle = new JLabel("Ordenador de Cordenadas");	
	
	int n;
	boolean mode;
	
	public Principal(){
		
		tela.setSize(1080,720);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setTitle("Ordenador Ver.1.0.0.15");
		tela.setLayout(null);
		tela.setVisible(true);
		
		JLtitle.setBounds(100, 50, 900, 100);
		JLtitle.setHorizontalAlignment(SwingConstants.CENTER);
		JLtitle.setFont(new Font("Serif", Font.BOLD, 42));
		
		BtAuto.setBounds(100, 170, 350, 100);
		BtAuto.addActionListener(this);
		
		BtManual.setBounds(600, 170, 350, 100);
		BtManual.addActionListener(this);
		
		BtStart.setBounds(350, 170, 350, 100);
		BtStart.addActionListener(this);
		BtStart.setVisible(false);
		
		TFQuant.setBounds(350, 320, 350, 100);
		TFQuant.setVisible(false);
		
		TATime.setBounds(100, 460, 800, 100);
		TATime.setLineWrap(true);
        TATime.setWrapStyleWord(true);
        TATime.setEditable(false);
        
		
		tela.add(BtAuto);
		tela.add(BtStart);
		tela.add(TFQuant);
		tela.add(BtManual);
		tela.add(TATime);
		tela.add(JLtitle);
	}


public static void main(String[] args) {	
		
	Principal frame = new  Principal();
	
}


private static int[] gerar(int n) {
	
	int []v = new int[n];
	
	Random gerador = new Random();
	
	for (int i = 0; i < n; i++) 		
		v[i] = gerador.nextInt(10000);
	
	
	return v;
}

	@Override
	public void actionPerformed(ActionEvent e) {
	
			if(e.getSource()==BtAuto) {
			
				TFQuant.setVisible(true);
				BtManual.setVisible(false);
				BtAuto.setVisible(false);
				BtStart.setVisible(true);
			
				mode = false;
			
		}
		
		if(e.getSource()==BtManual) {
	        
			BtManual.setVisible(false);
			BtAuto.setVisible(false);
			BtStart.setVisible(true);
			TFQuant.setVisible(true);
			int resposta = JOptionPane.showConfirmDialog(tela,"Coloque os dados a serem ordenados em C://data//entrada.txt ", "Alerta", JOptionPane.PLAIN_MESSAGE);

			mode = true;
			
		}
		
		if(e.getSource()==BtStart) {
			
			if(mode == true) {
				
				n = Integer.parseInt(TFQuant.getText());
				
		        int[] arrayDesordenado = new int[n];
		        
		        int[] arrayOrdenado = new int[n];
		        
		        try {
					arrayDesordenado = arquivo.lerArq("C:\\data\\entrada.txt",n);						
				} catch (IOException e1) {						
					e1.printStackTrace();					
				}
		     
		        
		        execucao(arrayDesordenado, arrayOrdenado);
	       

			}
			if(mode == false) {
				
				n = Integer.parseInt(TFQuant.getText());
				
		        int[] arrayDesordenado = new int[n];
		        
		        int[] arrayOrdenado = new int[n];
		        
		        arrayDesordenado = gerar(n);
		        
		        try {	
					arquivo.gravarArq("C:\\data\\entrada.txt", arrayDesordenado);	
				} catch (IOException e1) {	
					e1.printStackTrace();
				}
		        
		        TATime.setText("Numeros desordenados disponiveis em C:\\data\\entrada.txt \n");  
		        
		        execucao(arrayDesordenado, arrayOrdenado);
		        
		        
			}
		}
	}


	void execucao(int[] arrayDesordenado,int[] arrayOrdenado){
		
		long tempoinicialQ = System.currentTimeMillis();       
		
        arrayOrdenado = Ordenacao.quicksort(arrayDesordenado, 0, (arrayDesordenado.length - 1));	 
        
        long tempofinalQ = System.currentTimeMillis();         
        long tempototalQ = tempofinalQ - tempoinicialQ;
        
        TATime.insert("Tempo de Processamento de QuickSort: " + tempototalQ + "ms \n", 0);  
             
      try {	
			arquivo.gravarArq("C:\\data\\saidaQuick.txt", arrayOrdenado);	
		} catch (IOException e1) {	
			e1.printStackTrace();
		}
        
        
		long tempoinicialI = System.currentTimeMillis();   
		
        arrayOrdenado = Ordenacao.insertsort(arrayDesordenado);	
        
        long tempofinalI = System.currentTimeMillis();   
        long tempototalI = tempofinalI - tempoinicialI;
        
        TATime.insert("Tempo de Processamento de InsertionSort: " + tempototalI + "ms \n",0); 
        
        try {	
			arquivo.gravarArq("C:\\data\\saidaIns.txt", arrayOrdenado);	
		} catch (IOException e1) {	
			e1.printStackTrace();
		}	        
        
        
        long tempoinicialB = System.currentTimeMillis();       
        
        arrayOrdenado = Ordenacao.bubbleSort(arrayDesordenado);	        
        
        long tempofinalB = System.currentTimeMillis(); 
        long tempototalB = tempofinalB - tempoinicialB;
        
        TATime.insert("Tempo de Processamento de BubbleSort: " + tempototalB + "ms\n",0);
        
        try {	
			arquivo.gravarArq("C:\\data\\saidaBuble.txt", arrayOrdenado);	
		} catch (IOException e1) {	
			e1.printStackTrace();
		}	
        
        TATime.insert("Resutado das Ordenções disponiveis em C:\\data\\ \n",0);

	}


}

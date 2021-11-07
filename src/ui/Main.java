package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	private BufferedReader br;	
	private BufferedWriter bw;
	
	//Las 3 agujas de diamante (Torres)
	private int[] a;
	private int[] b;
	private int[] c;

	
	
	/*
	*Código inspirado en la información de la página: puntocomnoesunlenguaje. 
	*Link: http://puntocomnoesunlenguaje.blogspot.com/2012/04/torres-de-hanoi.html
	*/
	public Main() throws IOException {
		br = new BufferedReader(new FileReader("data/Hanoi_Towers_input.txt"));	
		bw = new BufferedWriter(new FileWriter("data/Hanoi_Towers_output.txt"));
		a = new int[1];
		b = new int[1];
		c = new int[1];
	}

	public static void main(String[] args) throws IOException {
		Main m= new Main();
		int line= Integer.parseInt(m.br.readLine());
		
		m.stackRepeater(line);

		m.br.close();
		m.bw.close();
		System.out.println("El resultado fue exportado exitosamente en el archivo Hanoi_Towers_output");
	}
	
	//Agente que se encarga de sacar la informacion de la pila
	//Este metodo tambien se encarga de repetir el metodo Hanoi en diferentes casos de numeros de discos
	public void stackRepeater(int line) throws IOException {
		if(line==0) {
			return;
		}else {
			int numb= Integer.parseInt(br.readLine());
			a[0]= numb;
			bw.write(a[0]+" "+b[0]+" "+c[0]+"\n");

			hanoi(numb, a, c, b);
			bw.write("\n");
			a[0]=0;
			b[0]=0;
			c[0]=0;

			line--;
			stackRepeater(line);
		}
	}

	
	//Hanoi Towers = 2^n-1 donde n es el número de discos
	//Son 3 torres: origen, destino y auxiliar
	public void hanoi(int n, int[] origen, int[] destino, int[] auxiliar) throws IOException {
		if(n==1) {
			origen[0]--;
			destino[0]++;
			bw.write(a[0]+" "+b[0]+" "+c[0]+"\n");
			return;
			
		}else {
			hanoi(n-1,origen,auxiliar, destino);
			origen[0]--;
			destino[0]++;
			bw.write(a[0]+" "+b[0]+" "+c[0]+"\n");
			hanoi(n-1, auxiliar, destino, origen);
		}

	}
}

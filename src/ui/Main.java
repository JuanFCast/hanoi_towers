package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	private BufferedReader br;	
	private BufferedWriter bw;
	private int[] a;
	private int[] b;
	private int[] c;

	public Main() throws IOException {
		br = new BufferedReader(new FileReader("data/Hanoi_Towers_input.txt"));	
		bw = new BufferedWriter(new FileWriter("data/Hanoi_Towers_output.txt"));
		a=new int[1];
		b=new int[1];
		c=new int[1];
	}

	public static void main(String[] args) throws IOException {
		Main m= new Main();
		int line= Integer.parseInt(m.br.readLine());

		m.br.close();
		m.bw.close();
	}

	//Son 3 torres
	//Hanoi towers = 2^nd-1 donde nd es el número de discos
	//pre: d!=null,nd!=0                   A              C                B   
}

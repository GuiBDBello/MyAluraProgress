package br.com.alura.java.io.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class TesteEscrita3 {

	public static void main(String[] args) throws IOException {
		
		//Fluxo de Saída com Arquivo
//		OutputStream fos = new FileOutputStream("lorem2.txt");
//		Writer osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("lorem2.txt"));
		
//		PrintStream ps = new PrintStream(new File("lorem2.txt"));
//		
//		ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
//		ps.println();
//		ps.println("Texto dois!");
//		
//		ps.close();
		
		PrintWriter pw = new PrintWriter("lorem2.txt");
		
		pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		pw.println();
		pw.println("Texto três!");
		
		pw.close();
	}

}

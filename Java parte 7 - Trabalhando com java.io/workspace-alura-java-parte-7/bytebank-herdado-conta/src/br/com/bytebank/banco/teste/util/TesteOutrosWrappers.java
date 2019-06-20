package br.com.bytebank.banco.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {

	public static void main(String[] args) {
		
		Integer idadeRef = new Integer(29); //autoboxing
		System.out.println(idadeRef.doubleValue()); //unboxing
		
		Double dRef = Double.valueOf(3.2); //autoboxing
		System.out.println(dRef.doubleValue()); //unboxing
		
		Boolean bRef = Boolean.TRUE; //autoboxing
		System.out.println(bRef.booleanValue()); //unboxing
		
		Number refNumeroInteger = Integer.valueOf(29);
		Number refNumeroDouble = Double.valueOf(29.9);
		Number refNumeroFloat = Float.valueOf(29.9f);
		
		List<Number> lista = new ArrayList<>();
		lista.add(10);
		lista.add(32.6);
		lista.add(25.6f);
		
	}
}

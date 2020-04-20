package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

    public static void main(String[] args) {

        testaList();
        testaHashSet();
    }
    
    public static void testaList() {
    	
    	Collection<Integer> numeros = new ArrayList<Integer>();

        long inicio = System.currentTimeMillis();

        // Inserção muito rápida
        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        // Busca muito lenta
        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("Tempo gasto (List): " + tempoDeExecucao);
    }
    
    public static void testaHashSet() {
    	
    	Collection<Integer> numeros = new HashSet<Integer>();
        
        long inicio = System.currentTimeMillis();

        // Inserção rápida (porém mais lenta que List)
        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        // Busca muito rápida
        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;

        System.out.println("Tempo gasto (HashSet): " + tempoDeExecucao);
    }
}

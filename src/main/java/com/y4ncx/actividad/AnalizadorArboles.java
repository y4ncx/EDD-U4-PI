package com.y4ncx.actividad;

import com.y4ncx.actividad.estructuras.BinarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class AnalizadorArboles {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        // --- Leer el archivo numerico ---
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        AnalizadorArboles.class.getResourceAsStream("/numeros.txt")
                ))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.trim().split("\\s+");
                for (String t : tokens) {
                    if (!t.isEmpty()) {
                        numeros.add(Integer.parseInt(t));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
            return;
        }


        if(numeros.isEmpty()){
            System.out.println("No hay numeros en el archivo.");
            return;
        }

        // --- Estadisticas ---

        Collections.sort(numeros);
        int min = numeros.get(0);
        int max = numeros.get(numeros.size()-1);
        double promedio = numeros.stream().mapToInt(Integer::intValue).average().orElse(0);

        System.out.println("Minimo: " + min);
        System.out.println("Maximo: " + max);
        System.out.println("Promedio: " + promedio);

        // --- Insertar en ABB ---
        BinarySearchTree<Integer> abb = new BinarySearchTree<>();
        for (int n : numeros) abb.insert(n);

        System.out.println("\nRecorrido inOrder (ABB)");
        abb.inOrder();

        System.out.println("Recorrido PreOrder (ABB)");
        abb.preOrder();

        System.out.println("Recorrido PostOrder (ABB)");
        abb.postOrder();


        // --- Comparativa con treeSet ---
        TreeSet<Integer> treeSet = new TreeSet<>(numeros);
        System.out.println("\nTreeSet ordenado: " + treeSet);

    }
}

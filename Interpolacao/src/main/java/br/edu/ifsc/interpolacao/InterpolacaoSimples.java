/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.interpolacao;

import br.edu.ifsc.sistemaslineares.exatos.EliminacaoGaussiana;
import java.math.BigDecimal;

/**
 *
 * @author Vitor
 */
public class InterpolacaoSimples {

    private static BigDecimal polinomio[];

    private static void definirMatrix() {
        double matriz[][] = {
            {Math.pow(1950, 2), 1950, 1, 352724},
            {Math.pow(1970, 2), 1970, 1, 1235030},
            {Math.pow(1980, 2), 1980, 1, 1814990}
        };

        EliminacaoGaussiana.setMatriz(matriz);
    }

    public static void calcularPolinomio(double valor) {
        definirMatrix();
        polinomio = EliminacaoGaussiana.calcularVetorX();
        imprimirResultadoPolinomio();
        calcularValorPolinomio(valor);
    }

    private static void imprimirResultadoPolinomio() {
        int expoente = polinomio.length - 1;
        System.out.println("\n");
        System.out.println("Polinomio Resultante:");
        for (int x = 0; x < polinomio.length; x++) {
            System.out.print(polinomio[x] + "x^(" + expoente + ") ");
            expoente--;
        }
        System.out.println("\n");
    }
    
    private static void calcularValorPolinomio(double valor){
        BigDecimal valorBigDecimal = new BigDecimal(valor);
        int expoente = polinomio.length - 1;
        BigDecimal resultado = BigDecimal.ZERO;
        System.out.println("\n");
        System.out.println("P(" + valor +"):");
        for (int x = 0; x < polinomio.length; x++) {
            System.out.print(polinomio[x] + " * " + Math.pow(valor, expoente) + " ");
            resultado = resultado.add(polinomio[x].multiply(valorBigDecimal.pow(expoente)));
            expoente--;
        }
        System.out.println("");
        System.out.println("P(" + valor + ") = " + resultado);
        System.out.println("\n");
    }

}

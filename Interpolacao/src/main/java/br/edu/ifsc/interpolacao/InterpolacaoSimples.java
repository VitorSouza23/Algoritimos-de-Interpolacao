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
            {58, 1, 60},
            {100, 1, 90}
            
            
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.interpolacao;

import br.edu.ifsc.sistemaslineares.exatos.EliminacaoGaussiana;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 *
 * @author Vitor
 */
public class InterpolacaoDeLagrange {
    private static final int CASA_DECIMAL = 3;
    private static final int CASA_DECIMAL_DIVISOR = 15;
    private static final RoundingMode ROUND_MODE = RoundingMode.HALF_EVEN;
    private static BigDecimal polinomio[];
    private static BigDecimal vetYi[];
    private static BigDecimal matriz[][];
    
    private static double matrizDouble[][] = {
            {Math.pow(1950, 2), 1950, 1, 352724},
            {Math.pow(1970, 2), 1970, 1, 1235030},
            {Math.pow(1980, 2), 1980, 1, 1814990}
        };
    private static void definirMatrix() {
        matriz = new BigDecimal[matrizDouble.length][matrizDouble[0].length];
        for(int l = 0; l < matrizDouble.length; l++){
            for(int c = 0; c < matrizDouble[0].length; c++){
                matriz[l][c] = new BigDecimal(matrizDouble[l][c]).setScale(CASA_DECIMAL, ROUND_MODE);
            }
        }
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
    
    private static void definirvetYi(){
        for(int l = 0; l < matriz.length; l++){
            vetYi[l] = matriz[l][matriz[0].length -1];
        }
    }
    
    private static void polinomioDeLagrange(){
        definirvetYi();
        BigDecimal soma = BigDecimal.ZERO, multiplicacao = BigDecimal.ONE;
        ArrayList<BigDecimal> vetSoma = new ArrayList<>();
        ArrayList<BigDecimal> vetMultiplicacao = new ArrayList<>();
        for(int s = 0; s < matriz.length; s++){
            for(int m = 0; m < matriz[0].length; m++){
                
            }
        }
    }
}

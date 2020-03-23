/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_ganfer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Efren Salado
 */
public class ImporteExcato {

    public static double monedas[];
    public static double sueldo[];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        monedas = new double[7];

        System.out.println("Ingrese cantidad de sueldos a pagar:");
        int cantidad = in.nextInt();
        sueldo = new double[cantidad];

        for (int i = 0; i < sueldo.length; i++) {
            System.out.println("Ingrese sueldo no. " + (i + 1) + " a pagar:");
            sueldo[i] = in.nextDouble();
        }

        for (int i = 0; i < sueldo.length; i++) {
            generarCalculo(sueldo[i]);
        }
        //System.out.println("\n");
        System.out.println("El cambio a entregar es el siguiente:");

        System.out.println("50: " + (int)monedas[0]);
        System.out.println("20: " + (int) monedas[1]);
        System.out.println("10: " + (int) monedas[2]);
        System.out.println("5: " + (int) monedas[3]);
        System.out.println("2: " + (int) monedas[4]);
        System.out.println("1: " + (int) monedas[5]);
        System.out.println(".50: " + (int) monedas[6]);

    }

    static void generarCalculo(double valor) {
        double total = 0.0;
        
        total = valor;
        if (total >= 50) {
            int residuo = (int)(total / 50);
            total = total - (residuo * 50);
            monedas[0] = monedas[0] + residuo;
        }

        if (total > 20) {
            int residuo = (int)(total / 20);
            total = total - (residuo * 20);
            monedas[1] = monedas[1] + residuo;
        }

        if (total >= 10 && total < 20) {
            int residuo = (int)(total / 10);
            total = total - (residuo * 10);
            monedas[2] = monedas[2] + residuo;
        }

        if (total >= 5) {
            int residuo = (int)(total / 5);
            total = total - (residuo * 5);
            monedas[3] = monedas[3] + residuo;
        }
        
        if (total >= 2) {
            int residuo = (int)(total / 2);
            total = total - (residuo * 2);
            monedas[4] = monedas[4] + residuo;
        }
        
        if (total >= 1 && total < 2) {
            int residuo = (int)(total / 1);
            total = total - (residuo * 1);
            monedas[5] = monedas[5] + residuo;
        }

        if (total == 0.5) {
            total = total - 0.5;
            monedas[6] = monedas[6] + 1;
        }      
    }
}
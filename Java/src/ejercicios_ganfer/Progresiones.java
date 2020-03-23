/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_ganfer;

import java.util.Scanner;

/**
 *
 * @author Efren Salado
 */
public class Progresiones {

    static int resultados[];
    static public int progresion[];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de numeros a manejar:");

        int positions = in.nextInt();

        int progresion[] = new int[positions];

        for (int i = 0; i < positions; i++) {
            System.out.println("Ingrese numero " + (i + 1) + " :");
            progresion[i] = in.nextInt();
        }

        validar(progresion);
    }

    static void validar(int arry[]) {
        if (isProgArit(arry)) {
            System.out.println("El array es PA");
        } else if (!isProgArit(arry)) {
            System.out.println("El array no es PA");
            if (isProgGeom(arry)) {
                System.out.println("El array es PG");
            } else if (!isProgGeom(arry)) {
                System.out.println("El array no es PG");
            }
        }
    }

    static boolean isProgArit(int numeros[]) {
        int pos = numeros.length;
        int difer = numeros[1] - numeros[0];

        if ((numeros[pos - 1] - (numeros[pos - 2])) == difer) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isProgGeom(int numeros[]) {
        int pos = numeros.length;
        int difer = numeros[1] / numeros[0];
        //System.out.println(difer);

        if ((numeros[pos - 1] / (numeros[pos - 2])) == difer) {
            //System.out.println((numeros[pos - 1] / (numeros[pos - 2])));
            return true;
        } else {
            return false;
        }
    }

}

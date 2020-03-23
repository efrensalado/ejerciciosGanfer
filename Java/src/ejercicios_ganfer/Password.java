/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_ganfer;

import java.util.Scanner;

/**
 *
 * @author efren
 */
public class Password {

    static char[] letras;
    static int lon;
    
    public static void main(String args[]) {
        String pass;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese password a validar: ");
            pass = in.next();
            if (pass.equals("fin")) {
                break;
            }
            letras = pass.toCharArray();
            lon = pass.length();
            if (filtro1() && filtro2() && filtro3()) {
                System.out.println("El password '" + pass + "' cumple con los criterios");
            } else {
                System.out.println("El password '" + pass + "' no cumple con los criterios");
            }
        }
    }

    static boolean isVocal(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    static boolean filtro1() {
        for (int i = 0; i < lon; i++) {
            if (isVocal(letras[i])) {
                return true;
            }
        }
        return false;
    }

    static boolean filtro2() {
        int i, v = 0, c = 0;
        for (i = 0; i < lon; i++) {
            if (isVocal(letras[i])) {
                v++;
                c = 0;
            } else {
                c++;
                v = 0;
            }
            if (v == 3 || c == 3) {
                return false;
            }
        }
        return true;
    }

    static boolean filtro3() {
        for (int i = 1; i < lon; i++) {
            if (letras[i] == letras[i - 1]
                    && letras[i] != 'e' && letras[i] != 'o') {
                return false;
            }
        }
        return true;
    }
}

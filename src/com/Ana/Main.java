package com.Ana;

import java.util.Scanner;

import static com.Ana.Fazan.FAZAN;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int greseliJucator1 = 0, greseliJucator2 = 0;
        boolean continua = true;

        System.out.println("=== Jocul Fazan ===");
        System.out.println("Reguli: cine greseste primeste cate o litera din cuvantul \" FAZAN \"");
        System.out.println("Cand un jucator ajunge la \"FAZAN \", a pierdut jocul");
        System.out.println("Scrie \"stop\" pentru a incheia");

        while (continua) {
            String ultimulCuvant;
            boolean rundaInDesfasurare = true;
            int randul = 1;  //incepe jucatorul 1

            //primul cuvant al rundei
            System.out.println("Jucatorul 1, introdu cuvantul: ");
            ultimulCuvant = scanner.nextLine();

            if (ultimulCuvant.equalsIgnoreCase("stop")) {
                break;
            }
            while (rundaInDesfasurare) {
                randul = (randul ==1) ? 2:1; //schimba jucatorul

                System.out.println("Jucatorul " + randul + ", introdu cuvantul: ");
                String cuvantNou = scanner.nextLine();

                if (cuvantNou.equalsIgnoreCase("stop")) {
                    continua = false;
                    break;
                }

                //extragem ultimele 2 litere
                String ultimeleDoua = ultimulCuvant.substring(ultimulCuvant.length() - 2);

                if (!cuvantNou.startsWith(ultimeleDoua) || cuvantNou.length() <=2) {
                    System.out.println("Gresit! Jucatorul " + randul + " a pierdut runda.");
                    if (randul == 1) {
                        greseliJucator1++;
                    }else {
                        greseliJucator2++;
                    }
                    rundaInDesfasurare = false;
                } else {
                    ultimulCuvant = cuvantNou; //continuam runda
                }
            }
            // afisam progesul fiecarui jucator
            System.out.println("\n Progres:");
            System.out.println("Jucator 1: " + FAZAN.substring(0, greseliJucator1));
            System.out.println("Jucator 2: " + FAZAN.substring(0, greseliJucator2));

            //verificam daca cineva a pierdut jocul
            if (greseliJucator1 == FAZAN.length()) {
                System.out.println("\n Jucatorul 2 a castigat! Jucatorul 1 a ajuns la \"FAZAN \"");
                continua = false;
            }else if (greseliJucator2 == FAZAN.length()) {
                System.out.println("\n Jucatorul 1 a castigat! Jucatorul 2 a ajuns la \"FAZAN \"");
                continua = false;
            }
        }
        System.out.println("\n===Joc incheiat===");
        scanner.close();
    }
}
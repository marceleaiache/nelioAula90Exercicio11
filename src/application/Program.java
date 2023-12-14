package application;

import entities.Person;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int qntPerson;
        System.out.println("Quantas pessoas serão digitadas?");
        qntPerson = sc.nextInt();
        sc.nextLine();

        Person[] vect = new Person[qntPerson];
        double shorterHeight = 100;
        double heigher = 0;
        double allWomanHeight = 0;
        double average;
        int qntWoman = 0;
        int qntMen = 0;

        for (int i=0; i<vect.length; i++) {
            System.out.printf("Altura da %da pessoa: %n", i+1);
            double height = sc.nextDouble();
            System.out.printf("Gênero da %da pessoa: %n", i+1);
            char gender = sc.next().charAt(0);

            vect[i] = new Person(height, gender);

            if (vect[i].getHeight() > heigher) {
                heigher = vect[i].getHeight();
            }
            if (vect[i].getHeight() < shorterHeight) {
                shorterHeight = vect[i].getHeight();
            }

            switch (gender) {
                case 'f':
                case 'F':
                    allWomanHeight += height;
                    qntWoman++;
                    break;
                case 'M':
                case 'm':
                    qntMen++;
                    break;
            }
        }

        average = allWomanHeight / qntWoman;

        System.out.println("Menor altura = " + shorterHeight);
        System.out.println("Maior altura = " + heigher);

        System.out.printf("Média das alturas das mulheres = %.2f%n", average);
        System.out.println("Número de homens = " + qntMen);



        sc.close();
    }
}

package application;

import entities.CompanyTax;
import entities.IndividualTax;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int qtd = input.nextInt();

        for (int i=1; i<=qtd; i++){
            System.out.println("\nTax payer #" + i + " data:");
            System.out.print("individual or company (i/c)? ");
            char type = input.next().charAt(0);

            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = input.nextDouble();

            if (type == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = input.nextDouble();
                list.add(new IndividualTax(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int employees = input.nextInt();
                list.add(new CompanyTax(name, anualIncome, employees));
            }
        }

        double sum = 0.0;
        System.out.println("\nTAXES PAID:");
        for (TaxPayer tp: list) {
            double tax = tp.TotalTax();
            System.out.print(tp.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.print("\nTOTAL TAXES: $ " + String.format("%.2f", sum));

        input.close();
    }

}

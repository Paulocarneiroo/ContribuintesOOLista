package ContribuintesOOLista.Application;

import ContribuintesOOLista.Entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ContribuintesOOLista {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();
        System.out.print("How much taxpayers? ");
        int n = sc.nextInt();

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter " + (i+1)+"°" + " taxpayer data:");
            System.out.print("Annual income with salary: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Annual income with services provision: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Annual income with capital gains: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Medics expenditures: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Educational expenditures: ");
            double educationSpending = sc.nextDouble();

            TaxPayer taxpayer = new TaxPayer(salaryIncome,
                    servicesIncome,
                    capitalIncome,
                    healthSpending,
                    educationSpending);

            list.add(taxpayer);
        }

        for (TaxPayer taxpayer : list) {
            System.out.println((list.indexOf(taxpayer) + 1) + "°" + " taxpayer summary:");
            System.out.println("Total gross tax: " + String.format("%.2f", taxpayer.grossTax()));
            System.out.println("Rebate: " + String.format("%.2f", taxpayer.taxRebate()));
            System.out.println("Tax Due: " + String.format("%.2f", taxpayer.netTax()));
            System.out.println();
        }
        sc.close();
    }
}

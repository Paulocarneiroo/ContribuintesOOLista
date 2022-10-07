package AnaliseDeVendas1.Application;

import AnaliseDeVendas1.Entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AnaliseDeVendas1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String path = sc.nextLine();

        List<Sale> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null){

                String[] fields = line.split(",");
                list.add(new Sale(Integer.parseInt(fields[0]),
                                Integer.parseInt(fields[1]),
                                fields[2],
                                Integer.parseInt(fields[3]),
                                Double.parseDouble(fields[4])));

                line = br.readLine();
            }
            Comparator<Sale> comp = (sale1, sale2) -> sale1.averagePrice()
                    .compareTo(sale2.averagePrice());

            List<Sale> sales = list.stream()
                    .filter(sale -> sale.getYear() == 2016)
                    .sorted(comp.reversed())
                    .limit(5)
                    .collect(Collectors.toList());


            System.out.println("First five 2016 higher average price sales:");
            sales.forEach(System.out::println);


            double totalValueLogan = list.stream()
                        .filter(sale -> sale.getSeller().equals("Logan")
                                && sale.getMonth() == 1 || sale.getSeller().equals("Logan")
                                        && sale.getMonth() == 7)
                                                 .map(sale -> sale.getTotal())
                                                        .reduce(0.0, (x,y) -> x + y);


            System.out.println("Total value sold by seller Logan on month 01 and 07: " + totalValueLogan);

        }catch (IOException e){
            System.out.println("Error: " + path + "System can't find file in path");
        }finally {
            sc.close();
        }
    }
}

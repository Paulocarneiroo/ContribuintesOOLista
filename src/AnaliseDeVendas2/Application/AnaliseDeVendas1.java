package AnaliseDeVendas2.Application;

import AnaliseDeVendas2.Entities.Sale;

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

            Set<String> names = new HashSet<>();

            for (Sale sale : list) {
                names.add(sale.getSeller());
            }

            double sum;
            System.out.println("Total sales for each Seller:");
            for (String name : names) {
               sum = list.stream()
                       .filter(sale -> sale.getSeller().equals(name))
                       .map(sale -> sale.getTotal())
                       .reduce(0.0, (x,y) -> x+y);

                System.out.println(name + " - R$ " + String.format("%.2f", sum));
            }

        }catch (IOException e){
            System.out.println("Error: " + path + " System can't find file in path");
        }finally {
            sc.close();
        }
    }
}

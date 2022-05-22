package SoftUni.Advanced.SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shop = new TreeMap<>();


        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] shopInput = input.split(", ");
            if (shop.containsKey(shopInput[0])) {
                LinkedHashMap<String, Double> product = shop.get(shopInput[0]);
                String productName = shopInput[1];
                double price = Double.parseDouble(shopInput[2]);
                product.put(productName, price);
                shop.put(shopInput[0],product);
            } else {
                String shopName = shopInput[0];
                LinkedHashMap<String, Double> product = new LinkedHashMap<>();
                String productName = shopInput[1];
                double price = Double.parseDouble(shopInput[2]);
                product.put(productName, price);
                shop.put(shopName, product);
            }
            input = scanner.nextLine();
        }
        shop.forEach((shopN,product) ->{
            System.out.println(shopN + "->");
            product.forEach((productName, price) ->{
                System.out.printf("Product: %s, Price: %.1f\n", productName, price);
            });
        });
        System.out.println();
    }
}


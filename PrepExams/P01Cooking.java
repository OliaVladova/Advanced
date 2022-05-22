package SoftUni.Advanced.PrepExams;

import java.util.*;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] ingredientsInput = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i = 0; i < liquidsInput.length; i++) {
            liquids.offer(liquidsInput[i]);
        }
        for (int i = 0; i < ingredientsInput.length; i++) {
            ingredients.push(ingredientsInput[i]);
        }
        List<String> cooked = new ArrayList<>();

        while (!ingredients.isEmpty() && !liquids.isEmpty()) {
            int mixed = ingredients.peek() + liquids.peek();
            String meal = "";
            switch (mixed) {
                case 25:
                    meal = "Bread";
                    break;
                case 50:
                    meal = "Cake";
                    break;
                case 75:
                    meal = "Pastry";
                    break;
                case 100:
                    meal = "Fruit Pie";

                    break;

            }
            if (!meal.isEmpty()) {
                cooked.add(meal);
                liquids.pop();
                ingredients.poll();
            } else {
                liquids.pop();
                int ingredientNew = ingredients.poll() + 3;
                ingredients.push(ingredientNew);
            }
        }
        int bread = 0;
        int cake = 0;
        int fruitPie = 0;
        int pastry = 0;
        for (String meal : cooked) {
            if (meal.equals("Bread")) {
                bread++;
            } else if (meal.equals("Cake")) {
                cake++;
            } else if (meal.equals("Fruit Pie")) {
                fruitPie++;
            } else if (meal.equals("Pastry")) {
                pastry++;
            }
        }
        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(String.join(", ", liquids.toString()
                    .replaceAll("[\\[\\]]", "")));
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(String.join(", ", ingredients.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        System.out.printf("Bread: %d\n", bread);
        System.out.printf("Cake: %d\n", cake);
        System.out.printf("Fruit Pie: %d\n", fruitPie);
        System.out.printf("Pastry: %d\n", pastry);

    }
}

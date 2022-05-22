package SoftUni.Advanced.PrepExams;

import java.util.*;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bombEffects = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> bombEffectsQueue = new ArrayDeque<>();
        for (Integer num:bombEffects) {
            bombEffectsQueue.offer(num);
        }
        int[] bombCasings = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> bombCasingsStack = new ArrayDeque<>();
        for (Integer num:bombCasings) {
            bombCasingsStack.push(num);
        }

        Map<String, Integer> bombs = new TreeMap<>();
        String first = "Datura Bombs";
        String second = "Cherry Bombs";
        String third = "Smoke Decoy Bombs";
        bombs.put(first,0);
        bombs.put(second,0);
        bombs.put(third,0);
        boolean isEnough = false;
        while (!bombEffectsQueue.isEmpty()&&!bombCasingsStack.isEmpty()){
            int mix = bombEffectsQueue.peek() + bombCasingsStack.peek();
            String nameBomb = "";
            switch (mix){
                case 40:
                    nameBomb = "Datura Bombs";
                    bombEffectsQueue.poll();
                    bombCasingsStack.pop();

                        bombs.put(nameBomb,bombs.get(nameBomb) + 1);
                    break;
                case 60:
                    nameBomb = "Cherry Bombs";
                    bombEffectsQueue.poll();
                    bombCasingsStack.pop();

                        bombs.put(nameBomb,bombs.get(nameBomb) + 1);

                    break;
                case 120:
                    nameBomb = "Smoke Decoy Bombs";
                    bombEffectsQueue.poll();
                    bombCasingsStack.pop();

                        bombs.put(nameBomb,bombs.get(nameBomb) + 1);

                    break;
                default:
                    int bombCasing = bombCasingsStack.pop() - 5;
                    bombCasingsStack.push(bombCasing);
                    break;
            }
            if (!bombs.isEmpty()&&bombs.get(first)>=3&&bombs.get(second)>=3&&bombs.get(third)>=3){
                isEnough = true;
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                break;
            }

        }
        if (!isEnough){
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectsQueue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: ");
            System.out.println(String.join(", ", bombEffectsQueue.toString()
                    .replaceAll("[\\[\\]]", "")));
        }
        if (bombCasingsStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.print("Bomb Casings: ");
            System.out.println(String.join(", ", bombCasingsStack.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

            System.out.println("Cherry Bombs: " + bombs.get("Cherry Bombs"));
            System.out.println("Datura Bombs: " + bombs.get("Datura Bombs"));
            System.out.println("Smoke Decoy Bombs: " + bombs.get("Smoke Decoy Bombs"));

    }
}

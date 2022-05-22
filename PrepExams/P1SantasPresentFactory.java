package SoftUni.Advanced.PrepExams;

import java.util.*;

public class P1SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stackInput = scanner.nextLine().split("\\s+");
        Map<String, Integer> gifts = new TreeMap<>();
        ArrayDeque<Integer> stackMaterials = new ArrayDeque<>();
        for (int i = 0; i < stackInput.length; i++) {
            stackMaterials.push(Integer.parseInt(stackInput[i]));
        }
        String[] queueInput = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> queueMagic = new ArrayDeque<>();
        for (int i = 0; i < queueInput.length; i++) {
            queueMagic.offer(Integer.parseInt(queueInput[i]));
        }

        while (!stackMaterials.isEmpty() && !queueMagic.isEmpty()) {
            int material = stackMaterials.peek();
            int magic = queueMagic.peek();
            int forCrafting = material * magic;
            String toy = "";
            switch (forCrafting) {
                case 150:
                    toy = "Doll";
                    stackMaterials.pop();
                    queueMagic.poll();
                    gifts.putIfAbsent(toy, 0);
                    gifts.put(toy, gifts.get(toy) + 1);
                    break;
                case 250:
                    toy = "Wooden train";
                    stackMaterials.pop();
                    queueMagic.poll();
                    gifts.putIfAbsent(toy, 0);
                    gifts.put(toy, gifts.get(toy) + 1);
                    break;
                case 300:
                    toy = "Teddy bear";
                    stackMaterials.pop();
                    queueMagic.poll();
                    gifts.putIfAbsent(toy, 0);
                    gifts.put(toy, gifts.get(toy) + 1);
                    break;
                case 400:
                    toy = "Bicycle";
                    stackMaterials.pop();
                    queueMagic.pop();
                    gifts.putIfAbsent(toy, 0);
                    gifts.put(toy, gifts.get(toy) + 1);
                    break;

            }
            if (forCrafting < 0) {
                int stack = stackMaterials.pop();
                int queue = queueMagic.poll();
                int sum = stack + queue;
                stackMaterials.push(sum);
            }
            if (forCrafting > 0 && forCrafting != 150 && forCrafting != 250 && forCrafting != 300 && forCrafting != 400) {
                queueMagic.poll();
                stackMaterials.push(stackMaterials.pop() + 15);
            }
            if (material == 0) {
                stackMaterials.pop();
            }
            if (magic == 0) {
                queueMagic.poll();
            }
        }
        if (gifts.containsKey("Doll") && gifts.containsKey("Wooden train")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else if (gifts.containsKey("Teddy bear") && gifts.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!stackMaterials.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.println(String.join(", ", stackMaterials.toString()
                    .replaceAll("[\\[\\]]", "")));
        }

        if (!queueMagic.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(String.join(", ", queueMagic.toString()
                    .replaceAll("[\\[\\]]", "")));
        }
        for (Map.Entry<String, Integer> gift : gifts.entrySet()) {
            System.out.printf("%s: %d\n", gift.getKey(), gift.getValue());
        }
    }
}

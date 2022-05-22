package SoftUni.Advanced.SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();

        while (true){
            String resource = scanner.nextLine();
            if (resource.equals("stop")){
                break;
            }else {
                int quantity = Integer.parseInt(scanner.nextLine());
                if (resources.containsKey(resource)){
                    resources.put(resource,resources.get(resource) + quantity);
                }else {
                    resources.put(resource,quantity);
                }
            }
        }
        for (Map.Entry<String,Integer> resource: resources.entrySet()) {
            System.out.printf("%s -> %d\n",resource.getKey(),resource.getValue());
        }
    }
}

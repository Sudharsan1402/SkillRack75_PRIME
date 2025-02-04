import java.util.*;
class FoodItem implements Comparable<FoodItem> {
    String name;
    List<Integer> customers;

    @Override
    public int compareTo(FoodItem other) {
        return this.customers.size() - other.customers.size();
    }
}
public class IntelligentChef {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine(); // Consume newline

        Map<String, FoodItem> foodItemMap = new HashMap<>();
        List<Integer> remainingCustomers = new ArrayList<>();

        for (int customer = 1; customer <= N; customer++) {
            remainingCustomers.add(customer);
            String preferences[] = in.nextLine().split("\\s+");

            for (String item : preferences) {
                if (!foodItemMap.containsKey(item)) {
                    FoodItem fi = new FoodItem();
                    fi.name = item;
                    fi.customers = new ArrayList<>();
                    foodItemMap.put(item, fi);
                }
                foodItemMap.get(item).customers.add(customer);
            }
        }

        int count = 0;
        while (!remainingCustomers.isEmpty()) {
            List<FoodItem> items = new ArrayList<>(foodItemMap.values());
            Collections.sort(items, Collections.reverseOrder());

            if (items.isEmpty()) break;

            FoodItem mostPreferred = items.get(0);
            count++;

            foodItemMap.remove(mostPreferred.name);
            remainingCustomers.removeAll(mostPreferred.customers);

            for (String foodItem : foodItemMap.keySet()) {
                foodItemMap.get(foodItem).customers.removeAll(mostPreferred.customers);
            }
        }

        System.out.println(count);


    }
}

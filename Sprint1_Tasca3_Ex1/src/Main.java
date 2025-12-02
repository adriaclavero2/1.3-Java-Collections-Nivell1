import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Month> months = new ArrayList<>();
        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

        months.add(7, new Month("August"));

        System.out.println("\nList ordered by insertion:");
        for (Month m : months) {
            System.out.println(m.getName());
        }

        Set<Month> monthSet = new HashSet<>(months);

        monthSet.add(new Month("August"));

        System.out.println("\nTraversal of the HashSet (without duplicates):");
        for (Month m : monthSet) {
            System.out.println(m);
        }

        System.out.println("Traversal with Iterator:");
        Iterator<Month> it = monthSet.iterator();
        while (it.hasNext()) {
            Month next = it.next();
            System.out.println(next.getName());
        }
    }
}
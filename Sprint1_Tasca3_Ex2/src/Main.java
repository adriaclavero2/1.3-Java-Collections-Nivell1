import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        List<Integer>First = new ArrayList<>();
        First.add(1);
        First.add(2);
        First.add(3);
        First.add(4);

        List<Integer>Second = new ArrayList<>();

        ListIterator<Integer> it = First.listIterator(First.size());

        while(it.hasPrevious()) {
            Integer valor = it.previous();
            Second.add(valor);
        }

        System.out.println(First);
        System.out.println(Second);


    }
}

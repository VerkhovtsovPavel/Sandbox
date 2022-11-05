import java.util.LinkedHashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> array = List.of(1, 2, 3, 1, 6, 3);
        LinkedHashSet<Integer> set = new LinkedHashSet<>(array);
        for(Integer el : set) {
            System.out.print(el + " ");
        }
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        List<String> list = generateList();
        System.out.println(list);
        sortByAlphafet(list);
        System.out.println(list);
        sortByLength(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    private static void sortByLength(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
    }

    private static void sortByAlphafet(List<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    static List<String> generateList(){
        List<String> list = new ArrayList<>();
        list.add("Sergey");
        list.add("Andrey");
        list.add("Denis");
        list.add("Olga");
        list.add("Maksim");
        list.add("Masha");
        return list;
    }

}

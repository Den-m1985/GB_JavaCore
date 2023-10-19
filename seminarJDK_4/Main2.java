import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        List<String> list = generateList();
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
        System.out.println(getMaxByLength(set));
        removeByChar(set);
        System.out.println(set);
    }

    static void removeByChar(Set<String> set) {
        set.removeIf(s -> s.contains("D"));
    }

    static String getMaxByLength(Set<String> set) {
        return set.stream().max(Comparator.comparingInt(String::length)).get();
    }

    static String getMinByAlphabet(Set<String> set) {
        Set<String> set1 = new TreeSet<>(set);
//        System.out.println(set1.stream().max(String::compareTo));
        Iterator<String> iterator = set1.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    static List<String> generateList() {
        List<String> list = new ArrayList<>();
        list.add("Sergey");
        list.add("Andrey");
        list.add("Denis");
        list.add("Denis");
        list.add("Olga");
        list.add("Maksim");
        list.add("Maksim");
        list.add("Masha");
        return list;
    }

}

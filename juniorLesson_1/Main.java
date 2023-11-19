import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x+y);
//            }
//        };
        //PlainInterface plainInterface = (x, y) -> x+y;
        PlainInterface plainInterface = Integer::sum;

        PlainInterface plainInterface1 = Integer::compare;

        System.out.println(plainInterface.action(5, 3));
        System.out.println(plainInterface1.action(2, 6));

        List<String> list = Arrays.asList("gfbfb", "dfgsfd", "sdf", "fdgdxf");
//        list = list.stream().filter(str -> str.length() >2).collect(Collectors.toList());
//        for (String str: list
//             ) {
//            System.out.println(str);
//        }
        list.stream().filter(str -> str.length() > 2).forEach(System.out::println);

        Arrays.asList(1, 2, 5, 6, 9, 5).stream().
                map(chislo -> "число: " + chislo + " квадрат числа: " + chislo * chislo).
                forEach(System.out::println);

        Arrays.asList(1, 2, 5, 6, 9, 5).stream().sorted().forEach(System.out::print);
        System.out.println();
        //удаляем дубликаты
        Arrays.asList(1, 2, 5, 6, 9, 5).stream().sorted().distinct().forEach(System.out::print);

        System.out.println();


        List<User> list2 = Arrays.asList(new User("Sergey", 55),
                new User("Dima", 25),
                new User("Olga", 5));
        list2.stream().map(user -> new User(user.getName(), user.getAge()-5)).forEach(System.out::println);
        System.out.println();
        list2.stream().map(user -> new User(user.getName(), user.getAge()-5)).
                filter(user -> user.getAge() >25).
                forEach(System.out::println);

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static String oddNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> i + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    public static List<String> sortedUpper(List<String> names) {
        return names.stream()
                .map(name -> name.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static String sortedNumbers(String[] arr) {
        return Arrays.stream(arr)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(s -> Integer.parseInt(s))
                .sorted()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", "));
    }

    public static Stream<Long> lcg(long a, long c, long m) {
        return Stream.iterate(42L, x -> Math.floorMod(a * x + c, m));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> it1 = first.iterator();
        Iterator<T> it2 = second.iterator();
        List<T> result = new ArrayList<>();

        while (it1.hasNext() && it2.hasNext()) {
            result.add(it1.next());
            result.add(it2.next());
        }
        return result.stream();
    }

    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Ivan", "Olga", "Peter");
        System.out.println(oddNames(names));
        System.out.println(sortedUpper(names));

        String[] arr = {"1, 2, 0", "4, 5"};
        System.out.println(sortedNumbers(arr));

        System.out.println(lcg(25214903917L, 11L, 1L << 48).limit(5).toList());

        System.out.println(zip(Stream.of("A", "B", "C"), Stream.of("1", "2", "3", "4")).toList());
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        List<String> strings = new ArrayList<>(List.of("один", "два", "два", "три", "три", "три"));

        task1(nums);
        task2(nums);
        task3(strings);
        task4(strings);
    }

    public static void task1(List<Integer> nums) {
        var i = 1;
        System.out.println("---   Задание № 1 - Элементы с нечетным значением:   ---");
        for (int elem : nums) {
            if (elem % 2 != 0) {
                System.out.println("№ " + i + " = " + elem);
            }
            i++;
        }
        System.out.println();
    }

    public static void task2(List<Integer> nums) {
        System.out.println("---   Задание № 2 - четные числа без повторений в порядке возрастания:   ---");
        Set<Integer> set = new HashSet<>(nums); // убираем дубликаты, уникальные зхначения будут сохранены в set
        List<Integer> arr = new ArrayList<>(set);
        List<Integer> arrOut = new ArrayList<>();

        Collections.sort(arr); //сортировка элементов set в порядке возрастания
        for (int elem : arr) {
            if (elem % 2 == 0) {
                arrOut.add(elem);
            }
        }
        System.out.println(arrOut + "\n");

    }

    public static void task3(List<String> strings) {
        System.out.println("---   Задание № 3 - вывод в консоль всех уникальных слов из списка слов, в котором могут встречаться дубли:   ---");
        Set<String> uniqueStrings = new HashSet<>(strings); // убираем дубликаты, уникальные зхначения будут сохранены в set
        System.out.println(uniqueStrings + "\n");
    }

    public static void task4(List<String> strings) {
        System.out.println("---   Задание № 4 - вывод в консоль количества дублей для каждого уникального слова.:   ---");
        System.out.println("            ---   Вариант № 1   ---");
        Map<String, Integer> countMap = new HashMap<>();
        strings.forEach(str -> {
            if (countMap.containsKey(str)) {
                countMap.put(str, countMap.get(str) + 1); // если слово (str) уже есть в мапе countMap (как ключ), то учеличить его значение на 1 (увеличить количество)
            } else {
                countMap.put(str, 1); // если слова str нет в мапе countMap, то внести его в качестве ключа, а его значением установить 1 (количество вхождений ключа в исходный список strings.
            }
        });

        System.out.println(countMap);

        System.out.println("            ---   Вариант № 2 - строгое следование заданию   ---");
        for (Map.Entry<String, Integer> elem : countMap.entrySet()) {
            String word = elem.getKey();
            Integer count = elem.getValue();
            if (count > 1) {
                System.out.println("Слово " + word + " имеет " + count + " дублей.");
            } else System.out.println("Слово " + word + " дублей не имеет - в ихсодном списке встречается 1 раз.");
        }
    }
}

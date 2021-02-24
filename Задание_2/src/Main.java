import java.util.*;

public class Main {
// Задача № 2 Частотный словарь слов латинского алфавита
    public static void main(String[] args) {
        System.out.println("Это мой проект JAVA - Задание №2 и №3 ");
        System.out.println("Введите строку из букв латинского алфавита");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int length = str.length();
        Map<String,Integer> wordMap = new HashMap<>();
        String[] strArray = str.split(" ");
        System.out.println("Частотный словарь слов латинского алфавита");
        for (String s:strArray) {
           if (!wordMap.containsKey(s))
               wordMap.put(s,1);
           else
               wordMap.put(s,wordMap.get(s) + 1);
        }
        for (String S:wordMap.keySet()) {
            System.out.print(S + " = " + wordMap.get(S));
            System.out.println();
           }
// Задача № 3 метод, который на вход получает коллекцию объектов, а возвращает коллекцию без дубликатов
      RunTask3(strArray);
    }

    private static void RunTask3(String[] strArray) {
        System.out.println("Введите число 1 для выбора интерфейса List, 2 для выбора интерфейса Set, 3 для выбора интерфейса TreeSet:");
        GenericCollection<Collection> generic1 = new GenericCollection<>(null);
        Collection Lst;
        Scanner scanner = new Scanner(System.in);
        int digit = scanner.nextInt();
        if (digit == 1) {
            // интерфейс List
            Lst = new ArrayList();
        }
        else if (digit == 2) {
            // интерфейс Set
           Lst = new HashSet();
        }
        else {
            // интерфейс TreeSet
            Lst = new TreeSet();
        }
            Collections.addAll(Lst, strArray);
            Lst = generic1.removeDuplicates(Lst);
            if (Lst != null) {
                System.out.println("Строка без дубликатов");
                for (Object S : Lst) {
                    System.out.print(S.toString());
                    System.out.print(" ");
                }
            }
        }




}

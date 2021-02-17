import java.util.*;
// Задача № 2 Частотный словарь слов латинского алфавита
public class Main {
    public static void main(String[] args) {
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

    }
}

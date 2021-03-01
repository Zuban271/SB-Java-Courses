import java.util.*;

// Задание 4 метод, который получает на вход Map<K, V> и возвращает Map, где ключи и значения поменяны местами.
public class Main {
    public static void main(String[] args) {
// Инициализация начальных значений карты
        Map<String,Integer> myMap = new HashMap<>();
        myMap.put("Ivan",23);
        myMap.put("Ilya",23);
        myMap.put("Inna",28);
        myMap.put("Alex",25);
        myMap.put("Igor",23);
// Вывод начальных значений карты
        System.out.println("Начальная карта");
        for (Object m: myMap.keySet()) {
            System.out.print(m + " ");
            System.out.println(myMap.get(m));
        }

        Map<Integer,Set<String>> reversemyMap = new HashMap<>();
        reversemyMap = RevertMap(myMap);

// Вывод измененной карты, где ключи и значения поменяны местами
        System.out.println("Перевёрнутая карта");
        for (Object m: reversemyMap.keySet()) {
            System.out.print(m + " ");
            System.out.println(reversemyMap.get(m));
        }
    }
// Метод, который меняет местами ключи и значения
    private static Map<Integer, Set<String>> RevertMap(Map<String, Integer> myMap) {
        Map<Integer,Set<String>> rMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            Integer Val = entry.getValue();
            String Key = entry.getKey();
            Set<String> newVal = null;

            if(rMap.containsKey(Val)){
                newVal = rMap.get(Val);
                newVal.add(Key);
            }
            else {
                newVal = new HashSet<>();
                newVal.add(Key);
            }

            rMap.put(Val,newVal);

        }
        return rMap;
    }
}

import java.util.*;
// Класс Generics
public class GenericCollection<T> {
    T field;
// Коструктор класса
    public GenericCollection(T field) {
        this.field = field;
    }

// метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов
    public Collection<T> removeDuplicates(Collection<T> collection){
      TreeSet result = new TreeSet();
      result.addAll(collection);
      return  result;
    }
}

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
        if (collection instanceof List) {
            ((List) collection).sort(Comparator.naturalOrder());
            List result = new ArrayList();
            result.addAll(collection);

            for (Object o : collection) {
                int i = 1;
                while (i > 0)
                {
                    i = result.lastIndexOf(o);
                    if (result.indexOf(o) != i)
                        result.remove(i);
                    else
                        i = 0;
                }
            }
            return result;
        } 
        else if (collection instanceof Set) {
            return collection;
        }
        else if (collection instanceof TreeSet) {
            return collection;
        }
        else
            return null;
    }
}

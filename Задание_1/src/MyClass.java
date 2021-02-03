import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

public  class MyClass{
    private Integer[] Numbers;
    private int lengthArray = 0;
    private int capasityArray = 10;

// Дефолтный конструктор
    public MyClass() {

    }
// Конструктор для инициализации целочисленного массива
    public MyClass(Integer[] numbers) {
        Numbers = new Integer[capasityArray];
        int i = 0;
        lengthArray = numbers.length;
        for (Integer n:numbers) {
            this.Numbers[i] = n;
            i++;
            if (capasityArray == i)
                ResizeArray();
        }

    }
// Метод Изменения размера массива
    private void ResizeArray() {
        Integer[] tempArray = new Integer[capasityArray];
        tempArray = Arrays.copyOf(this.Numbers,tempArray.length);
        this.Numbers = null;
        Numbers = new Integer[lengthArray + capasityArray/2];
        Numbers = Arrays.copyOf(tempArray,Numbers.length);
        capasityArray = Numbers.length;
    }
// Метод добавление элемента в конец массива
    public void setNumbersEnd(Integer num) {
        this.Numbers[lengthArray] = num;
        lengthArray++;
        if (capasityArray <= lengthArray)
            ResizeArray();
    }
// Метод добавление элемента в массив, в определенную позицию
    public void setNumbersPos(Integer num, int pos) {
        Integer[] tempArray = new Integer[lengthArray - pos];
        if (pos>0 && pos < this.lengthArray) {
            tempArray = Arrays.copyOfRange(this.Numbers,pos,lengthArray);
            this.Numbers[pos] = num;
            int i = pos + 1;
            for (Integer n:tempArray) {
                this.Numbers[i] = n;
                i++;
            }
            lengthArray++;
            if (capasityArray <= lengthArray)
                ResizeArray();
        } else
            System.out.println("Номер позиции превышает диапозон массива");
    }
// Функция вывода количества элементов в массиве
    public int ArrayLength(){
        return this.lengthArray;
    }
// Метод удаление элемента массива по индексу
   public void delNumbersPos(int pos) {
        Integer[] tempArray = new Integer[lengthArray - pos];
        if (pos>0 && pos < this.lengthArray) {
            tempArray = Arrays.copyOfRange(this.Numbers,pos + 1,lengthArray);
            int i = pos;
            for (Integer n:tempArray) {
                this.Numbers[i] = n;
                i++;
            }
            lengthArray--;
        } else
            System.out.println("Номер позиции превышает диапозон массива");
    }
// Метод изменения значения по его индексу
    public void changeNumbersPos(int num, int pos) {
        if (pos>0 && pos < this.lengthArray)
            this.Numbers[pos] = num;
        else
            System.out.println("Номер позиции превышает диапозон массива");
    }
// Метод вывода на экран всего массива
    public void printArray(){
        for (int i=0;i<this.lengthArray;i++) {
            System.out.printf("Элемент массива = %d\n",this.Numbers[i]);
        }
    }
// Функция сортировки массива по возрастанию (без изменения исходного массива)
    public Integer[] sortNumbersIncrease(){
        Integer[] tempArray = new Integer[lengthArray];
        tempArray = Arrays.copyOfRange(this.Numbers,0,lengthArray);
        Arrays.sort(tempArray);
        return tempArray;
    }
// Функция сортировки массива по убыванию (без изменения исходного массива)
    public Integer[] sortNumbersDecrease(){
        Integer[] tempArray = new Integer[lengthArray];
        tempArray = Arrays.copyOfRange(this.Numbers,0,lengthArray);
        Arrays.sort(tempArray, Collections.reverseOrder());
        return tempArray;
    }
// Функция вывода максимального/минимального элемента
    public int maxORminNumber(boolean maxORmin){
       int max = this.Numbers[0];
       int min = this.Numbers[0];
       if (maxORmin){
           for (int i=0;i< this.lengthArray;i++) {
               if (this.Numbers[i] > max)
                   max = this.Numbers[i];
           }
           return max;
       }
       else {
           for (int i=0;i< this.lengthArray;i++) {
               if (this.Numbers[i] < min)
                   min = this.Numbers[i];
           }
           return min;
       }
    }
// Метод заполнения массива одинаковыми элементами
    public void setEqualElement(int element){
        for (int i=0; i< this.lengthArray;i++) {
          this.Numbers[i] = element;
        }
    }
}

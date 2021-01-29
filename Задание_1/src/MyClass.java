import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

public  class MyClass{
    private ArrayList <Integer> Numbers = new ArrayList<>();

    public MyClass() {

    }

    public MyClass(Integer[] numbers) {
        this.Numbers.addAll(Arrays.asList(numbers));
    }

    public void setNumbersEnd(int num) {
        this.Numbers.add(num);
    }
    public void setNumbersPos(int num, int pos) {
        if (pos>0 && pos < this.Numbers.size())
            this.Numbers.add(pos,num);
        else
            System.out.println("Номер позиции превышает диапозон массива");
    }
    public int ArrayLength(){
        return this.Numbers.size();
    }
    public void delNumbersPos(int pos) {
        if (pos>0 && pos < this.Numbers.size())
            this.Numbers.remove(pos);
        else
            System.out.println("Номер позиции превышает диапозон массива");
    }
    public void changeNumbersPos(int num, int pos) {
        if (pos>0 && pos < this.Numbers.size())
            this.Numbers.set(pos,num);
        else
            System.out.println("Номер позиции превышает диапозон массива");
    }
    public void printArray(){
        for (Integer n:this.Numbers) {
            System.out.printf("Элемент массива = %d\n",n.intValue());
        }
    }

    public ArrayList sortNumbersIncrease(){
        ArrayList <Integer> temp = new ArrayList<Integer>();
        temp.addAll(Numbers);
        temp.sort(naturalOrder());
        return temp;
    }

    public ArrayList sortNumbersDecrease(){
        ArrayList <Integer> temp = new ArrayList<Integer>();
        temp.addAll(Numbers);
        temp.sort(reverseOrder());
        return temp;
    }

    public int maxORminNumber(boolean maxORmin){
       int max = this.Numbers.get(0);
       int min = this.Numbers.get(0);
       if (maxORmin){
           for (Integer n:this.Numbers) {
               if (n > max)
                   max = n;
           }
           return max;
       }
       else {
           for (Integer n:this.Numbers) {
               if (n < min)
                   min = n;
           }
           return min;
       }
    }

    public void setEqualElement(int element){
        for (int i=0; i< this.Numbers.size();i++) {
          this.Numbers.set(i,element);
        }
    }
}

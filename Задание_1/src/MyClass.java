import java.util.ArrayList;

import static java.util.Comparator.naturalOrder;

public  class MyClass{
    private ArrayList <Integer> Numbers;

    public MyClass() {

    }

    public MyClass(ArrayList<Integer> numbers) {
    this.Numbers = numbers;
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

    public void sortNumbers(){
        this.Numbers.sort(naturalOrder());
    }

}

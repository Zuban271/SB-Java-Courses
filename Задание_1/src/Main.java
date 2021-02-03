import javax.xml.transform.Source;
//import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

// Проект Зубань Алексея, Задание № 1
public class Main {
    public static int[] Numbers;
    public static int[] Miles;
    public static int[] Parameter;
    public static float AllConsumption = 0;
    public static float MaxCarConsumtion = 0;
    public static float MinCarConsumtion = 0;
    public static String MaxCarCode = "";
    public static String MinCarCode = "";

    public static void main(String[] args) {
        System.out.println("Это мой проект JAVA - Задание №1 ");
//Задача 1
        String[] Auto = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
     RunGSM(Auto);
//Задача 2
     Integer[] testArray = {10,20,30,40,13,24,56,22,12,44,55,34,78,45,676,89,11,23,43,50,39,19,678,15,41};
     RunTaskTwo(testArray);
    }
// Метод выполения задачи 2
    public static void RunTaskTwo(Integer[] myArray) {
        // инициализация целочисленного массива
        MyClass NewClass = new MyClass(myArray);
        NewClass.printArray();
        System.out.printf("Длина массива = %d\n",NewClass.ArrayLength());
        System.out.println();
        // добавление элемента 888 в конец массива
        NewClass.setNumbersEnd(888);
        NewClass.printArray();
        System.out.printf("Длина массива = %d\n",NewClass.ArrayLength());
        System.out.println();
        // добавление элемента 777 в массив, на позицию 10
        NewClass.setNumbersPos(777,10);
        NewClass.printArray();
        System.out.printf("Длина массива = %d\n",NewClass.ArrayLength());
        // удаление элемента массива по индексу 15
        NewClass.delNumbersPos(15);
        System.out.println();
        NewClass.printArray();
        System.out.printf("Длина массива = %d\n",NewClass.ArrayLength());
        System.out.println();
        // изменения значения по его индексу в конце массива на значение 999
        NewClass.changeNumbersPos(999,NewClass.ArrayLength() - 1);
        NewClass.printArray();
        System.out.println();
        Integer[] myNewArray;
        // сортировка массива по возрастанию (без изменения исходного массива)
        myNewArray = NewClass.sortNumbersIncrease();
        for (Integer n:myNewArray)
            System.out.printf("Элемент нового массива = %d\n",n.intValue());

        System.out.println();
        // сортировка массива по убыванию (без изменения исходного массива)
        myNewArray = NewClass.sortNumbersDecrease();
        for (Integer n:myNewArray)
            System.out.printf("Элемент нового массива = %d\n",n.intValue());

        System.out.println();
        // вывод максимального элемента
        int max = NewClass.maxORminNumber(true);
        System.out.printf("Максимальный элемент массива = %d\n",max);
        // вывод минимального элемента
        System.out.println();
        int min = NewClass.maxORminNumber(false);
        System.out.printf("Минимальный элемент массива = %d\n",min);

        System.out.println();
        // заполнения массива одинаковыми элементами: 7777
        NewClass.setEqualElement(7777);
        NewClass.printArray();
    }

    // Главный метод по запуску всего проекта по задаче 1
    public static void RunGSM(String[] auto){
// Расчет общих расходов, мин. максм. и на каждый класс авто
        AllMinMaxConsumption(auto);
        System.out.println("");
        System.out.printf("Общая стоимость расходов на ГСМ = %f\n", AllConsumption);
        System.out.println("");
        System.out.printf("тип авто имеющий наибольшую стоимость расходов - " + MaxCarCode + " = %f\n", MaxCarConsumtion);
        System.out.printf("тип авто имеющий наименьшую стоимость расходов - " + MinCarCode + " = %f\n", MinCarConsumtion);
        System.out.println("");
// Получение номеров и пробега легковых машин
        NumRunCar(auto);
// Получение номеров и пробега грузовых машин
        NumRunTruck(auto);
// Получение номеров и пробега пассажирского транспорта
        NumRunPassenger(auto);
// Получение номеров и пробега тяжелой техники
        NumRunHeavy(auto);
    }

    public static void NumRunCar(String[] auto){
        Numbers = NumberAuto("100",auto);
        Miles = MileAge("100",auto);
        SortMileAge();
        int i = 0;
        for (int n:Numbers) {
            if (n != 0) {
                System.out.printf("Номер Легковой машины = %d\n", n);
                System.out.printf("Пробег Легковой машины = %d\n", Miles[i]);
                System.out.println("");
                i++;
            }
        }
    }
    public static void NumRunTruck(String[] auto){
        Numbers = NumberAuto("200",auto);
        Miles = MileAge("200",auto);
        Parameter = DopParameter("200",auto);
        SortMileAgeDopParameter();
        int i = 0;
        for (int n:Numbers) {
            if (n != 0) {
                System.out.printf("Номер Грузовой машины = %d\n", n);
                System.out.printf("Пробег Грузовой машины = %d\n", Miles[i]);
                System.out.printf("объем перевезенного груза Грузовой машины = %d\n", Parameter[i]);
                System.out.println("");
                i++;
            }
        }
    }
    public static void NumRunPassenger(String[] auto){
        Numbers = NumberAuto("300",auto);
        Miles = MileAge("300",auto);
        Parameter = DopParameter("300",auto);
        SortMileAgeDopParameter();
        int i = 0;
        for (int n:Numbers) {
            if (n != 0) {
                System.out.printf("Номер пассажирского транспорта  = %d\n", n);
                System.out.printf("Пробег пассажирский транспорта  = %d\n", Miles[i]);
                System.out.printf("число перевезенных пассажиров пассажирским транспортом = %d\n", Parameter[i]);
                System.out.println("");
                i++;
            }
        }
    }
    public static void NumRunHeavy(String[] auto){
        Numbers = NumberAuto("400",auto);
        Miles = MileAge("400",auto);
        Parameter = DopParameter("400",auto);
        SortMileAgeDopParameter();
        int i = 0;
        for (int n:Numbers) {
            if (n != 0) {
                System.out.printf("Номер тяжелой техники  = %d\n", n);
                System.out.printf("Пробег тяжелой техники  = %d\n", Miles[i]);
                System.out.printf("вес поднятых грузов тяжелой техникой  = %d\n", Parameter[i]);
                System.out.println("");
                i++;
            }
        }
    }
    public static void AllMinMaxConsumption(String[] auto){
        for (String a : auto) {
            String[] CarCode = a.split("C")[1].split("_");

            //String[] CarCode1 = a.split("C");
            //String[] CarCode2 = CarCode1[1].split("_");
            //String[] CarCode3 = CarCode2[1].split("-");
            float CarConsumtion = 0;
            String ClassAuto = TypeAuto(CarCode[0]);
            float FuelCost = whatFuelCost(CarCode[0]);
            float FuelRate = whatFuelRate(CarCode[0]);
            // Расчет расходов на каждый класс авто
            CarConsumtion = Float.parseFloat(CarCode[1].split("-")[1]) / 100 * FuelRate * FuelCost;
            if (a.equals(auto[0]))
                MinCarConsumtion = CarConsumtion;

            if (MaxCarConsumtion < CarConsumtion) {
                MaxCarConsumtion = CarConsumtion;
                MaxCarCode = ClassAuto;
            }

            if (MinCarConsumtion > CarConsumtion) {
                MinCarConsumtion = CarConsumtion;
                MinCarCode = ClassAuto;
            }
            // Расчет общих расходов на ГСМ
            AllConsumption += CarConsumtion;
            System.out.printf("Расходы на класс авто: " + ClassAuto + " = %f\n", CarConsumtion);
        }
    }

// Сортировка по пробегу
    public static void SortMileAge() {
        for(int out =Miles.length - 1;out >=1; out--){
            for(int in=0; in < out; in++){
                if (Miles[in] > Miles[in+1]) {
                    int temp = Miles[in];
                    Miles[in] = Miles[in + 1];
                    Miles[in + 1] = temp;

                    int temp1 = Numbers[in];
                    Numbers[in] = Numbers[in + 1];
                    Numbers[in + 1] = temp1;
                }
            }
        }
    }
    // Сортировка по доп. параметру \пробегу
    public static void SortMileAgeDopParameter() {
        for(int out =Parameter.length - 1;out >=1; out--){
            for(int in=0; in < out; in++){
                if (Parameter[in] > Parameter[in+1]) {
                    int temp = Parameter[in];
                    Parameter[in] = Parameter[in + 1];
                    Parameter[in + 1] = temp;

                    int temp1 = Miles[in];
                    Miles[in] = Miles[in + 1];
                    Miles[in + 1] = temp1;

                    int temp2 = Numbers[in];
                    Numbers[in] = Numbers[in + 1];
                    Numbers[in + 1] = temp2;
                }
                    else if(Miles[in] > Miles[in+1]){
                        int temp = Parameter[in];
                        Parameter[in] = Parameter[in + 1];
                        Parameter[in + 1] = temp;

                        int temp1 = Miles[in];
                        Miles[in] = Miles[in + 1];
                        Miles[in + 1] = temp1;

                        int temp2 = Numbers[in];
                        Numbers[in] = Numbers[in + 1];
                        Numbers[in + 1] = temp2;
                    }
                }
            }
        }

// Вывести тип траспортного средства
    public static String TypeAuto(String t) {
        switch (t) {
            case "100":
                return "Легковая";
            case "200":
                return "Грузовая";
            case "300":
                return "Пассажирский транспорт";
            case "400":
                return "Тяжелая техника";
            default:
                return "Неверный код транспортного средства - " + t;

        }
    }
// Вывод стоимость топлива
    public static float whatFuelCost(String t) {
        switch (t) {
            case "100":
                return (float) 46.10;
            case "200":
                return (float) 48.90;
            case "300":
                return (float) 47.50;
            case "400":
                return (float) 48.90;
            default:
                return 0;

        }
    }
// Вывод расхода топлива
    public static float whatFuelRate(String t) {
        switch (t) {
            case "100":
                return (float) 12.5;
            case "200":
                return (float) 12.0;
            case "300":
                return (float) 11.5;
            case "400":
                return (float) 20.0;
            default:
                return 0;

        }
    }
// Возвращает номера авто
    public static int[] NumberAuto(String t, String[] A) {
        int i = 0;
        int[] Num = new int[A.length];
        for (String a : A) {
            String[] CarCode = a.split("C")[1].split("_");
            //String[] CarCode1 = a.split("C");
            //String[] CarCode2 = CarCode1[1].split("_");
            //String[] CarCode3 = CarCode2[1].split("-");

            if (CarCode[0].equals(t)) {
                Num[i] = Integer.parseInt(CarCode[1].split("-")[0]);
                i++;
            }
        }
        int[] resizeNum = new int[i];
        System.arraycopy(Num,0,resizeNum,0,i);
        return resizeNum;

    }
// Возвращает пробег
    public static int[] MileAge(String t, String[] A) {
        int i = 0;
        int[] Num = new int[A.length];
        for (String a : A) {
            String[] CarCode = a.split("C")[1].split("_");
            //String[] CarCode1 = a.split("C");
            //String[] CarCode2 = CarCode1[1].split("_");
           // String[] CarCode3 = CarCode2[1].split("-");

            if (CarCode[0].equals(t)) {
                Num[i] = Integer.parseInt(CarCode[1].split("-")[1]);
                i++;
            }
        }
        int[] resizeNum = new int[i];
        System.arraycopy(Num,0,resizeNum,0,i);
        return resizeNum;

    }
// Возвращает доп. параметр
    public static int[] DopParameter(String t, String[] A) {
        int i = 0;
        int[] Num = new int[A.length];
        for (String a : A) {
            String[] CarCode = a.split("C")[1].split("_");
            //String[] CarCode1 = a.split("C");
            //String[] CarCode2 = CarCode1[1].split("_");
            //String[] CarCode3 = CarCode2[1].split("-");

            if (CarCode[0].equals(t)) {
                Num[i] = Integer.parseInt(CarCode[1].split("-")[2]);
                i++;
            }
        }
        int[] resizeNum = new int[i];
        System.arraycopy(Num,0,resizeNum,0,i);
        return resizeNum;

    }

}



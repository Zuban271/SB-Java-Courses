import javax.xml.transform.Source;
//import java.util.Arrays;
import java.util.*;

// Проект Зубань Алексея, Задание № 1
public class Main {
    public static float AllConsumption = 0;
    public static float MaxCarConsumtion = 0;
    public static float MinCarConsumtion = 0;
    public static float CarConsumtion = 0;
    public static String MaxCarCode = "";
    public static String MinCarCode = "";
    public static Auto[] autoArray;

    public static void main(String[] args) {
        System.out.println("Это мой проект JAVA - Задание №1 ");
        System.out.println("Введите число 1 для запуска 1 задания или 2 для запуска 2 задания:");
        Scanner scanner = new Scanner(System.in);
        int digit = scanner.nextInt();
    if (digit == 1) {
//Задача 1
    String[] Automobile = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
    RunGSMclass(Automobile);
        }
    else {
//Задача 2
    Integer[] testArray = {10, 20, 30, 40, 13, 24, 56, 22, 12, 44, 55, 34, 78, 45, 676, 89, 11, 23, 43, 50, 39, 19, 678, 15, 41};
    RunTaskTwo(testArray);
    }
    }

// Главный метод по запуску всего проекта по задаче 1
    private static void RunGSMclass(String[] auto) {
// Создание массива Auto
        autoArray = new Auto[auto.length];
// Инициализация массива Auto
        initializeAuto(auto);

// Сортировка массива объектов Auto
        Arrays.sort(autoArray, new Comparator<Auto>() {
            @Override
            public int compare(Auto t1, Auto t2) {
                int ComparisonResult = t1.getMileage() - t2.getMileage();
                return 0 == ComparisonResult ? t1.getDop_parameters() - t2.getDop_parameters() : ComparisonResult;
            }
        });
// Рачет расхода топлива по классу авто
        calcCarConsumption();

            System.out.printf("Общая стоимость расходов на ГСМ = %f\n", AllConsumption);
            System.out.println();
            System.out.printf("тип авто имеющий наибольшую стоимость расходов - " + MaxCarCode + " = %f\n", MaxCarConsumtion);
            System.out.printf("тип авто имеющий наименьшую стоимость расходов - " + MinCarCode + " = %f\n", MinCarConsumtion);
            System.out.println();

    }

    private static void calcCarConsumption() {
        String ClassAuto ="";
        // Цикл по массиву Auto
        for (Auto A:autoArray) {
            ClassAuto = A.TypeAuto(A.getCode_car());
            System.out.println("Тип авто = " + ClassAuto);
            System.out.printf("Номер авто = %d\n", A.getNumber_car());
            System.out.printf("Пробег авто = %d\n", A.getMileage());
            if (A.getDop_parameters() != 0){
                String S = A.TypeParameter(A.getCode_car());
                System.out.printf(S + " = %d\n", A.getDop_parameters());
            }
            //  расчет расхода топлива
            CarConsumtion = A.CarConsumption();
            System.out.printf("Расход авто = %f\n", CarConsumtion);
            System.out.println();
            // Вычисление минимального/ максимального расхода топлива
            if (A.equals(autoArray[0])) {
                MinCarConsumtion = CarConsumtion;
                MinCarCode = ClassAuto;
            }
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
        }
    }

    private static void initializeAuto(String[] auto) {
        int i = 0;
        for (String a:auto) {
            String[] CarCode = a.replaceAll("_","-").split("C")[1].split("-");
            int cod_car = Integer.parseInt(CarCode[0]);
            int number_car = Integer.parseInt(CarCode[1]);
            int mileage = Integer.parseInt(CarCode[2]);
            int dop_parameters = 0;
            if (CarCode.length == 4)
                dop_parameters = Integer.parseInt(CarCode[3]);
            autoArray[i] = new Auto(cod_car,number_car,mileage,dop_parameters);
            i++;
        }
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

}



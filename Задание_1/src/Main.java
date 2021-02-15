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
    public static ArrayList<Auto> autoArray;
    public static ArrayList<Sedan> SedanArray;
    public static ArrayList<Truck> TruckArray;
    public static ArrayList<Passenger_Transport> Passenger_TransportArray;
    public static ArrayList<Heavy_Vehicles> Heavy_VehiclesArray;

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
        autoArray = new ArrayList<>();
// Инициализация массивов SedanArray, TruckArray, Passenger_TransportArray, Heavy_VehiclesArray
        initializeSedan(auto);
        initializeTruck(auto);
        initializePassenger_Transport(auto);
        initializeHeavy_Vehicles(auto);
// Копирование массивов объектов Sedan, Truck, Passenger_Transport, Heavy_Vehicles в autoArray
        autoArray.addAll(SedanArray);
        autoArray.addAll(TruckArray);
        autoArray.addAll(Passenger_TransportArray);
        autoArray.addAll(Heavy_VehiclesArray);

// Сортировка массива объектов
       autoArray.sort(Comparator.comparing(Auto::getMileage).thenComparing(Auto::getDop_parameters));

// Рачет расхода топлива по классу авто
        calcCarConsumption();

            System.out.printf("Общая стоимость расходов на ГСМ = %f\n", AllConsumption);
            System.out.println();
            System.out.printf("тип авто имеющий наибольшую стоимость расходов - " + MaxCarCode + " = %f\n", MaxCarConsumtion);
            System.out.printf("тип авто имеющий наименьшую стоимость расходов - " + MinCarCode + " = %f\n", MinCarConsumtion);
            System.out.println();

    }

    private static void initializeSedan(String[] auto) {
        SedanArray = new ArrayList<>();
        for (String a:auto) {
            String[] CarCode = a.replaceAll("_", "-").split("C")[1].split("-");
            if (CarCode[0].matches("100") ) {
                int cod_car = Integer.parseInt(CarCode[0]);
                int number_car = Integer.parseInt(CarCode[1]);
                int mileage = Integer.parseInt(CarCode[2]);
                SedanArray.add(new Sedan.Builder(cod_car, number_car, mileage).build());
            }
        }
    }

    private static void initializeTruck(String[] auto) {
        TruckArray = new ArrayList<>();
        for (String a:auto) {
            String[] CarCode = a.replaceAll("_", "-").split("C")[1].split("-");
            if (CarCode[0].matches("200") ) {
                int cod_car = Integer.parseInt(CarCode[0]);
                int number_car = Integer.parseInt(CarCode[1]);
                int mileage = Integer.parseInt(CarCode[2]);
                int dop_parameters = Integer.parseInt(CarCode[3]);
                TruckArray.add(new Truck.Builder(cod_car, number_car, mileage).dop_parameters(dop_parameters).build());
            }
        }
    }

    private static void initializePassenger_Transport(String[] auto) {
        Passenger_TransportArray = new ArrayList<>();
        for (String a:auto) {
            String[] CarCode = a.replaceAll("_", "-").split("C")[1].split("-");
            if (CarCode[0].matches("300") ) {
                int cod_car = Integer.parseInt(CarCode[0]);
                int number_car = Integer.parseInt(CarCode[1]);
                int mileage = Integer.parseInt(CarCode[2]);
                int dop_parameters = Integer.parseInt(CarCode[3]);
                Passenger_TransportArray.add(new Passenger_Transport.Builder(cod_car, number_car, mileage).dop_parameters(dop_parameters).build());
            }
        }
    }

    private static void initializeHeavy_Vehicles(String[] auto) {
         Heavy_VehiclesArray= new ArrayList<>();
        for (String a:auto) {
            String[] CarCode = a.replaceAll("_", "-").split("C")[1].split("-");
            if (CarCode[0].matches("400") ) {
                int cod_car = Integer.parseInt(CarCode[0]);
                int number_car = Integer.parseInt(CarCode[1]);
                int mileage = Integer.parseInt(CarCode[2]);
                int dop_parameters = Integer.parseInt(CarCode[3]);
                Heavy_VehiclesArray.add(new Heavy_Vehicles.Builder(cod_car, number_car, mileage).dop_parameters(dop_parameters).build());
            }
        }
    }

    private static void calcCarConsumption() {
        String ClassAuto ="";
        // Цикл по массиву Auto
        for (Auto A:autoArray) {
            //ClassAuto = A.TypeAuto(A.getCode_car());
            if (A.getClass() == Sedan.class)
                ClassAuto = ((Sedan) A).getTypeAuto();
            else if (A.getClass() == Truck.class)
                ClassAuto = ((Truck) A).getTypeAuto();
            else if (A.getClass() == Passenger_Transport.class)
                ClassAuto = ((Passenger_Transport) A).getTypeAuto();
            else
                ClassAuto = ((Heavy_Vehicles) A).getTypeAuto();

            System.out.println("Тип авто = " + ClassAuto);
            System.out.printf("Номер авто = %d\n", A.getNumber_car());
            System.out.printf("Пробег авто = %d\n", A.getMileage());

            if (A.getClass() == Truck.class)
                System.out.printf(((Truck) A).getTypeParameter() + " = %d\n", A.getDop_parameters());
            else if (A.getClass() == Passenger_Transport.class)
                System.out.printf(((Passenger_Transport) A).getTypeParameter() + " = %d\n", A.getDop_parameters());
            else if (A.getClass() == Heavy_Vehicles.class)
                System.out.printf(((Heavy_Vehicles) A).getTypeParameter() + " = %d\n", A.getDop_parameters());

            //  расчет расхода топлива
            CarConsumtion = A.CarConsumption();
            System.out.printf("Расход авто = %f\n", CarConsumtion);
            System.out.println();
            // Вычисление минимального/ максимального расхода топлива
            if ( A.equals(autoArray.get(0))) {
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



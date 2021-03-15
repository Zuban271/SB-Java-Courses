import javax.xml.transform.Source;
//import java.util.Arrays;
import java.io.*;
import java.util.*;

// Проект Зубань Алексея, Задание № 1 GSM
public class Main {
    //Задача 1
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
    public static ArrayList<Driver> Drivers;

    public static void main(String[] args) throws IOException {
        //PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("result_gsm.txt")));
        //System.setOut(out);
        //System.setErr(out);

        System.out.println("Это мой проект JAVA - Задание №1 ГСМ ");
        System.out.println("Введите список водителей, в формате: имя, тип авто(легковая - л, грузовая - г, пассажирский транспорт - п, тяжелая техника - т), номер авто, где:");

       /* for (String l:driverlist) {
            System.out.println(l);
        }*/


//Чтение строки их файла automobile.txt
 try(BufferedReader bufferedReader = new BufferedReader(new FileReader("automobile.txt"))) {
     String bufferString = "";
     ArrayList<String> automobiles = new ArrayList<>();
     //System.out.println("Массив автомобилей");
     while ((bufferString = bufferedReader.readLine()) != null) {
         String[] auto = bufferString.split(",");
         Collections.addAll(automobiles, auto);
         //System.out.println(bufferString);
     }
     RunGSMclass(automobiles.toArray(String[]::new));
     //out.close();
  }
 catch (IOException e) {
     e.printStackTrace();
      }

  }

private static  ArrayList<String> ReadDrivers() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
    String s ="";
    ArrayList<String> driverlist = new ArrayList<>();
    while (!s.equals("quit")){
        s =reader.readLine();
        if (!s.equals("quit"))
            driverlist.add(s);
    }
    return driverlist;
}
// Главный метод по запуску всего проекта по задаче 1
    private static void RunGSMclass(String[] auto) throws IOException {
// Создание массива Drivers
        Drivers = new ArrayList<>();

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

        System.out.print("Номера легковых машин: ");
        for (Sedan s:SedanArray) {
            System.out.print(s.getNumber_car());
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("Номера грузовых машин: ");
        for (Truck t:TruckArray) {
            System.out.print(t.getNumber_car());
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("Номера пассажирского транспорта: ");
        for (Passenger_Transport p:Passenger_TransportArray) {
            System.out.print(p.getNumber_car());
            System.out.print(" ");
        }
        System.out.println();
        System.out.print("Номера тяжелой техники: ");
        for (Heavy_Vehicles h:Heavy_VehiclesArray) {
            System.out.print(h.getNumber_car());
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("Для выхода наберите: quit");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");

        ArrayList<String> driverlist = ReadDrivers();
        for (String d:driverlist) {
            String[] str = d.split(",");
            int car_cod = 0;
            switch (str[1]){
                case "л":
                    car_cod = 100;
                    break;
                case "г":
                    car_cod = 200;
                    break;
                case "п":
                    car_cod = 300;
                    break;
                case "т":
                    car_cod = 400;
                    break;
                default:
                    car_cod = -1;
                    break;
            }
            Drivers.add(new Driver(str[0],5,car_cod,Integer.parseInt(str[2])));
        }
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
            for (Driver d:Drivers){
                if((d.getCode_car() == A.getCode_car()) & (d.getNumber_car() == A.getNumber_car())) {
                    System.out.println("Водитель авто = " + d.getName());
                    d.setSalary(d.getTariff() * A.getMileage());
                    System.out.printf("Водитель заработал = %f\n", d.getSalary());
                }
            }

            if (A.getClass() == Truck.class)
                System.out.printf(((Truck) A).getTypeParameter() + " = %d\n", A.getDop_parameters());
            else if (A.getClass() == Passenger_Transport.class)
                System.out.printf(((Passenger_Transport) A).getTypeParameter() + " = %d\n", A.getDop_parameters());
            else if (A.getClass() == Heavy_Vehicles.class)
                System.out.printf(((Heavy_Vehicles) A).getTypeParameter() + " = %d\n", A.getDop_parameters());

            //  расчет расхода топлива
            if (A.getClass() == Sedan.class)
                CarConsumtion = ((Sedan) A).CarConsumption();
            else if (A.getClass() == Truck.class)
                CarConsumtion = ((Truck) A).CarConsumption();
            else if (A.getClass() == Passenger_Transport.class)
                CarConsumtion = ((Passenger_Transport) A).CarConsumption();
            else
                CarConsumtion = ((Heavy_Vehicles) A).CarConsumption();

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

}



public class Auto {
    private int code_car;
    private int number_car;
    private int mileage;
    private int dop_parameters;
// Дефолтный конструктор
    public Auto(){

    }
// Конструктор для инициализации объекта Auto
    public Auto(int cod_car, int number_car, int mileage, int dop_parameters) {
        this.code_car = cod_car;
        this.number_car = number_car;
        this.mileage = mileage;
        this.dop_parameters = dop_parameters;
    }
// Метод расчета расхода топлива
    public  float CarConsumption(){
            float FuelCost = whatFuelCost(this.getCode_car());
            float FuelRate = whatFuelRate(this.getCode_car());
            // Расчет расходов на класс авто
        float CarConsumtion = (float) this.getMileage() / 100 * FuelRate * FuelCost;
            return CarConsumtion;
        }
// Метод определения типа авто по коду класса
        public  String TypeAuto(int t) {
            switch (t) {
                case 100:
                    return "Легковая";
                case 200:
                    return "Грузовая";
                case 300:
                    return "Пассажирский транспорт";
                case 400:
                    return "Тяжелая техника";
                default:
                    return "Неверный код транспортного средства - " + t;

            }
        }
// Метод определения типа дополнительного параметра по коду класса
    public  String TypeParameter(int t) {
        switch (t) {
            case 200:
                return "объем перевезенного груза Грузовой машины";
            case 300:
                return "число перевезенных пассажиров пассажирским транспортом";
            case 400:
                return "вес поднятых грузов тяжелой техникой";
            default:
                return "Неверный код транспортного средства - " + t;

        }
    }
// Метод определения стоимости топлива
    private  float whatFuelCost(int t) {
        switch (t) {
            case 100:
                return (float) 46.10;
            case 200:
                return (float) 48.90;
            case 300:
                return (float) 47.50;
            case 400:
                return (float) 48.90;
            default:
                return 0;

        }
    }

// Метод определения расхода топлива
    public  float whatFuelRate(int t) {
        switch (t) {
            case 100:
                return (float) 12.5;
            case 200:
                return (float) 12.0;
            case 300:
                return (float) 11.5;
            case 400:
                return (float) 20.0;
            default:
                return 0;

        }
    }

// Геттеры и сеттеры класса
    public int getCode_car() {
        return code_car;
    }

    public void setCode_car(int code_car) {
        this.code_car = code_car;
    }

    public int getNumber_car() {
        return number_car;
    }

    public void setNumber_car(int number_car) {
        this.number_car = number_car;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getDop_parameters() {
        return dop_parameters;
    }

    public void setDop_parameters(int dop_parameters) {
        this.dop_parameters = dop_parameters;
    }

}

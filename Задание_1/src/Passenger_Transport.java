// Класс пассажирский транспорт наследуемый от Авто
public class Passenger_Transport extends Auto {
    final String TypeAuto = "Пассажирский транспорт";
    final float FuelCost = (float) 47.50;
    final float FuelRate = (float) 11.5;
    final String TypeParameter = "число перевезенных пассажиров";
// Внутренный класс Builder
    public static class Builder{
        private int code_car;
        private int number_car;
        private int mileage;
        private int dop_parameters;

        public Builder(int code_car, int number_car, int mileage) {
            this.code_car = code_car;
            this.number_car = number_car;
            this.mileage = mileage;
        }
        public Passenger_Transport.Builder dop_parameters(int value){
            dop_parameters = value;
            return this;
        }
        public Passenger_Transport build(){
            return new Passenger_Transport(this);
        }
    }

// Конструктор для инициализации объекта Passenger_Transport
    private Passenger_Transport(Passenger_Transport.Builder builder){
        setCode_car(builder.code_car);
        setNumber_car(builder.number_car);
        setMileage(builder.mileage);
        setDop_parameters(builder.dop_parameters);
    }
// Метод расчета расходов на топливо пассажирского транспорта
    public  float CarConsumption(){
        // Расчет расходов на класс авто
        float CarConsumtion = (float) this.getMileage() / 100 * FuelRate * FuelCost;
        return CarConsumtion;
    }
// Геттеры
    public String getTypeAuto() {
        return TypeAuto;
    }

    public String getTypeParameter() {
        return TypeParameter;
    }
}

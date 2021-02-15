// Класс грузовые автомобили наследуемый от Авто
public class Truck extends Auto{
    final String TypeAuto = "Грузовая";
    final float FuelCost = (float) 48.90;
    final float FuelRate = (float) 12.0;
    final String TypeParameter = "объем перевезенного груза";
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
        public Builder dop_parameters(int value){
            dop_parameters = value;
            return this;
        }
        public Truck build(){
            return new Truck(this);
        }
    }

// Конструктор для инициализации объекта Truck
    private Truck (Truck.Builder builder){
        setCode_car(builder.code_car);
        setNumber_car(builder.number_car);
        setMileage(builder.mileage);
        setDop_parameters(builder.dop_parameters);
    }
// Метод расчета расходов на топливо грузовых автомобилей
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

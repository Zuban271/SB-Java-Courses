// Класс тяжелая техника наследуемый от Авто
public class Heavy_Vehicles extends Auto {
    final String TypeAuto = "Тяжелая техника";
    final float FuelCost = (float) 48.90;
    final float FuelRate = (float) 20.0;
    final String TypeParameter = "вес поднятых грузов";
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
        public Heavy_Vehicles.Builder dop_parameters(int value){
            dop_parameters = value;
            return this;
        }
        public Heavy_Vehicles build(){
            return new Heavy_Vehicles(this);
        }
    }

// Конструктор для инициализации объекта Heavy_Vehicles
    private Heavy_Vehicles(Heavy_Vehicles.Builder builder){
        setCode_car(builder.code_car);
        setNumber_car(builder.number_car);
        setMileage(builder.mileage);
        setDop_parameters(builder.dop_parameters);
    }
// Метод расчета расходов на топливо тяжелой техники
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

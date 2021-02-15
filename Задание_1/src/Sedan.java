// Класс Легковые автомобили наследуемый от Авто
public class Sedan extends Auto {
    final private String TypeAuto = "Легковая";
    final private float FuelCost = (float) 46.10;
    final private float FuelRate = (float) 12.5;
// Внутренный класс Builder
    public static class Builder{
        private int code_car;
        private int number_car;
        private int mileage;

        public Builder(int code_car, int number_car, int mileage) {
            this.code_car = code_car;
            this.number_car = number_car;
            this.mileage = mileage;
        }

        public Sedan build(){
            return new Sedan(this);
        }
    }

// Конструктор для инициализации объекта Sedan
    private Sedan (Sedan.Builder builder){
        setCode_car(builder.code_car);
        setNumber_car(builder.number_car);
        setMileage(builder.mileage);
    }
// Метод расчета расходов на топливо легковых автомобилей
    public  float CarConsumption(){

        float CarConsumtion = (float) this.getMileage() / 100 * FuelRate * FuelCost;
        return CarConsumtion;
    }
// Геттер
    public String getTypeAuto() {
        return TypeAuto;
    }
}

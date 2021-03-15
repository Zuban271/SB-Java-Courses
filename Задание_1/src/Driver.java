public class Driver {
    private String name;
    private int tariff;
    private float salary;
    private int code_car;
    private int number_car;

    public Driver(String name, int tariff,int code_car, int number_car) {
        this.name = name;
        this.tariff = tariff;
        this.code_car = code_car;
        this.number_car = number_car;
    }

    public String getName() {
        return name;
    }

    public int getTariff() {
        return tariff;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public int getCode_car() {
        return code_car;
    }

    public int getNumber_car() {
        return number_car;
    }
}

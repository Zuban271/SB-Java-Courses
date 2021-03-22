public class Main {
// Задание 5 потоки Задача 2 Разработать консольное приложение, которое эмулирует работу склада
    static final int InitialAmount = 10; // Кол-во товара, которое должно быть на складе
    static final int BuyAmount = 8;// Кол-во товара, которое покупатель выкупает за один цикл
    static int AmountProduct = 0; // Кол-во имеющегося товара на складе
    public static void main(String[] args) {
        Store store = new Store();

        for (int i = 0; i < 3; i++) {
            if (store.getProductList().size() > 0) {
                System.out.printf("кол-во оставшегося товара на складе= %d\n", store.getProductList().size());
                AmountProduct = store.getProductList().size();
            }
            // Поток 1 запускает поставщика товара
            Thread thread1 = new Thread(new Supply(store,InitialAmount,AmountProduct));
            // Поток 2 запускает покупателя
            Thread thread2 = new Thread(new Customer(store,BuyAmount));
           if (!thread1.isAlive())
                thread1.start();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!thread2.isAlive())
                thread2.start();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// класс покупателя
public class Customer implements Runnable{
private Store store;
private int BuyAmount;

    public Customer(Store store, int BuyAmount) {
        this.store = store;
        this.BuyAmount = BuyAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < BuyAmount; i++) {
            Product product = store.readProduct();
            if(product != null) {
                System.out.println("Выкуплен товар = " + product.getProduct() + " Осталось продукта на складе=" + (product.getAmount() -1));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

// Класс поставщика товара
public class Supply implements Runnable{
    private Store store;
    private int InitialAmount;
    private int AmountProduct;

    public Supply(Store store,int InitialAmount,int AmountProduct)
    {
        this.store = store;
        this.InitialAmount = InitialAmount;
        this.AmountProduct = AmountProduct;
    }

    @Override
    public void run() {
        for (int i = AmountProduct; i < InitialAmount; i++) {
            Product product = new Product("молоко",i + 1);
            store.addProduct(product);
            System.out.println("Кол-во поставленного товара= " + product.getAmount() + " " + product.getProduct());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

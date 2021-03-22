// класс продукт
public class Product {
    private String product;// наименование товара
    private Integer amount;// кол-во товара

    public Product(String product, int amount)
    {
        this.product = product;
        this.amount = amount;
    }

    public String getProduct()
    {

        return product;
    }

    public Integer getAmount() {
        return amount;
    }
}

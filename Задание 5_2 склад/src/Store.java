import java.util.ArrayList;
import java.util.List;
// класс магазин товаров
public class Store {
    private List<Product> productList;

    public Store() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product prod){
       productList.add(prod);
     }
     public Product readProduct(){
        if (productList.isEmpty()){
            return null;
        }
        else {
            return productList.remove(productList.size() - 1);
        }
     }

    public List<Product> getProductList() {
        return productList;
    }
}

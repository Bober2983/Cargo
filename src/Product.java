public class Product {
    private int id;
    private int id_shop;
    private String product;

    public Product(int id, int id_shop, String product) {
        this.id = id;
        this.id_shop = id_shop;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getId_shop() {
        return id_shop;
    }

    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }

}

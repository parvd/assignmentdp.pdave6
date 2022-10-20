
public class Seller extends Person {

    public Seller(ProductMenu productmenu) {
        super(productmenu);
    }

    @Override
    public void showMenu() {}

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }

}


public class Seller extends Person {

    public Seller(MeatProductMenu productmenu) {
        super(productmenu);
    }

    @Override
    public void showMenu() {}

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }

}

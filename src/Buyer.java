
public class Buyer extends Person
{
    public Buyer(ProductMenu productmenu) {
        super(productmenu);
    }

    @Override
    public void showMenu(){}

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }
}


public class Buyer extends Person
{
    public Buyer(ProductMenu productmenu) {
        super(productmenu);
    }

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }
    @Override
    public void showMenu(){}

}

public class ProductFactory {
    public ProductMenu getProductType(String productVal)
    {
        if(productVal == null)
        {
            return null;
        }
        if(productVal.equalsIgnoreCase("ProduceProduct"))
        {
            return new ProduceProductMenu();
        }
        if(productVal.equalsIgnoreCase("MeatProduct"))
        {
            return new MeatProductMenu();
        }
        return null;
    }

}
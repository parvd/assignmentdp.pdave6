
public abstract class Person
{
    protected ProductMenu p;

    ProductMenu theProductMenu;


    public Person(ProductMenu productmenu) {
    }

    public abstract void showMenu();

    public void add()
    {
        System.out.print("\nAdding to the ProductMenu.");
    }

    public void showAddButton()
    {
        System.out.print("\nShowing Add Button!");
    }

    public void showViewButton()
    {
        System.out.print("\nShowing View Button!");
    }

    public void showRadioButton()
    {
        System.out.print("\nShowing Radio Button!");
    }


    public abstract ProductMenu CreateProductMenu();
}

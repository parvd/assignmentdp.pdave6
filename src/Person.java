public abstract class Person
{
    protected ProductMenu p;

    ProductMenu theProductMenu;


    public Person(MeatProductMenu productmenu) {
    }

    public abstract void showMenu();

    public void add()
    {
        System.out.print("\n Adding to the ProductMenu.");
    }

    public void showAddButton()
    {
        System.out.print("\n Displaying Add Button!");
    }

    public void showViewButton()
    {
        System.out.print("\n Displaying View Button!");
    }

    public void showRadioButton()
    {
        System.out.print("\n Displaying Radio Button!");
    }


    public abstract ProductMenu CreateProductMenu();
}

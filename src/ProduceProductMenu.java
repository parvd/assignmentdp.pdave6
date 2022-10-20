

public class ProduceProductMenu implements ProductMenu{

    @Override
    public void showMenu() {
        System.out.print("\n Displaying the Meat product menu!");
    }

    @Override
    public void showAddButton() {
        System.out.print("\nDisplaying Add Button");
    }

    @Override
    public void showViewButton() {
        System.out.print("\n Displaying View Button");
    }

    @Override
    public void showRadioButton() {
        System.out.print("\n Displaying radio button!");
    }

    @Override
    public void showLabels() {
        System.out.print("\n Displaying labels!");	}

    @Override
    public void showComboxes() {
        System.out.print("\n Displaying comboxes!");
    }

}

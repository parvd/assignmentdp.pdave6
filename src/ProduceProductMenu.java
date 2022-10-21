

public class ProduceProductMenu implements ProductMenu{
    @Override
    public void showMenu() {
        System.out.print("\nShowing the Produce product menu!");
    }

    @Override
    public void showAddButton() {
        System.out.print("\nShowing Produce product Add Button");
    }

    @Override
    public void showViewButton() {
        System.out.print("\nShowing Produce product View Button");
    }

    @Override
    public void showRadioButton() {
        System.out.print("\nShowing Produce product radio button!");
    }
    @Override
    public void showLabels() {
        System.out.print("\nShowing Produce product labels!");	}
    @Override
    public void showComboxes() {
        System.out.print("\nShowing Produce product comboxes!");
    }

}


public class Reminder extends NodeVisitor
{
    @Override
    public void visitProduct(ReminderVisitor visitor)
    {
        System.out.print("\nVisited the Product");
    }

    @Override
    public void visitTrading(ReminderVisitor visitor) {
        System.out.print("\nVisited the Trading");
    }

    @Override
    public void visitFacade(Facade facade) {
        System.out.print("\nVisited from Facade class");
    }

}

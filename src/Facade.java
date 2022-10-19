import java.util.*;
import java.io.File;
import java.io.IOException;
public class Facade {

    ArrayList<String>flag_val = new ArrayList<String>();
    ArrayList<String>string_val = new ArrayList<String>();
    ArrayList<String>Lists = new ArrayList<String>();
    ArrayList<Integer>Type = new ArrayList<>();
    UserCred cred = new UserCred();

    private LoginDec person;
    public Facade() throws IOException
    {
        DataBase();
        createProductList();
        person = new Login();
    }

    public void DataBase() throws IOException
    {
        File db = new File("src\\dataBase");
        if(db.createNewFile()){}
        else{}
    }

    public void login() throws IOException
    {
        System.out.print("\n"+"FACADE PATTERN is implemented here"+"\n");
        cred = person.loginMethod();
    }

    public void addTrading()
    {
        System.out.println(" addTrading ");
    }

    public void viewTrading()
    {
        System.out.println(" viewTrading ");
    }

    public void decideproduct()
    {
        System.out.println(" decideproduct ");
    }

    public void discussBidding()
    {
        System.out.println(" discussBidding ");
    }
    public void submitBidding()
    {
        System.out.println(" submitBidding ");
    }

    public void remind()
    {
        System.out.println(" remind ");
    }

    public void createProductList()
    {
        System.out.println(" createProductList ");
    }


    public void selectProduct()
    {
        System.out.println(" selectProduct ");
    }

    public void productOperation()
    {
        System.out.println(" productOperation ");
    }

    public void attachProductToUser()
    {
        System.out.println(" attachProductToUser ");
    }

}
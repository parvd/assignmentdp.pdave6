
import java.io.*;
import java.util.*;

public class Login implements LoginDec
{
    ArrayList<String>buyer_name = new ArrayList<>();
    ArrayList<String>buyer_password = new ArrayList<>();
    ArrayList<String>seller_name = new ArrayList<> ();
    ArrayList<String>seller_password = new ArrayList<>();



    @SuppressWarnings({ "resource", "unused" })
    @Override
    public UserCred loginMethod() throws IOException {

        UserCred user = new UserCred();

        File file = new File("src\\BuyerInfo");
        BufferedReader br = new BufferedReader(new FileReader(file));

        File file1 = new File("src\\SellerInfo");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));

        String str;

        boolean allow_user = true;
        boolean has_buyer=false;
        boolean has_seller = false;

        while((str = br.readLine())!=null)
        {
            String [] buyers = str.split(":");
            buyer_name.add(buyers[0]);
            buyer_password.add(buyers[1]);
        }

        while((str = br1.readLine())!=null)
        {
            String[] sellers = str.split(":");
            seller_name.add(sellers[0]);
            seller_password.add(sellers[1]);
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter Your Username : ");
        String u_name = scanner1.next();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Your Password : ");
        String passwd = scanner2.next();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("\n"+ "Note: Value for Buyer is 0 and Value for Seller is 1  :"+"Enter the  type of user");
        int u_type = scanner3.nextInt();

        user.userName = u_name;
        user.userType = u_type;

        for(int i=0;i<buyer_name.size();i++)
        {
            if(u_name.equals(buyer_name.get(i)) && passwd.equals(buyer_password.get(i)))
            {
                has_buyer = true;
            }
        }

        for(int i=0;i<seller_name.size();i++)
        {
            if(u_name.equals(seller_name.get(i)) && passwd.equals(seller_password.get(i)))
            {
                has_seller = true;
            }
        }


        if(u_type == 0)
        {
            if(has_buyer == true)
            {
                System.out.print("\n The User Entered is : Buyer");
            }
            else
            {
                System.out.print("\n User with entered credentials does not exist!");
                System.exit(0);
            }
            Person buyer = new Buyer(new MeatProductMenu());
            System.out.print("\n"+"BRIDGE PATTERN is implemented here"+"\n");
            buyer.add();
            buyer.showMenu();
        }
        else if(u_type == 1)
        {
            if(has_seller == true)
            {
                System.out.print("\n The User Entered is : Seller");
            }
            else
            {
                System.out.print("\n User with entered credentials does not exist!");
                allow_user = false;
                System.exit(0);
            }
            Person seller = new Seller(new MeatProductMenu());
            System.out.print("\n"+"BRIDGE PATTERN is implemented here"+"\n");
            seller.showMenu();
        }
        return user;
    }
}
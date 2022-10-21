
import java.io.*;
import java.util.*;

public class Login implements LoginDec
{
    ArrayList<String>b_name = new ArrayList<>();
    ArrayList<String>b_password = new ArrayList<>();
    ArrayList<String>s_name = new ArrayList<> ();
    ArrayList<String>s_password = new ArrayList<>();
    String str;
    boolean flag = true;
    boolean is_b=false;
    boolean is_s = false;


    // Function for user login
    @SuppressWarnings({ "resource", "unused" })
    @Override
    public DataUser loginMethod() throws IOException {

        DataUser user = new DataUser();

        File file = new File("src\\BuyerInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        File file1 = new File("src\\SellerInfo.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(file1));


        while((str = br.readLine())!=null)
        {
            String [] buyers = str.split(":");
            b_name.add(buyers[0]);
            b_password.add(buyers[1]);
        }

        while((str = br1.readLine())!=null)
        {
            String[] sellers = str.split(":");
            s_name.add(sellers[0]);
            s_password.add(sellers[1]);
        }

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter Your Username : ");
        String u_name = scanner1.next();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Your Password : ");
        String passwd = scanner2.next();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("\n"+ "Note: Input for Buyer is 0 and for Seller is 1 \n"+"Enter the  type of user");
        int u_type = scanner3.nextInt();

        user.userName = u_name;
        user.userType = u_type;

        for(int i=0;i<b_name.size();i++)
        {
            if(u_name.equals(b_name.get(i)) && passwd.equals(b_password.get(i)))
            {
                is_b = true;
            }
        }

        for(int i=0;i<s_name.size();i++)
        {
            if(u_name.equals(s_name.get(i)) && passwd.equals(s_password.get(i)))
            {
                is_s = true;
            }
        }


        if(u_type == 0)
        {
            if(is_b == true)
            {
                System.out.print("\nThe User Entered is : Buyer");
            }
            else
            {
                System.out.print("\nUser with entered credentials does not exist!");
                System.exit(0);
            }
            Person buyer = new Buyer(new MeatProductMenu());
            System.out.print("\n"+"Bridge Pattern is Done"+"\n");
            buyer.add();
            buyer.showMenu();
        }
        else if(u_type == 1)
        {
            if(is_s == true)
            {
                System.out.print("\n The User Entered is : Seller");
            }
            else
            {
                System.out.print("\nWrong credentials!");
                flag = false;
                System.exit(0);
            }
            Person seller = new Seller(new MeatProductMenu());
            System.out.print("\n"+"Bridge Pattern is Done"+"\n");
            seller.showMenu();
        }
        return user;
    }
}
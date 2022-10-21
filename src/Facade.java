
import java.io.*;
import java.util.*;

public class Facade {

    ArrayList<String>temp1 = new ArrayList<String>();
    ArrayList<String>temp2 = new ArrayList<String>();
    ArrayList<String>ProductList = new ArrayList<String>();
    ArrayList<Integer>ValueType = new ArrayList<>();
    DataUser cred = new DataUser();


    private LoginDec person;
    // Constructor for Facade
    public Facade() throws IOException
    {
        DataBase();
        createProductList();
        person = new Login();
    }
    // Initialise DataBase
    public void DataBase() throws IOException
    {
        File db = new File("src\\dataBase");
        if(db.createNewFile()){}
        else{}
    }

    // Function for creating Product List

    @SuppressWarnings("resource")
    public void createProductList() throws IOException {
        System.out.println("createProductList ");
        File file = new File("src\\ProductInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;

        while((str = br.readLine())!=null)
        {
//          ProductList.add(str);
            String seperate[]=str.split(":");
            ValueType.add((seperate[0].equals("Meat"))?0:1);
            ProductList.add(seperate[1]);
        }
        System.out.println("\nProductList = "+ProductList);
        System.out.println("\nValueType = "+ValueType);
    }

    //Here we call login in Facade
    public void login() throws IOException
    {
        System.out.print("\n"+"Facade Pattern Done"+"\n");
        cred = person.loginMethod();
    }

    //Here addTrading function adds trading logic
    public void addTrading(String user_name, int user_type, String product_name) throws IOException
    {
        System.out.println("\n Inside addTrading \n");
        int bid_val = decideBidding(user_type);
        if(user_type == 0)
        {
            boolean final_bid = discussBidding();
            if(final_bid)
            {
                System.out.print("\nThe bid is accepted");
                submitOffering(user_name, user_type, product_name, bid_val);
            }
            else
            {
                System.out.print("\nThe bid is not accepted");
            }
        }
        else
        {
            System.out.print("\n The root value is added for bidding");
            submitOffering(user_name, user_type, product_name, bid_val);
        }
    }

    //here viewTrading fucntion uses for displaying trade from user
    public void viewTrading() throws IOException {
        System.out.println("Inside viewTrading");
        File file = new File("src\\dataBase");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String>user_names = new ArrayList<>();
        ArrayList<Integer>user_types = new ArrayList<>();
        ArrayList<String>product_names = new ArrayList<>();
        ArrayList<Integer>entered_bids = new ArrayList<>();

        String s;

        while((s = br.readLine())!=null)
        {
            System.out.print(s);
            String[] lines = s.split("---");
            System.out.println(lines);
        }

        System.out.print("\n Trading for the  "+((cred.userType == 0)?" Buyer":" Seller"));
        System.out.print("\n User 	\t Product	 \t Bid");
        if(cred.userType == 0)
        {
            for(int i=0;i<product_names.size();i++)
            {
                if(user_types.get(i) == 0)
                {
                    System.out.print("\n "+user_names.get(i)+"\t"+product_names.get(i)+"\t"+entered_bids.get(i));
                }
            }
        }
        else
        {
            for(int i=0;i<product_names.size();i++)
            {
                if(user_types.get(i) == 1)
                {
                    System.out.print("\n "+user_names.get(i)+"\t"+product_names.get(i)+"\t"+entered_bids.get(i));
                }
            }
        }
    }
    //Here user role is decided and respective class is invoke
    @SuppressWarnings("resource")
    public int decideBidding(int userType)
    {
        System.out.println("\nInside decideBidding \n");
        Scanner scanner = new Scanner(System.in);
        int price_bid = 0;
        switch(userType)
        {
            case 0:
                System.out.print("\n Buyer Setting Enabled: ");
                System.out.print("\n Enter the bid value: ");
                price_bid = scanner.nextInt();
                break;
            case 1:
                System.out.print("\n Seller Setting Enabled: ");
                System.out.print("\n Enter the Final Price product bidding :");
                price_bid = scanner .nextInt();
                break;
        }
        return price_bid;
    }

    // Function for confirming Bid
    public boolean discussBidding()
    {
        System.out.println("Inside discussBidding");
        boolean let = true;
        System.out.print("\nMark the Bidding? Enter yes or no : \n");
        Scanner scanner = new Scanner(System.in);
        String v = scanner.nextLine();
        if(v.equalsIgnoreCase("NO"))
        {
            let = false;
        }
        else if(v.equalsIgnoreCase("YES"))
        {
            let = true;
        }
        else{
            System.out.println("\n Invalid Inputs\nExit Application \n");
            System.exit(0);
        }
        return let;
    }
    // Function for submitOffering
    public void submitOffering(String user_name, int user_type, String product_name, int bidval) throws IOException {
        System.out.println("\nInside submitBidding\n");
        FileWriter fw = new FileWriter("src\\dataBase",true);
        String s = "\n"+user_name+"---"+Integer.toString(user_type)+"---"+product_name+"---"+Integer.toString(bidval);
        fw.flush();
        fw.write(s);
        fw.close();
    }

    // Function for remind
    public void remind()
    {
        System.out.println("\nremind\n");
    }

    // Function for selectProduct
    public void selectProduct()
    {
        System.out.println("\nselectProduct\n");
    }

    // Function for productOperation
    public void productOperation()
    {
        System.out.println("\n productOperation \n");
    }

    // Function for creating a pair of product with user
    public void attachProductToUser() throws IOException {
        System.out.println("\n Inside attachProductToUser\n ");
        File file = new File("src\\UserProduct.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            String[] b = str.split(":");
            System.out.println("" + b[0]+" "+b[1]);
            temp1.add(b[0]);
            temp2.add(b[1]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Enter type of product (enter numeric value from above list): ");
        int product = scanner.nextInt();
        decideproduct(ProductList.get(product-1));
        System.out.print("\n Choose option of trading from: ");
        System.out.print("\n 1)Add Trading");
        System.out.println("\n 2)View Trading");
        int tradingtype = scanner.nextInt();

        int nProductCategory=ValueType.get(product-1);
        System.out.println(ProductList.get(product-1));
        if(tradingtype == 1)
        {
            ProductFactory f = new ProductFactory();
            if(nProductCategory == 0)
            {
                ProductMenu p = f.getProductType("MeatProduct");
                p.showAddButton();
                addTrading(cred.userName, cred.userType, ProductList.get(product-1));
            }
            else if(nProductCategory == 1)
            {
                ProductMenu p1 = f.getProductType("ProduceProduct");
                p1.showAddButton();
                addTrading(cred.userName, cred.userType, ProductList.get(product-1));
            }
        }
        else if(tradingtype == 2)
        {
            ProductFactory f1 = new ProductFactory();
            if(nProductCategory == 0)
            {
                ProductMenu p = f1.getProductType("MeatProduct");
                System.out.println("\n"+"MeatProduct class is called by Factory Design");
                p.showViewButton();
                viewTrading();
            }
            else if(nProductCategory == 1)
            {
                ProductMenu p1 = f1.getProductType("ProduceProduct");
                System.out.println("\n"+"ProduceProduct class is called by Factory Design");
                p1.showViewButton();
                viewTrading();
            }
        }

    }

    // Here selected product is displayed
    public void decideproduct(String product)
    {
        System.out.println(" Your selected product is "+product);
    }
}
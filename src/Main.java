import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException{
        boolean val = true;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while(val){
            Facade facade = new Facade();
            facade.login();

            ProductIterator pi = new ProductIterator();
            System.out.println("In Main productorIterator = "+pi.product);

            System.out.print("\n"+"Iterator Pattern Done");

            System.out.print("\nSelect the Product from below: :");

            ListIterator it;
            int i=1;

            for(it = pi.getIterator();it.hasNext();)
            {
                String product = (String)it.next();
                System.out.print("\n"+i+") "+product);
                i+=1;
            }
            facade.attachProductToUser();

            System.out.print("\n"+"Iterator Pattern Done");
            NodeVisitor vis = new Reminder();

            vis.visitProduct(new ClassProductList());
            vis.visitTrading(new ClassProductList());

            System.out.print("\nNote: Press 1 to login again or Press 2 for exiting\n");
            int options = scanner.nextInt();

            switch(options)
            {
                case 1:
                    break;

                case 2:
                    System.out.print("\nSystem Closed!");
                    System.exit(0);
                    break;

            }
        }

    }
}
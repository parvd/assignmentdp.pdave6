import java.io.*;
import java.util.ArrayList;
public class ProductIterator extends ArrayList{

    ArrayList<String> product = new ArrayList<String>();

    public ProductIterator() throws IOException
    {
        File file = new File("src\\ProductInfo.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while((str = br.readLine()) != null)
        {
            product.add(str);
        }
        System.out.println("\nhere ProductIterartor = "+product+"\n");
        br.close();
    }
    private class Product implements ListIterator
    {
        int m;
        @Override
        public boolean hasNext() {
            if(m<product.size())
            {
                return true;
            }
            return false;
        }
        @Override
        public Object next() {
            if(this.hasNext())
            {
                return product.get(m++);
            }
            return null;
        }

    }

    public boolean hasNext() {
        return false;

    }

    public ListIterator getIterator() {
        return new Product();
    }

}
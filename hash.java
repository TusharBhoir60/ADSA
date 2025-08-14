import java.util.*;
public class hash{
    public static int hasing(String key){
        int hashtable = 10;
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i); //takes char value at each index
            hash += (int)ch;  //Converts char value to ascii value and adds it to hash variable
        }
        return hash%hashtable;  //reminder after dividing by hastable value 
    }
        // main code
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
            System.out.print("Enter characters:");
        String inp = sc.nextLine();
        int hash =  hasing(inp);
            System.out.println("After hashing " + hash);
        sc.close();
    }
}



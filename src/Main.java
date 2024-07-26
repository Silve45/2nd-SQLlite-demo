import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String check;

        while (true){
            System.out.println("What would you like to Do?" +
                    "\nSee all items in the Database (A)" +
                    "\nSelect items in the Database (S)" +
                    "\nInsert Item into Database (I)" +
                    "\nDelete Item from Database (D)" +
                    "\nExit (E)");
            check = sc.next();
            if (check.equalsIgnoreCase("a")){
                    Connect.Names();
                    System.out.println();// just to make a new line
                    continue;
            }
            else if(check.equalsIgnoreCase("s")){
                    Connect.Access();
                    System.out.println();// just to make a new line
                    continue;
            }
            else if (check.equalsIgnoreCase("i")){
                    Connect.Insert();
                    System.out.println();// just to make a new line
                    continue;
            }
            else if (check.equalsIgnoreCase("d")){
                    Connect.Delete();
                    System.out.println();// just to make a new line
                    continue;
            }
            else if (check.equalsIgnoreCase("e")){
                     System.out.println("Exiting Program");
                     break;
            }
            else {
                System.out.println("Please use already defined syntax\n");
                continue;
            }


        }//end While

    }// end psvm
}//end Main Class


import java.util.Scanner;

public class InteractRunner{

    public static void main(String[] arg) (
            Scanner reader = new Scanner(System.in);
    try  {
        Calculator calc = new Calculator();
        String exit = "no";
        while (!exit.equals("yes"))
        {
            System.out.println("enter arg1");
            String first = reader.next();
            System.out.println("enter arg2");
            String second = reader.next();
            calc.add(Integer.valueOf(first), Integer.valueOf(second));
            System.out.println("res" + calc.getResult());
            calc.cleanResult();
            System.out.println("exit yes no");
            exit = reader.next();

        }
    }
    finally {
            reader.close();
        }

}
}
import java.lang.String;
import java.lang.System;

public class beer{
    public static void main (String[]args){
        int beerNum = 99;
        String word = "butilok (butilki)";
        while (beerNum>0){
            if (beerNum% 10==1)
            {
                word="butilka";
            }
         else
            {
                if ( (beerNum!=12 && beerNum!=13 && beerNum!=14 && beerNum!=11) && (beerNum % 10 == 2 || beerNum % 10 == 3 || beerNum % 10 == 4) )
                {
                    word = "butilkI";
                } else
                {
                    word = "butilok ";
                }
            }
            System.out.println(beerNum+" "+ word+ " beer on table");
            System.out.println(beerNum+" "+ word+ " beer");
            System.out.println("TAKE ONE");
            System.out.println("MAKE IT ROUND");
            beerNum=beerNum-1;



            if (beerNum==0)
                {
                    System.out.println("NOOOOOOO beer on table");
                }

        }
    }
}
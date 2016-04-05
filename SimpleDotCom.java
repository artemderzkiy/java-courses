import java.lang.Integer;
import java.lang.String;

public class SimpleDotCom {
    int [] locationCells;
    int numOfHits=0;

    public void setLocationCells(int [] locs){
        locationCells=locs;
    }

   public String checkYourself(String stringGuess){
       int guess = Integer.parseInt(stringGuess);
       String result = "Мимо";
       for (int cell : locationCells){
           if (guess==cell){
               result="попал";
                       numOfHits++;
               break;
           }
       }
       if (numOfHits==locationCells.length)
           result="POTOPIL";
                   System.out.println(result);
       return result;
   }

}
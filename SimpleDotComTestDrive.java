import java.lang.System

public class SimpleDotComTestDrive{
    public static  void main(String[] args){
        SimpleDotCom dot = new SimpleDotCom();
        int[] locacations = {2,3,4};
        dot.setLocationCells(locacations);
        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
         userGuess = "3";
         result = dot.checkYourself(userGuess);
         userGuess = "4";
        result = dot.checkYourself(userGuess);

    }
}
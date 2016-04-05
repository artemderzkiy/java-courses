import java.lang.String;
import java.lang.System;

public class SimpleDotComGame {
    public static void main(String[] args)
    {
        //System.out.print("TEST");
        int numOfGuess=0;
        GameHelper helper = new GameHelper();
        SimpleDotCom theDotCom = new SimpleDotCom();
        int randomNum = (int)(Math.random()*5);
        int[] locations = {randomNum,randomNum+1,randomNum+2};
        theDotCom.setLocationCells(locations);
        boolean isAlive=true;
        while (isAlive!=true){
            String guess = helper.getUserInput("VVEDITE CHISLO");
            String result = theDotCom.checkYourself(guess);
            numOfGuess++;
            if (result.equals("POTOPIL")){
                isAlive=false;
                System.out.println("VAM NUZHNO BILO "+ numOfGuess + " POPITOK");
            }
        }
    }
}
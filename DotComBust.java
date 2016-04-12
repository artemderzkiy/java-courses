import java.lang.String;
import java.lang.System;

import java.util.ArrayList;


public class DotComBust
{
  private  GameHelper helper = new GameHelper();
  private  ArrayList <DotCom> dotComList = new ArrayList<DotCom>();
  private  int numOfGuesses = 0;

   private void setUpGame()
   {
     DotCom ob1 = new DotCom();
       ob1.setName("Sobaka.com");
       DotCom ob2 = new DotCom();
       ob2.setName("govno.com");
       DotCom ob3 = new DotCom();
       ob3.setName("ukushuka.ru");
       dotComList.add(ob1);
       dotComList.add(ob2);
       dotComList.add(ob3);

       System.out.println("VASHA CEL POTOPIT TRI SAITA");

       for (DotCom dotComToSet : dotComList)
       {
           ArrayList<String> newLocation = helper.placeDotCom(3);
           dotComToSet.setLocationCells(newLocation);
       }
   }

   private void startPlaying()
    {
        while (dotComList.isEmpty()==false)
        {
            String userGuess = helper.getUserInput("HOD PLEASE");
            checkUserGuess(userGuess);

        }
        finishGame();
    }
    private void checkUserGuess(String userGuess)
    {
        numOfGuesses++;
        String result = "MIMO NAHUI";
        for (DotCom dotComToCheck : dotComList)
        {

            result=dotComToCheck.checkYourself(userGuess);
            if (result.equals("POPAL"))
                break;
            if (result.equals("POTOPIL"))
            {
                dotComList.remove(dotComToCheck);
                break;
            }
            System.out.println(result);
        }
    }

    void finishGame()
    {
        System.out.println("KONEC EPTA");
        if (numOfGuesses<=18)
            System.out.println(numOfGuesses + "       MOLODEC EBAT");
        else
            System.out.println(numOfGuesses + "       EBAT TI LOH");
    }

    public static void main (String[] args){
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
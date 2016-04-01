import java.lang.String;
import java.lang.System;

public class generator{
    public static void main(String[] args){
        String[] wordone = {"polniy","uzhasniy","ebanutiy","stremniy","trehfazniy","samopishushiy"};
        String[] wordtwo = {"zhirniy","vonuchiy","umniy","nikudishniy","obshiy"};
        String[] wordthree = {"dom","prepod","rabotnik","PUTIN"};

        int random1 = (int)(Math.random()*wordone.length);
        int random2 = (int)(Math.random()*wordtwo.length);
        int random3 = (int)(Math.random()*wordthree.length);

        String phrase = wordone[random1]+" "+wordtwo[random2]+" "+wordthree[random3];
        System.out.println("VSE CHTO NADO " + phrase );

    }
}
package com.example.raj.courseworkapp_1541065;

import java.util.Random;

/**
 * Created by raj on 5/14/2016.
 */
public class QuestionMaker {

    public MathGameData makeQuestion(Integer level, Integer mathType){
        MathGameData mathGameData = new MathGameData();



        if(level == 1){
            levelOneQuestion(mathGameData, mathType);
        }else if(level == 2){
            levelTwoQuestion(mathGameData, mathType);
        }
        return mathGameData;
    }

    private void levelOneQuestion(MathGameData mathGameData, Integer mathType){


        Random rn = new Random();
        mathGameData.setNumberOne(rn.nextInt(10));
        mathGameData.setNumberTwo(rn.nextInt(10));


        if(mathType.equals(1)){
            mathGameData.setResult(mathGameData.getNumberOne() + mathGameData.getNumberTwo());
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " + " + mathGameData.getNumberTwo());
        }else if(mathType.equals(2)){
            mathGameData.setResult(mathGameData.getNumberOne() - mathGameData.getNumberTwo());
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " - " + mathGameData.getNumberTwo());
        }else if(mathType.equals(3)){
            mathGameData.setResult(mathGameData.getNumberOne() * mathGameData.getNumberTwo());
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " * " + mathGameData.getNumberTwo());
        }else if(mathType.equals(4)){
            mathGameData.setResult(mathGameData.getNumberOne() / mathGameData.getNumberTwo());
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " / " + mathGameData.getNumberTwo());
        }

        Integer[] answer = new Integer[4];
        Integer i  = rn.nextInt(3);
        Integer j = 4;
        Integer itt = i;
        while(i < j){

            if(i == itt){
                answer[i] = mathGameData.getResult();
            }else{
                if(mathType.equals(1)){
                    answer[i] = rn.nextInt(20);
                }else if(mathType.equals(2)){
                    answer[i] = rn.nextInt(20);
                }else if(mathType.equals(3)){
                    answer[i] = rn.nextInt(20);
                }else if(mathType.equals(4)){
                    answer[i] = rn.nextInt(20);
                }
            }

            if(i == 3){
                i = 0;
                j = itt;
            }else{
                i++;
            }
        }

        for(int a=0;a<4;a++){

            if(a == 0){
                mathGameData.setOption1(answer[a]);
            }else if(a == 1){
                mathGameData.setOption2(answer[a]);
            }else if(a == 2){
                mathGameData.setOption3(answer[a]);
            }else if(a == 3){
                mathGameData.setOption4(answer[a]);
            }
        }


    }

    private void levelTwoQuestion(MathGameData mathGameData, Integer mathType){


        Random rn = new Random();
        mathGameData.setNumberOne(rn.nextInt(10));
        mathGameData.setNumberTwo(rn.nextInt(10));



        if(mathType.equals(1)){
            mathGameData.setResult(mathGameData.getNumberTwo());
            Integer result = mathGameData.getNumberTwo() + mathGameData.getNumberOne();
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " + " + "? = " + result);

        }else if(mathType.equals(2)){
            Integer result = mathGameData.getNumberTwo() - mathGameData.getNumberOne();
            mathGameData.setResult(mathGameData.getNumberTwo());
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " - " + " ? = " + result);
        }else if(mathType.equals(3)){
            Integer result = mathGameData.getNumberTwo() * mathGameData.getNumberOne();
            mathGameData.setResult(mathGameData.getNumberTwo());
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " * " + "? = " + result);
        }else if(mathType.equals(4)){
            Integer result = mathGameData.getNumberOne() / mathGameData.getNumberTwo();
            mathGameData.setResult(mathGameData.getNumberTwo());
            mathGameData.setDisplayString(mathGameData.getNumberOne() + " / " + "? = " + result);
        }

        Integer[] answer = new Integer[4];
        Integer i  = rn.nextInt(3);
        Integer j = 4;
        Integer itt = i;
        while(i < j){

            if(i == itt){
                answer[i] = mathGameData.getResult();
            }else{
                if(mathType.equals(1)){
                    answer[i] = rn.nextInt(10) + rn.nextInt(10);
                }else if(mathType.equals(2)){
                    answer[i] = rn.nextInt(10) - rn.nextInt(10);
                }else if(mathType.equals(3)){
                    answer[i] = rn.nextInt(10) * rn.nextInt(10);
                }else if(mathType.equals(4)){
                    answer[i] = rn.nextInt(10) / rn.nextInt(10);
                }
            }

            if(i == 3){
                i = 0;
                j = itt;
            }else{
                i++;
            }
        }

        for(int a=0;a<4;a++){

            if(a == 0){
                mathGameData.setOption1(answer[a]);
            }else if(a == 1){
                mathGameData.setOption2(answer[a]);
            }else if(a == 2){
                mathGameData.setOption3(answer[a]);
            }else if(a == 3){
                mathGameData.setOption4(answer[a]);
            }
        }


    }


}

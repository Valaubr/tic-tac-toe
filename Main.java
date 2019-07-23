package com.company.ru.test;

import java.util.Scanner;

public class Main {
    public static int turn = 2;
    public static void main(String[] args) {
        String [][] theGame = startGame();

        Scanner scanner = new Scanner(System.in);
        while (true){
            int first = scanner.nextInt();
            int twelf = scanner.nextInt();
            try {
                if (turn < 10){
                    if (turn % 2 == 0){
                        turn += 1;
                        setX(theGame, first, twelf);
                    } else {
                        turn += 1;
                        setY(theGame, first, twelf);
                    }
                } else {
                    break;
                }
            } catch (Exception e){
                System.out.println("Вы ввели недопустимые параметры! Попробуйте снова!");
                turn -= 1;
                continue;
            } //if (first > 2 || twelf > 2 || first < 0|| twelf < )

        }
        draw(theGame);
        System.out.println("Тупик, игра окончена!");
    }

    public static String[][] startGame(){
        String map[][];
        map = new String[3][3];
        for (int i = 0; i < 3; i++){
            map[i][0] = "-";
            for (int j = 0; j < 3; j++){
                map[i][j] = "-";
                System.out.print(map[i][j] + "    ");
            }
            System.out.println("\n");
        }
        return map;
    }

    public static void draw(String[][] theGame){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(theGame[i][j] + "    ");
            }
            System.out.println("\n");
        }
    }

    public static String[][] setX(String[][] theGame, int first, int twelf){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                theGame[first][twelf] = "X";
            }
        }
        draw(theGame);
        checkWin(theGame);
        return theGame;
    }

    public static String[][] setY(String[][] theGame, int first, int twelf){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                theGame[first][twelf] = "Y";
            }
        }
        draw(theGame);
        checkWin(theGame);
        return theGame;
    }

    public static void checkWin(String[][] theGame){
        if (theGame[0][0] == theGame[1][1] && theGame[0][0] == theGame[2][2] && theGame[0][0] != "-" || //диагонали
                theGame[0][2] == theGame[1][1] && theGame[0][2] == theGame[2][0] && theGame[0][2] != "-" ||

                theGame[0][0] == theGame[0][1] && theGame[0][0] == theGame[0][2] && theGame[0][0] != "-" ||//вертикали
                theGame[1][0] == theGame[1][1] && theGame[1][0] == theGame[1][2] && theGame[1][0] != "-" ||
                theGame[2][0] == theGame[2][1] && theGame[2][0] == theGame[2][2] && theGame[2][0] != "-" ||

                theGame[0][0] == theGame[1][0] && theGame[0][0] == theGame[2][0] && theGame[0][0] != "-" ||//горизонтали
                theGame[0][1] == theGame[1][1] && theGame[0][1] == theGame[2][1] && theGame[0][1] != "-" ||
                theGame[0][2] == theGame[1][2] && theGame[0][2] == theGame[2][2] && theGame[0][2] != "-"){

            if (turn % 2 == 1){ // мы сначала увеличиваем переменную turn в связи с чем ход игрока 1 уже не чётный
                System.out.println("Победил игрок 1!");
            } else {
                System.out.println("Победил игрок 2!");
            }
        }
    }
}

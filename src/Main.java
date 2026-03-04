import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner Number = new Scanner(System.in);

        System.out.println("Привет в веселой игре\nПопробуй угадать все числа которые я загадаю!");


        System.out.println("1.Начать игру\n0.Выйти");
        int menu = Number.nextInt();

        switch (menu){
            case 1:
                Game();
        }

    }
    public static void Game(){
        Random randomNumber = new Random();
        Scanner guesserNumber = new Scanner(System.in);

        int number = randomNumber.nextInt(100) + 1;


        while (true){
            System.out.println("Угадай число!:");
            int guesser = guesserNumber.nextInt();
            if(guesser == number){
                System.out.println("Поздравляю! Ты угадал");
                break;
            } else if (guesser < number) {
                System.out.println("Число которое я загадал больше!");
            }else{
                System.out.println("Число которое я загадал меньше!");
            }
        }
    }
}
// To-do
// сделать полную игру которая заканчивается только при кнопке выхода


import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;



public class Main {
    private static final Path FILE_PATH = Path.of("StatisticFile.txt");
    public static void main(String[] args) throws IOException {
        InitializationFile();
        Scanner Number = new Scanner(System.in);

        System.out.println("Привет в веселой игре\nПопробуй угадать все числа которые я загадаю!");

        while (true) {
            System.out.println("\n1.Начать игру\n2.Статистика\n0.Выйти");
            int menu = Number.nextInt();

            switch (menu) {
                case 1:
                    Game();
                    break;

                case 2:
                    showStatistics();
                    break;

                case 0:
                    System.out.println("Выход из игры...");
                    return;
            }
        }
    }
    public static void Game() throws IOException {
        Random randomNumber = new Random();
        Scanner guesserNumber = new Scanner(System.in);

        int number = randomNumber.nextInt(100) + 1;


        while (true){
            System.out.println("Угадай число!:");
            int guesser = guesserNumber.nextInt();
            if(guesser == number){
                System.out.println("Поздравляю! Ты угадал\n");
                FileSaveStatistic(0);
                break;
            } else if (guesser < number) {
                System.out.println("Число которое я загадал больше!\n");
                FileSaveStatistic(1);
            }else {
                System.out.println("Число которое я загадал меньше!\n");
                FileSaveStatistic(2);
            }
        }
    }

    private static void FileSaveStatistic(int lineIndex) throws IOException{
        List<String> lines = Files.readAllLines(FILE_PATH);
        String line = lines.get(lineIndex);
        int currentValue = Integer.parseInt(line.replaceAll("\\D+", ""));
        currentValue++;
        
        if(lineIndex == 0){
            lines.set(0, "Выгранно игр: "+ currentValue);
        } else if (lineIndex == 1) {
            lines.set(1, "Больше: " + currentValue);
        }else {
            lines.set(2, "Меньше: " + currentValue);
        }
        Files.write(FILE_PATH, lines);
    }

    private static void InitializationFile() throws IOException{
        if (!Files.exists(FILE_PATH)) {
            Files.write(FILE_PATH, List.of(
                    "Выиграно игр: 0",
                    "Больше: 0",
                    "Меньше: 0"
            ));
        }
    }

    private static void showStatistics() throws IOException {

        if (!Files.exists(FILE_PATH)) {
            InitializationFile();
        }

        List<String> lines = Files.readAllLines(FILE_PATH);

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
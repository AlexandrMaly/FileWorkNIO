package app;

import service.FileReadService;
import service.FileWriteService;
import utils.Constants;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);
    private static String filePath;
    private static String contentText;

    public static void appStart() {
        handleChoice(choice());
    }

    private static int choice() {
        System.out.println("""
                Choose whether you want to:
                1 - create file and write something;
                2 - read the file
                """);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            System.exit(0);
            return -1;
        }
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1 -> createFile();
            case 2 -> readFile();
            default -> System.out.println("You entered incorrect number");
        }
    }


    private static void createFile() {
        System.out.println("Enter the file name: ");
        filePath = Constants.BASE_PATH_IN + sc.nextLine() + ".txt";
        Path path = Paths.get(filePath);
        System.out.println("Enter the text in file: ");
        contentText = sc.nextLine();
        FileWriteService fws = new FileWriteService();
        System.out.println(fws.writeData(path, contentText));
    }

    private static void readFile() {
        FileReadService frs = new FileReadService();
        System.out.println("Enter the file name: ");
        filePath = Constants.BASE_PATH_IN + sc.nextLine() + ".txt";
        Path path = Paths.get(filePath);
        System.out.println(frs.readData(path));
    }
}

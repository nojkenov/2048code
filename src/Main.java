import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Выберите размерность поля: ");
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        String a;
        game.init();
        game.init();
        for (int i = 0; i < 20000; i++) {
            a = scanner.nextLine();
            switch (a) {
                case "a" -> game.left();
                case "s" -> game.down();
                case "w" -> game.up();
                case "d" -> game.right();
            }
        }
    }
}
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] pool = new int[n][n];
    HashMap<Integer, Integer> map = new HashMap<>();
    int score = 0;
    boolean flag = true;


    public void left() {
        flag = false;
        for (int i = 0; i < n; i++) {
            boolean[] combined = {false, false, false, false};
            for (int j = 1; j < n; j++) {
                if (pool[i][j] != 0) {
                    int J = j;
                    while (J > 0 && pool[i][J - 1] == 0) {
                        pool[i][J - 1] = pool[i][J];
                        pool[i][J] = 0;
                        J--;
                        flag = true;
                    }
                    if (J > 0 && pool[i][J - 1] == pool[i][J] && !combined[J - 1]) {
                        pool[i][J - 1] = pool[i][J] * 2;
                        pool[i][J] = 0;
                        score += pool[i][J - 1];
                        combined[J - 1] = true;
                        flag = true;
                    }
                }
            }
        }
        init();
    }

    public void right() {
        flag = false;
        for (int i = 0; i < n; i++) {
            boolean[] combined = {false, false, false, false};
            for (int j = n - 2; j >= 0; j--) {
                if (pool[i][j] != 0) {
                    int J = j;
                    while (J < n - 1 && pool[i][J + 1] == 0) {
                        pool[i][J + 1] = pool[i][J];
                        pool[i][J] = 0;
                        J++;
                        flag = true;
                    }
                    if (J < n - 1 && pool[i][J + 1] == pool[i][J] && !combined[J + 1]) {
                        pool[i][J + 1] = pool[i][J] * 2;
                        pool[i][J] = 0;
                        score += pool[i][J + 1];
                        combined[J + 1] = true;
                        flag = true;
                    }
                }
            }
        }
        init();
    }


    public void up() {
        flag = false;
        for (int j = 0; j < n; j++) {
            boolean[] combined = {false, false, false, false};
            for (int i = 1; i < n; i++) {
                if (pool[i][j] != 0) {
                    int I = i;
                    while (i > 0 && pool[i - 1][j] == 0) {
                        pool[i - 1][j] = pool[i][j];
                        pool[i][j] = 0;
                        i--;
                        flag = true;
                    }
                    if (i > 0 && pool[i - 1][j] == pool[i][j] && !combined[i - 1]) {
                        pool[i - 1][j] = pool[i][j] * 2;
                        pool[i][j] = 0;
                        score += pool[i - 1][j];
                        combined[i - 1] = true;
                        flag = true;
                    }
                }
            }
        }
        init();
    }

    public void down() {
        flag = false;
        for (int j = 0; j < n; j++) {
            boolean[] combined = {false, false, false, false};
            for (int i = n - 2; i >= 0; i--) {

                if (pool[i][j] != 0) {
                    int I = i;
                    while (I < n - 1 && pool[I + 1][j] == 0) {
                        pool[I + 1][j] = pool[I][j];
                        pool[I][j] = 0;
                        I++;
                        flag = true;
                    }
                    if (I < n - 1 && pool[I + 1][j] == pool[I][j] && !combined[I + 1]) {
                        pool[I + 1][j] = pool[I][j] * 2;
                        pool[I][j] = 0;
                        score += pool[I + 1][j];
                        combined[I + 1] = true;
                        flag = true;
                    }
                }
            }
        }
        init();
    }

    public void random() {

        int a = rand.nextInt(n);
        int b = rand.nextInt(n);
        if (pool[a][b] == 0) pool[a][b] = (rand.nextInt(11) / 10) * 2 + 2;
        else random();
    }

    public void init() {
        if (flag) random();
        System.out.println("Score: " + score);
        out();
    }

    public void out() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + pool[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
import java.util.*;

public class LuckyNumber {
    // declare variable
    public static final int MAX = 101;
    public static int totalGames;
    public static int totalGuess;
    public static int bestGame = Integer.MAX_VALUE;
    public static int sum;

    public static void main(String[] args) {
        // print to the console screen
        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến " + (MAX - 1) + "...");
        play(); // play game
    }

    public static void play() {
        // create Scanner object input
        Scanner input = new Scanner(System.in);
        // assign values to variables
        totalGames = 0;
        totalGuess = 0;
        String str = "";
        do {
            // random number from 0 to 100 and save to variable x
            Random rd = new Random();
            int x = rd.nextInt(MAX);
            // System.out.println(x);
            sum = 1;
            // increase the number of game plays
            totalGames++;
            do {
                // print to the console screen
                System.out.print("Bạn đoán? ");
                // save data user input to variable number
                int number = input.nextInt();
                totalGuess++;
                // check entered number with random number
                if (number > x) {
                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
                    // increase number of guess
                    sum++;
                } else if (number < x) {
                    System.out.println("Số may mắn lớn hơn số dự đoán của bạn");
                    // increase number of guess
                    sum++;
                } else {
                    System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + sum + " lần dự đoán");
                    // least number of guesses
                    if (bestGame > sum) {
                        bestGame = sum;
                    }
                    break; // If the guess is correct then stop the loop
                }
            } while (true); // condition is always standing
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            /*
             * if player enter "yes" then continue game,
             * enter "no'' or other string then stop game and display report
             */
            str = input.next();
        } while (str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("y"));
        report(); // run report() function
    }

    public static void report() {
        System.out.println("--------************-----------");
        System.out.println("Kết quả tổng quát của trò chơi:");
        System.out.println("Tổng số lần chơi = " + totalGames);
        System.out.println("Tổng số lần dự đoán = " + totalGuess);
        double avg = (double) totalGuess / totalGames;
        System.out.println("Số lần dự đoán mỗi lượt = " + avg);
        System.out.println("Số lần dự đoán ít nhất = " + bestGame);
    }
}
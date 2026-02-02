package ASSIGNMENT1;
import java.util.Scanner;

public class ASIGNMENT1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char ch;

        while (true) {
            System.out.print("Enter a character (# to stop): ");
            ch = sc.next().charAt(0);

            if (ch == '#') {
                System.out.println("Program Stopped.");
                break;
            }

            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    System.out.println("Vowel");
                    break;

                default:
                    System.out.println("Consonant");
            }
        }

        sc.close();
    }
}

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] arg) throws FileNotFoundException {

        File dictionary = new File("C:\\Users\\admin\\Desktop\\simplbyte\\hangman\\engmix.txt");
        Scanner textscanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welcome to Hangman");

        ArrayList<String> words = new ArrayList<>(); // creating a list of words with name "words" from file
        while (textscanner.hasNext()) {
            words.add(textscanner.nextLine()); // reflecting those words
        }

        String hidden_text = words.get((int) (Math.random() * words.size())); // we want a word from words list from 1st letter to the size of list
        char[] textArray = hidden_text.toCharArray();

        char[] myAnswer = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswer[i] = '?';
        }

        boolean finished = false;
        int lives = 6;

        while (!finished) {
            System.out.println("***************************");
            System.out.print("Enter a letter: ");
            String letter = input.next();

            while (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
                System.out.println("Wrong input. Please enter a single letter.");
                letter = input.next();
            }

            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (Character.toLowerCase(letter.charAt(0)) == Character.toLowerCase(textArray[i])) {
                    myAnswer[i] = textArray[i];
                    found = true;
                }
            }

            if (!found) {
                lives--;
                System.out.println("Wrong letter");
            }

            boolean done = true;
            for (int i = 0; i < myAnswer.length; i++) {
                if (myAnswer[i] == '?') {
                    System.out.print("_ ");
                    done = false;
                } else {
                    System.out.print(myAnswer[i] + " ");
                }
            }
            System.out.println("\nLives left: " + lives);
            drawHangman(lives);

            // Game end
            if (done) {
                System.out.println("Congratulations YOU WIN !!!");
                finished = true;
            } else if (lives <= 0) {
                System.out.println(" You are dead ");
                finished = true;
            }
        }

        input.close();
        textscanner.close();
    }

    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}


import java.util.Scanner;

public class Hangman {

    boolean win = false;

    int misses = 0;

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {

    Hangman game = new Hangman();
    
    game.play();

    }
    public static String getRandomWord() {
        int random = (int) (Math.random() * words.length);
        return words[random];
    }

    public static String getHiddenWord(String word) {
        String hidden = "";
        for (int i = 0; i < word.length(); i++) {
            hidden += "-";
        }
        return hidden;
    }
    public static String getGuess(Scanner input) {
        System.out.print("Guess a letter: ");
        String guess = input.nextLine();
        return guess;
    }
    public static String getUpdatedWord(String word, String hidden, String guess) {
        String updated = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                updated += guess.charAt(0);
            } else if (hidden.charAt(i) != '-') {
                updated += word.charAt(i);
            } else {
                updated += "-";
            }
        }
        return updated;
    }
    public static boolean isFound(String word, String hidden) {
        if (word.equals(hidden)) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isGameLost(int misses) {
        if (misses == 6) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isGameWon(boolean win) {
        if (win == true) {
            return true;
        }
        else {
            return false;
        }
        
    }
    public static void printGallows(int misses) {
        System.out.println(gallows[misses]);
    }
    public void afterGuessMessage() {
        System.out.println("You have " + (6 - misses) + " guesses left.");
        System.out.println("The word now looks like this: " + getHiddenWord(getRandomWord()));
        System.out.println("You have guessed these letters: ");
        System.out.println(gallows[misses]);
    }
    public void afterWinMessage() {
        System.out.println("You have won!");
        System.out.println("The word was: " + getRandomWord());
    }
    public void afterLoseMessage() {
        System.out.println("You have lost!");
        System.out.println("The word was: " + getRandomWord());
    }
    public void play() {
        Scanner input = new Scanner(System.in);
        String word = getRandomWord();
        String hidden = getHiddenWord(word);
        while (!isGameWon(win) && !isGameLost(misses)) {
            printGallows(misses);
            System.out.println("The word now looks like this: " + hidden);
            System.out.println("You have guessed these letters: ");
            String guess = getGuess(input);
            hidden = getUpdatedWord(word, hidden, guess);
            if (isFound(word, hidden)) {
                win = true;
            } else {
                misses++;
            }
        }
        if (isGameWon(win)) {
            afterWinMessage();
        } else {
            afterLoseMessage();
        }
    }
    


















































}










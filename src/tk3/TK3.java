/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tk3;

import java.util.Scanner;

/**
 *
 * @author Irfan Jauhari
 */
public class TK3 {

    public static int linearSearch(String[] arr, String key) {
        for (String arr1 : arr) {
            if (arr1 == null ? key == null : arr1.equals(key)) {
                return 1;
            }
        }
        return 0;
    }

    public static void printArray(String[] arr) {
        int word_printed = 1;
        for (String arr1 : arr) {
            System.out.print(arr1 + "\t");
            word_printed++;
            if (word_printed == 6) {
                System.out.print("\n");
                word_printed = 1;
            }
        }
    }

    private static String getInputWithLength(Scanner scanner, int minLength, int maxLength) {
        String input;
        do {
            input = scanner.nextLine().trim();
            if (input.length() < minLength || input.length() > maxLength) {
                System.out.println("Please enter a word with a length between " + minLength + " and " + maxLength + " characters.");
            }
        } while (input.length() < minLength || input.length() > maxLength);
        return input;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO code application logic here    
        String[] wordsLvl1 = {"die", "led", "lei", "let", "lid", "lie", "lie", "lit", "tie", "deli", "diet", "edit", "idle", "lied", "tide", "tied", "tile", "tilt", "tilde", "tiled", "title", "tilted", "titled"};
        String[] wordsLvl2 = {"scan", "case", "scene", "can", "case", "seen", "sea", "see", "cease", "cane", "sec"};
        String[] wordsLvl3 = {"ore", "honk", "her", "hen", "roe", "honker", "neo", "one", "hoe", "hone"};

        int totalScore = 0;
        String repetition;
        boolean isRepetetion = false;
        boolean isStop = false;
        int minLengthAnswer = 3, maxLengthAnswer = 6;
        String[] answerLvl1 = new String[10];
        int totalAnswerLvl1 = 1,
                indexAnswerLvl1 = 0,
                totalAnswerCorrectLvl1 = 0,
                scoreLvl1 = 0;

        String[] answerLvl2 = new String[10];
        int totalAnswerLvl2 = 1,
                indexAnswerLvl2 = 0,
                totalAnswerCorrectLvl2 = 0,
                scoreLvl2 = 0;

        String[] answerLvl3 = new String[10];
        int totalAnswerLvl3 = 1,
                indexAnswerLvl3 = 0,
                totalAnswerCorrectLvl3 = 0,
                scoreLvl3 = 0;

        System.out.println("Coepoe Word Puzzle");
        System.out.println("==================");

        System.out.println("Rules:");
        System.out.println("1. Create a word using given characters, min " + "3 characters & max 6 characters");
        System.out.println("2. Each level, You have 10 chances to answer " + "correctly.");
        System.out.println("3. To get through to next level, you have to " + "score 70 each level.");

        int currentLevel = 1;

        while (currentLevel == 1 && !isStop) {
            System.out.println("\n");
            System.out.println("Level 1");
            System.out.println("-------");
            System.out.println("\t d \t e \t t " + "\t t \t l \t i");
            do {

                boolean isValidAnswer = false;
                do {
                    String tempAnswer;
                    System.out.print(totalAnswerLvl1 + "> Your Answer : ");
                    tempAnswer = getInputWithLength(scanner, minLengthAnswer, maxLengthAnswer);

                    if (indexAnswerLvl1 > 0) {
                        int linearSearchResult = linearSearch(answerLvl1, tempAnswer);

                        if (linearSearchResult == 1) {
                            System.out.println("World already typed..");
                        } else {
                            isValidAnswer = true;
                            answerLvl1[indexAnswerLvl1] = tempAnswer;
                            int checkGuess = linearSearch(wordsLvl1, answerLvl1[indexAnswerLvl1]);

                            if (checkGuess == 1) {
                                scoreLvl1 = scoreLvl1 + 10;
                                totalAnswerCorrectLvl1 = totalAnswerCorrectLvl1 + 1;
                                System.out.println("#Right. Score :" + scoreLvl1);
                            }
                        }
                    } else {
                        isValidAnswer = true;
                        answerLvl1[indexAnswerLvl1] = tempAnswer;
                        int checkGuess = linearSearch(wordsLvl1, answerLvl1[indexAnswerLvl1]);

                        if (checkGuess == 1) {
                            scoreLvl1 = scoreLvl1 + 10;
                            totalAnswerCorrectLvl1 = totalAnswerCorrectLvl1 + 1;
                            System.out.println("#Right. Score :" + scoreLvl1);
                        }
                    }

                } while (!isValidAnswer);
                indexAnswerLvl1++;
                totalAnswerLvl1++;
            } while (totalAnswerLvl1 <= 10);

            System.out.println("You had answered 10 times with " + totalAnswerCorrectLvl1 + " right answers...\n");
            System.out.println("Correct Answers : ");
            printArray(wordsLvl1);
            System.out.println("\n");

            if (scoreLvl1 < 70) {
                System.out.print("""
                                 You Lose!! Try again.. 
                                 Do you want to retry [y/n]? """);
                repetition = scanner.next();

                if ("n".equals(repetition) || "N".equals(repetition) || "y".equals(repetition) || "Y".equals(repetition)) {
                    if ("n".equals(repetition) || "N".equals(repetition)) {
                        isStop = true;
                        currentLevel = 1;
                    }
                    answerLvl1 = new String[10];
                    totalAnswerLvl1 = 1;
                    indexAnswerLvl1 = 0;
                    totalAnswerCorrectLvl1 = 0;
                    scoreLvl1 = 0;
                } else {
                    System.out.println("\nAnswer is not valid");
                    isStop = true;
                    currentLevel = 1;
                }
            } else {
                currentLevel++;
            }
        }

        while (currentLevel == 2 && !isStop) {
            System.out.println("Level 2");
            System.out.println("-------");
            System.out.println("\t s \t e \t c " + "\t a \t e \t n");
            do {

                boolean isValidAnswer = false;
                do {
                    String tempAnswer;
                    System.out.print(totalAnswerLvl2 + "> Your Answer :");
                    tempAnswer = getInputWithLength(scanner, minLengthAnswer, maxLengthAnswer);

                    if (indexAnswerLvl2 > 0) {
                        int linearSearchResult = linearSearch(answerLvl2, tempAnswer);

                        if (linearSearchResult == 1) {
                            System.out.println("World already typed..");
                        } else {
                            isValidAnswer = true;
                            answerLvl2[indexAnswerLvl2] = tempAnswer;
                            int checkGuess = linearSearch(wordsLvl2, answerLvl2[indexAnswerLvl2]);

                            if (checkGuess == 1) {
                                scoreLvl2 = scoreLvl2 + 10;
                                totalAnswerCorrectLvl2 = totalAnswerCorrectLvl2 + 1;
                                System.out.println("#Right. Score :" + scoreLvl2);
                            }
                        }
                    } else {
                        isValidAnswer = true;
                        answerLvl2[indexAnswerLvl2] = tempAnswer;
                        int checkGuess = linearSearch(wordsLvl2, answerLvl2[indexAnswerLvl2]);

                        if (checkGuess == 1) {
                            scoreLvl2 = scoreLvl2 + 10;
                            totalAnswerCorrectLvl2 = totalAnswerCorrectLvl2 + 1;
                            System.out.println("#Right. Score :" + scoreLvl2);
                        }
                    }

                } while (!isValidAnswer);
                indexAnswerLvl2++;
                totalAnswerLvl2++;
            } while (totalAnswerLvl2 <= 10);

            System.out.println("You had answered 10 times with " + totalAnswerCorrectLvl2 + " right answers...\n");
            System.out.println("Correct Answers : ");
            printArray(wordsLvl2);
            System.out.println("\n");

            if (scoreLvl2 < 70) {
                do {
                    System.out.print("""
                                     You Lose!! Try again.. 
                                     Do you want to retry [y/n]? """);
                    repetition = scanner.next();

                    if ("n".equals(repetition) || "N".equals(repetition) || "y".equals(repetition) || "Y".equals(repetition)) {
                        if ("n".equals(repetition) || "N".equals(repetition)) {
                            isStop = true;
                            currentLevel = 1;

                        }
                        answerLvl2 = new String[10];
                        totalAnswerLvl2 = 1;
                        indexAnswerLvl2 = 0;
                        totalAnswerCorrectLvl2 = 0;
                        scoreLvl2 = 0;
                        isRepetetion = true;
                    } else {
                        System.out.println("\nAnswer is not valid");
                        isStop = true;
                        currentLevel = 1;
                    }
                } while (!isRepetetion);
            } else {
                currentLevel++;
            }
        }

        while (currentLevel == 3 && !isStop) {
            System.out.println("Level 3");
            System.out.println("-------");
            System.out.println("\t h \t k \t r " + "\t n \t e \t o");
            do {

                boolean isValidAnswer = false;
                do {
                    String tempAnswer;
                    System.out.print(totalAnswerLvl3 + "> Your Answer :");
                    tempAnswer = getInputWithLength(scanner, minLengthAnswer, maxLengthAnswer);

                    if (indexAnswerLvl3 > 0) {
                        int linearSearchResult = linearSearch(answerLvl3, tempAnswer);

                        if (linearSearchResult == 1) {
                            System.out.println("World already typed..");
                        } else {
                            isValidAnswer = true;
                            answerLvl3[indexAnswerLvl3] = tempAnswer;
                            int checkGuess = linearSearch(wordsLvl3, answerLvl3[indexAnswerLvl3]);

                            if (checkGuess == 1) {
                                scoreLvl3 = scoreLvl3 + 10;
                                totalAnswerCorrectLvl3 = totalAnswerCorrectLvl3 + 1;
                                System.out.println("#Right. Score :" + scoreLvl3);
                            }
                        }
                    } else {
                        isValidAnswer = true;
                        answerLvl3[indexAnswerLvl3] = tempAnswer;
                        int checkGuess = linearSearch(wordsLvl3, answerLvl3[indexAnswerLvl3]);

                        if (checkGuess == 1) {
                            scoreLvl3 = scoreLvl3 + 10;
                            totalAnswerCorrectLvl3 = totalAnswerCorrectLvl3 + 1;
                            System.out.println("#Right. Score :" + scoreLvl3);
                        }
                    }

                } while (!isValidAnswer);
                indexAnswerLvl3++;
                totalAnswerLvl3++;
            } while (totalAnswerLvl3 <= 10);

            System.out.println("You had answered 10 times with " + totalAnswerCorrectLvl3 + " right answers...\n");
            System.out.println("Correct Answers : ");
            printArray(wordsLvl3);
            System.out.println("\n");

            if (scoreLvl3 < 70) {
                do {
                    System.out.print("""
                                     You Lose!! Try again.. 
                                     Do you want to retry [y/n]? """);
                    repetition = scanner.next();

                    if ("n".equals(repetition) || "N".equals(repetition) || "y".equals(repetition) || "Y".equals(repetition)) {
                        if ("n".equals(repetition) || "N".equals(repetition)) {
                            isStop = true;
                            currentLevel = 1;
                        }
                        answerLvl3 = new String[10];
                        totalAnswerLvl3 = 1;
                        indexAnswerLvl3 = 0;
                        totalAnswerCorrectLvl3 = 0;
                        scoreLvl3 = 0;
                        isRepetetion = true;
                    } else {
                        System.out.println("\nAnswer is not valid");
                        isStop = true;
                        currentLevel = 1;
                    }
                } while (!isRepetetion);
            } else {
                totalScore = scoreLvl1 + scoreLvl2 + scoreLvl3;
                System.out.println("Overall Score : " + totalScore);
                System.out.print("""
                                 You Win!! 
                                 Press ENTER to exit..""");
                scanner.nextLine();
                isStop = true;
                currentLevel = 1;
            }
        }

    }

}

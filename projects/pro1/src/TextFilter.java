import java.util.Scanner;

/*
 * Censors important information.
 *
 * @author Arham Hundia, hundia@purdue.edu
 * @version 06/24/19
 */
public class TextFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Print hello message
        System.out.println("Welcome to TextFilter!");

        // Value to keep track of if the user wants to keep filtering text
        boolean keepFiltering = false;
        do {
            // Print options for the user to select
            System.out.println("Please select one of the following filtering options: \n");
            System.out.println("1. Filter Word\n" +
                    "2. Find-And-Replace\n" +
                    "3. Censor Information");

            // Save their choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                // PART 1 - Censoring Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");

                // TODO: PART 1 - Ask the user for a passage to censor
                passage = scanner.nextLine();
                passage = " " + passage;
                int passageLength = passage.length();

                String word;  // The word to be censored from the text phrase
                System.out.println("Please enter the word you would like to censor: ");

                // TODO: PART 1 - Ask the user for a word to censor
                word = scanner.nextLine();
                int wordSize = word.length();


                System.out.println("Uncensored: ");
                String initialoutput = passage.substring(1, passageLength);
                System.out.println(initialoutput);

                // TODO: PART 1 - Implement your parsing here
                String replace = "";
                for (int i = 0; i < word.length(); i++) {
                    replace = replace + "X";
                } // end loop
                String finalSen;
                int currentPassagePointer = 0;//stores where the pointer of the passage is currently.
                if ((passage.equals(null)) || (passage.equals("")) || passage.equals(" ")) {
                    finalSen = "" + "\n";
                } else {
                    while (currentPassagePointer < passageLength - wordSize) {

                        int endIndex = 0;
                        int startIndex = passage.indexOf(word, currentPassagePointer);
                        if (startIndex == -1) {
                            break;
                        }
                        endIndex = startIndex + wordSize;
                        String varcheck = "";
                        if (endIndex >= passageLength) {
                            endIndex = passageLength;
                        } else {
                            varcheck = passage.charAt(endIndex) + "";
                        }
                        if ((passage.charAt(startIndex - 1) == ' ') && (varcheck.equals("") || varcheck.equals(" ") || varcheck.equals(".") || varcheck.equals("?") || varcheck.equals("!") || varcheck.equals(","))) {
                            passage = passage.substring(0, startIndex) + replace + passage.substring(endIndex, passageLength);
                        }

                        currentPassagePointer = endIndex;
                    }// end loop
                        finalSen = passage.substring(1, passageLength) + "\n";
                }//end if

                System.out.println("Censored: ");
                System.out.println(finalSen);


            } else if (choice == 2) {

                // PART 2 - Replacing Words


                String passage = "";  // The text to be filtered
                System.out.println("Please enter the passage you would like filtered: ");


                // TODO: PART 2 - Ask the user for a passage to filter
                passage = scanner.nextLine();
                passage = " " + passage;
                int passageLength = passage.length();


                String replace;  // The word to be filtered from the text phrase
                System.out.println("Please enter the word you would like to replace: ");

                //TODO: PART 2 - Ask the user for a word to replace
                replace = scanner.nextLine();
                int replaceLength = replace.length();
                String checkReplace = " " + replace;

                String insert;  // The word to be inserted in the text phrase
                System.out.println("Please enter word you would like to insert: ");

                //TODO: PART 2 - Ask the user for a word to insert
                insert = scanner.nextLine();
                int insertLength = insert.length();

                System.out.println("Uncensored: ");
                String initialOutput = passage.substring(1,passageLength);
                System.out.println(initialOutput);


                // TODO: PART 2 - Implement your parsing here
                int currentPassagePointer = 0;//stores where the pointer of the passage is currently.
                int remainLength = insertLength - replaceLength;
                String checkVal = "" + passage.charAt(passageLength - 1);
                String finalOut = "";
                int c = 0;

                if (checkVal.equals(replace)){
                    passage = passage.substring(1,passageLength);
                    finalOut = passage.substring(0,passageLength - 2) + " " + insert;
                    c = c + 1;
                } else if (passage.equals(checkReplace)){
                    finalOut = insert;
                    c = c + 1;
                } else {

                    passageLength = passageLength + remainLength;
                    int newPassageLength = 0;

                    while (currentPassagePointer < (passageLength - replaceLength)) {

                        int endIndex = 0;
                        int startIndex = passage.indexOf(replace, currentPassagePointer);
                        endIndex = startIndex + replaceLength;
                        if (startIndex == -1) {
                            newPassageLength = passage.length();
                            break;
                        }
                        if (endIndex <= replaceLength) {
                            break;
                        }
                        String varcheck = "";
                        if (endIndex >= passageLength) {
                            newPassageLength = endIndex;
                        } else {
                            varcheck = passage.charAt(endIndex) + "";
                        }
                        if ((passage.charAt(startIndex - 1) == ' ') && (varcheck.equals("") || varcheck.equals(" ") || varcheck.equals(".") || varcheck.equals("?") || varcheck.equals("!") || varcheck.equals(","))) {
                            passage = passage.substring(0, startIndex) + insert + passage.substring(endIndex);
                        }


                        currentPassagePointer = endIndex;

                    }// end loop
                }

                if (c == 1){
                    System.out.println("Censored: ");
                    System.out.println(finalOut + "\n");
                } else {
                    System.out.println("Censored: ");
                    String finalSentence = passage.substring(1);
                    System.out.println(finalSentence + "\n");
                }

            } else if (choice == 3) {

                // PART 3 - Censoring Personal Information


                /*
                 * DO NOT ALTER THIS CODE! This formatting is imperative to the completion of this task.
                 *
                 * Keep asking for input until the user enters an empty line
                 * If they enter an empty line and the phrase is empty, keep waiting for input
                 */
                String passage = "";  // String for holding text to be filtered

                System.out.println("Please enter the phrase you would like to censor information from: ");

                while (true) {

                    // Obtain a line from the user
                    String temp = scanner.nextLine();

                    if (!passage.isEmpty() && temp.isEmpty()) {
                        break;
                    } else if (passage.isEmpty() && temp.isEmpty()) {
                        continue;
                    }


                    // Add the contents of temp into the phrase
                    passage += temp;


                    // Append a newline character to each line for parsing
                    // This will separate each line the user enters
                    // To understand how input is formatted in Part 3, please refer to the handout.
                    passage += '\n';
                }

                // Print the uncensored passage
                System.out.println("Uncensored: ");
                System.out.println(passage);

                // TODO: PART 3 - Implement your parsing here
                int passageLength = passage.length();
                int currentPassagePointer = 0;
                int startIndex = 0;
                String finalOut ="";
                while (currentPassagePointer < passageLength){
                    int enterIndex = passage.indexOf("\n", currentPassagePointer);

                    String temp = passage.substring(startIndex, enterIndex);
                    int tempLength = temp.length();
                    int colonIndex = temp.indexOf(":");

                    String check = temp.substring(0, colonIndex+1);
                    switch (check){
                        case "Name:": {
                            int newIndex = 5;
                            String nameTemp = temp.substring(newIndex + 1, tempLength);
                            int nameTempLength = nameTemp.length();
                            int spaceChar = nameTemp.indexOf(" ");

                            String partOne = nameTemp.substring(0, spaceChar);
                            int partOneLength = partOne.length();

                            String newPartOne = partOne.charAt(0) + "";

                            for (int j = 0; j < partOneLength - 1; j++ ){
                                newPartOne = newPartOne + "*";
                            }

                            String partTwo = nameTemp.substring(spaceChar+1, nameTempLength);
                            int partTwoLength = partTwo.length();
                            String newPartTwo = partTwo.charAt(partTwoLength-1) + "";

                            for (int j = 0; j < partTwoLength-1; j++){
                                newPartTwo = "*" + newPartTwo;
                            }

                            finalOut = finalOut + check + " " + newPartOne + " " + newPartTwo +"\n" ;
                            break;
                        }//end case

                        case "Phone:": {
                            int newIndex = 6;
                            String phoneTemp = temp.substring(newIndex + 1, tempLength);
                            int phoneTempLength = phoneTemp.length();
                            String charac = "";

                            String partOne = phoneTemp.substring(0, 3);
                            int partOneLength = partOne.length();

                            String partTwo = phoneTemp.substring(4, 7);

                            String partThree = phoneTemp.substring(8, 12);

                            for (int j = 0; j < 3; j++ ){
                                charac = charac + "*";
                            }
                            finalOut = finalOut + check + " " + charac + "-" + charac + "-" + partThree +"\n";
                            break;
                        }//end case

                        case "Email:":{
                            int newIndex = 6;
                            String emailTemp = temp.substring(newIndex + 1, tempLength);
                            int emailTempLength = emailTemp.length();
                            int atIndex = emailTemp.indexOf("@");
                            int dotIndex = 0;

                            String partOne = emailTemp.substring(0, atIndex);
                            int partOneLength = partOne.length();
                            String newPartOne = partOne.substring(0,1);

                            for(int j = 0; j < partOneLength-1; j++){
                                newPartOne = newPartOne + "*";
                            }

                            dotIndex = emailTemp.indexOf('.', atIndex);

                            String partTwo = emailTemp.substring(atIndex + 1, dotIndex);
                            int partTwoLength = partTwo.length();
                            String newPartTwo = partTwo.substring(0, 1);

                            for (int j = 0; j < partTwoLength-1; j++){
                                newPartTwo = newPartTwo + "*";
                            }

                            String partThree = emailTemp.substring(dotIndex, emailTempLength);

                            finalOut = finalOut + check + " " + newPartOne + "@" + newPartTwo + partThree + "\n";
                            break;
                        }//end case

                        default:{
                            finalOut = finalOut + temp + "\n";
                        }//end default

                    }//end switch
                    currentPassagePointer = enterIndex + 1;
                    startIndex = currentPassagePointer;

                }



                // Print the censored passage
                System.out.println("Censored: ");
                System.out.println(finalOut);


            } else {

                // They entered a number that was not 1, 2 or 3
                System.out.println("The option you chose was invalid!");

            }


            System.out.println("Would you like to keep filtering? Yes/No");

            // TODO: PART 4 - Update the value of keepGoing accordingly
            // TODO: PART 4 - Replace the line below with your code
            String decision = scanner.next();
            decision = decision.toUpperCase();

            switch (decision){
                case "YES":{
                    keepFiltering = true;

                    break;
                }
                case "NO":{
                    keepFiltering = false;
                    break;
                }
                case "\n": {
                    boolean typing = true;
                    while (typing) {
                        decision = scanner.next();
                        decision = decision.toUpperCase();
                        if (decision.equals("YES") || decision.equals("NO")) {
                            if (decision.equals("YES")) {
                                keepFiltering = true;
                                typing = false;
                            } else {
                                keepFiltering = false;
                                typing = false;
                            }
                        } else {
                            typing = true;
                        }
                    }
                    break;
                }

                default:{
                    keepFiltering = false;
                }


            }

        } while (keepFiltering);

        System.out.println("Thank you for using TextFilter!");

    }

}


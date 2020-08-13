import java.io.*;
import java.util.Scanner;

/**
 * The main class of the program, that links together all of the other classes in this project.
 *
 * @author your name here
 * @date the date of submission
 */
public class StudentOperator {

    private static String firstName;
    private static String lastName;
    private static int age;
    private static String ageInput;
    private static String major;
    private static String collegeName;
    private static String state;
    private static CollegeStudent student;
    private static String housing;
    private static CollegeStudent lookedupStudent;


    public static void main(String[] args) throws InvalidStateException, InvalidCollegeException,
            InvalidStudentException {

        // Listed below are all the prompts you will need for main.
        int choice;
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the College Student Database!");
        do {
            while (true) {
                System.out.println("What would you like to do today?");
                System.out.println("(1) Add my information to the database");
                System.out.println("(2) Find out more information on my future college");
                System.out.println("(3) Lookup Student Information");
                System.out.println("(4) Exit");
                String decision = "";
                if (s.hasNextLine()) {
                    decision = s.nextLine();
                }
                choice = 0;
                try {
                    choice = Integer.parseInt(decision);
                } catch (Exception e){
                    System.out.println("Error: Please enter an integer!!!");
                    System.out.println();
                }
                if (choice > 0 && choice < 5){
                    break;
                } else {
                    System.out.println("Please enter a number between 1-4");
                }

            }

            switch (choice){

                case 1:{
                    boolean bool;
                    System.out.println("What college are you attending?");
                    if (s.hasNextLine()) {
                        collegeName = s.nextLine();
                    }
                    bool = verifyCollege(collegeName);
                    if (bool == false){
                        throw new InvalidCollegeException("The college name you entered was incorrect please enter a correct college!!!");
                    }

                    System.out.println("What is your first name?");
                    if (s.hasNextLine()) {
                        firstName = s.nextLine();
                    }
                    bool = verifyName(firstName);
                    if (bool == false){
                        throw  new InvalidStudentException("Firstname should have only letters.");
                    }

                    System.out.println("What is your last name?");
                    if (s.hasNextLine()) {
                        lastName = s.nextLine();
                    }
                    bool = verifyName(lastName);
                    if (bool == false){
                        throw new InvalidStudentException("Lastname should have only letters.");
                    }

                    System.out.println("How old are you?");
                    if (s.hasNextLine()) {
                        ageInput = s.nextLine();
                    }
                    bool = verifyAge(ageInput);
                    if (bool == false){
                        throw new InvalidStudentException("The age does not match the appropriate criteria.");
                    } else {
                        age = Integer.parseInt(ageInput);
                    }


                    System.out.println("What is your major?");
                    if (s.hasNextLine()) {
                        major = s.nextLine();
                    }
                    bool = verifyMajor(major);
                    if (bool == false){
                        throw new InvalidStudentException("Name of the major can have alphabets, space, '/' or '-' only.");
                    }

                    System.out.println("What state do you currently reside in?");
                    if (s.hasNextLine()) {
                        state = s.nextLine();
                    }
                    bool = verifyState(state);
                    if (bool == false){
                        throw new InvalidStateException("The State you entered does not exists");
                    }

                    System.out.println("Do you plan to live on or off campus?");
                    if (s.hasNextLine()) {
                        housing = s.nextLine();
                    }
                    bool = verifyHousing(housing);
                    if (bool == false) {
                        throw new InvalidStudentException("Type either 'On Campus' or 'Off Campus'.");
                    }


                    if (collegeName.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME)){
                        student = new PurdueStudent(age, firstName, lastName, state, major, housing);
                    } else  if (collegeName.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)){
                        student = new IndianaStudent(age, firstName, lastName, state, major, housing);
                    } else  if (collegeName.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME)){
                        student = new MichiganStudent(age, firstName, lastName, state, major, housing);
                    } else  if (collegeName.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME)){
                        student = new OhioStateStudent(age, firstName, lastName, state, major, housing);
                    } else  if (collegeName.equals(CollegeConstants.PENN_STATE_UNIVERSITY_NAME)){
                        student = new PennStateStudent(age, firstName, lastName, state, major, housing);
                    } else {
                        student = null;
                    }

                    writeStudentToFile(student);
                    System.out.println("Here is your new student ID : " + student.getID());
                    System.out.println("Thank you for the information! Your information has been documented. " +
                            "Good luck in college!");
                    break;
                }

                case 2:{
                    boolean bool;
                    System.out.println("What college are you planning on attending?");
                    if (s.hasNextLine()) {
                        collegeName = s.nextLine();
                    }
                    bool = verifyCollege(collegeName);
                    if (bool == false){
                        throw new InvalidCollegeException("The college name you entered was incorrect please enter a correct college!!!");
                    }
                    int choice2;
                    while (true) {
                        System.out.println("What information would you like to know about " + collegeName +"?");
                        System.out.println("(1) What dorms are there at my college?");
                        System.out.println("(2) What is the college mascot?");
                        System.out.println("(3) What city is my college in?");
                        System.out.println("(4) What state is my college in?");
                        String decision2 = "";
                        if (s.hasNextLine()) {
                            decision2 = s.nextLine();
                        }
                        choice2 = 0;
                        try {
                            choice2 = Integer.parseInt(decision2);
                        } catch (Exception e){
                            System.out.println("Error: Please enter an integer!!!");
                            System.out.println();
                        }
                        if (choice2 > 0 && choice2 < 5){
                            break;
                        } else {
                            System.out.println("Please enter a number between 1-4");
                        }
                    }

                    switch (choice2){
                        case 1:{
                            if (collegeName.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME)){
                                CollegeStudent dorms = new PurdueStudent();
                                for (int i = 0; i < dorms.getDorms().size(); i++){
                                    System.out.println(dorms.getDorms().get(i));
                                }
                                System.out.println();
                            } else if (collegeName.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)){
                                CollegeStudent dorms = new IndianaStudent();
                                for (int i = 0; i < dorms.getDorms().size(); i++) {
                                    System.out.println(dorms.getDorms().get(i));
                                }
                                System.out.println();
                            } else if (collegeName.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME)) {
                                CollegeStudent dorms = new OhioStateStudent();
                                for (int i = 0; i < dorms.getDorms().size(); i++) {
                                    System.out.println(dorms.getDorms().get(i));

                                }
                                System.out.println();
                            } else if (collegeName.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME)) {
                                CollegeStudent dorms = new MichiganStudent();
                                for (int i = 0; i < dorms.getDorms().size(); i++) {
                                    System.out.println(dorms.getDorms().get(i));
                                }
                                System.out.println();
                            } else if (collegeName.equals(CollegeConstants.PENN_STATE_UNIVERSITY_NAME)) {
                                CollegeStudent dorms = new PennStateStudent();
                                for (int i = 0; i < dorms.getDorms().size(); i++) {
                                    System.out.println(dorms.getDorms().get(i));
                                }
                                System.out.println();
                            }
                            break;

                        }

                        case 2:{
                            CollegeStudent mascot;
                            if (collegeName.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME)){
                                mascot = new PurdueStudent();
                            } else if (collegeName.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)){
                                mascot = new IndianaStudent();
                            } else if (collegeName.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME)) {
                                mascot = new OhioStateStudent();
                            } else if (collegeName.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME)) {
                                mascot = new MichiganStudent();
                            } else {
                                mascot = new PennStateStudent();
                            }
                            System.out.printf("Your college, %s has %s as its mascot.\n", collegeName, mascot.getMascot());
                            break;
                        }

                        case 3:{
                            CollegeStudent city;
                            if (collegeName.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME)){
                                city = new PurdueStudent();
                            } else if (collegeName.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)){
                                city = new IndianaStudent();
                            } else if (collegeName.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME)) {
                                city = new OhioStateStudent();
                            } else if (collegeName.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME)) {
                                city = new MichiganStudent();
                            } else {
                                city = new PennStateStudent();
                            }
                            System.out.printf("Your college, %s is in %s.\n", collegeName, city.getCity());
                            break;
                        }

                        case 4:{
                            CollegeStudent state;
                            if (collegeName.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME)){
                                state = new PurdueStudent();
                            } else if (collegeName.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)){
                                state = new IndianaStudent();
                            } else if (collegeName.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME)) {
                                state = new OhioStateStudent();
                            } else if (collegeName.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME)) {
                                state = new MichiganStudent();
                            } else {
                                state = new PennStateStudent();
                            }
                            System.out.printf("Your college, %s is in %s.\n", collegeName, state.getState());
                            break;
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.println("Please enter the College of the student you would like to lookup.");
                    boolean bool;
                    if (s.hasNextLine()) {
                        collegeName = s.nextLine();
                    }
                    bool = verifyCollege(collegeName);

                    if (bool == false) {
                        throw new InvalidCollegeException("The college name you entered was incorrect please enter a correct college!!!");
                    }

                    System.out.println("Enter the ID of the student you would like to know information about.");

                    String id;
                    try {
                        id = s.nextLine();

                        if (collegeName.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME)){
                            student = new PurdueStudent(id);
                        } else if (collegeName.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)){
                            student = new IndianaStudent(id);
                        } else if (collegeName.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME)){
                            student = new MichiganStudent(id);
                        } else if (collegeName.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME)){
                            student = new OhioStateStudent(id);
                        } else{
                            student = new PennStateStudent(id);
                        }

                        boolean bool2 = lookupID(student);
                        if (bool2 == true) {
                            System.out.println("What information would you like to know about the student?");
                            System.out.println("(1) Name");
                            System.out.println("(2) Age");
                            System.out.println("(3) Housing");
                            System.out.println("(4) Major");
                            System.out.println("(5) Student Origin");
                            int choice2 = 0;
                            try {
                                if (s.hasNextLine()) {
                                    choice2 = Integer.parseInt(s.nextLine());
                                }
                            } catch (Exception e){
                                System.out.println("Input an integer");
                            }
                            switch (choice2) {
                                case 1: {
                                    System.out.println("The student's name is " + lookedupStudent.getStudentFirstName()
                                            + " " + lookedupStudent.getStudentLastName());
                                    break;
                                }
                                case 2: {
                                    System.out.println("The student's age is " + lookedupStudent.getStudentAge());
                                    break;
                                }
                                case 3: {
                                    System.out.println("The student's housing is considered " + lookedupStudent.getHousing());
                                    break;
                                }
                                case 4: {
                                    System.out.println("The student's major is " + lookedupStudent.getMajor());
                                    break;
                                }
                                case 5: {
                                    System.out.println("The student's home is in " + lookedupStudent.getStateOfResidence());
                                    break;
                                }
                            }
                        } else {
                            System.out.println("That student doesn't exist in the database. Thank you for using the Lookup"
                                    + " Tool!");
                            throw new InvalidStudentException();
                        }
                    } catch (Exception e) {
                        throw new InvalidStudentException("No student of this ID");
                    }
                }
                    break;
                case 4:{
                    System.out.println("Thank you for using the College Database Program!");
                }
            }

        }while (choice != 4);
    }

    /**
     * The {@code verifyState()} method takes in a state and makes sure it is present in the enum {@code States}. If
     * the state is not present, then the method returns false. If it is, then the method returns true. If the name
     * of the state is two words, like New York, then this method should also convert it to where the space is now
     * an underscore character.If this method returns false, the method that called it should throw a {@code
     * InvalidStateException}.
     *
     * @param str The state to be checked
     * @return The result of whether the state is in the United States
     */
    private static boolean verifyState(String str) {
        //TODO verify that the state entered by the student is a valid state
        str = str.replaceAll(" ", "_");
        if (str == null || str.length() == 0){
            return false;
        }
        String [] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
                "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
                "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
                "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New_Hampshire", "New_Jersey",
                "New_Mexico", "New_York", "North_Carolina", "North_Dakota", "Ohio", "Oklahoma", "Oregon",
                "Pennsylvania", "Rhode_Island", "South_Carolina", "South_Dakota", "Tennessee", "Texas",
                "Utah", "Vermont", "Virginia", "Washington", "West_Virginia", "Wisconsin", "Wyoming", "International"};

        for (int i= 0; i<states.length; i++){
            if (str.equals(states[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * The {@code verifyAge()} method verifies that the age is between the specified bounds of being 16 years or older
     * and being 22 years or younger. Since the main method will read any input, you should also ensure that the
     * input is an integer.If this method returns false, the method that called it should throw a {@code
     * InvalidStudentException}.
     *
     * @param ageToVerify The age to verify
     * @return The result of whether the age falls between the specified bounds
     */
    private static boolean verifyAge(String ageToVerify) {
        //TODO verify that the age of the student is within the valid bounds
        try {
            int age = Integer.parseInt(ageToVerify);
            if (age < 16 || age > 22){
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * The {@code verifyMajor()} method verifies whether the major is not a blank line. If the major is a blank line,
     * the method returns false. If the major is anything except a blank line, the method returns true. In addition,
     * the method should only allow letters. The only three characters allowed besides letters are a space, a '/'
     * character, and a '-' character. You should remove these in this method, and replace them with nothing. If this
     * method returns false, the method that called it should throw a {@code InvalidStudentException}.
     *
     * @param majorToVerify The major to verify
     * @return The result of whether the major is a valid major.
     */
    private static boolean verifyMajor(String majorToVerify) {
        //TODO verify that the major the student entered is a valid input.
        if (majorToVerify == null || majorToVerify.length() == 0){
            return false;
        }

        for (int i=0; i< majorToVerify.length(); i++){
            int counter = 0;
            String letterToCheck = majorToVerify.charAt(i) + "";
            letterToCheck = letterToCheck.toLowerCase();
            for (char j = 'a'; j <= 'z'; j++){
                String checker = j + "";
                if (letterToCheck.equals(checker) || letterToCheck.equals(" ") ||
                        letterToCheck.equals("/") || letterToCheck.equals("-")){
                    counter++;
                }
            }
            if (counter == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * The {@code verifyHousing()} method verifies that the housing statement matches either the on campus or
     * off campus housing constants in the {@code CollegeConstants} class.If this method returns false, the method
     * that called it should throw a {@code InvalidStudentException}.
     *
     * @param housingToVerify The housing status to verify
     * @return The result of whether the housing is valid.
     */
    private static boolean verifyHousing(String housingToVerify) {
        //TODO verify that the housing status of the student is a valid input.
        if (housingToVerify.equalsIgnoreCase(CollegeConstants.ON_CAMPUS) || housingToVerify.equalsIgnoreCase(CollegeConstants.OFF_CAMPUS)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * The {@code verifyCollege()} method verifies that the college is one of the give colleges supported by
     * the CollegeLogger project. If it is not one of the five colleges, the method returns false. If it is,
     * the method returns true. If this method returns false, the method that called it should throw a {@code
     * InvalidCollegeException}.
     *
     * @param str The college to check support for
     * @return The result of whether or not this college is supported by this program.
     */
    private static boolean verifyCollege(String str) {
        //TODO verify that the college the user entered is a valid college name.
        if (str == null || str.length() == 0){
            return false;
        }
        if (str.equals(CollegeConstants.PURDUE_UNIVERSITY_NAME) || str.equals(CollegeConstants.INDIANA_UNIVERSITY_NAME)
                || str.equals(CollegeConstants.UNIVERSITY_OF_MICHIGAN_NAME ) ||
                str.equals(CollegeConstants.OHIO_STATE_UNIVERSITY_NAME) || str.equals(CollegeConstants.PENN_STATE_UNIVERSITY_NAME)){
           return true;

        }
        return false;
    }

    /**
     * The {@code verifyName()} method will check whether the name is composed purely of letters. A name containing
     * anything other than letters is considered an invalid name. Similarly, an empty string is also considered an
     * invalid name.If this method returns false, the method that called it should throw a {@code
     * InvalidStudentException}.
     *
     * @param str The name to check validity of
     * @return Whether the name is a valid name for the program to use.
     */
    private static boolean verifyName(String str) {
        //TODO verify that the name the user entered is a valid name.
        if (str == null || str.length() == 0){
            return false;
        }

        for (int i = 0; i < str.length(); i++){
            int counter = 0;
            String checker = str.charAt(i) + "";
            checker = checker.toLowerCase();
            for (char j = 'a'; j<='z'; j++){
                String checker2 = j + "";

                if ((checker.equals(checker2))){
                    counter ++;
                    //do nothing
                }
            }
            if (counter == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * The {@code writeStudentToFile()} method takes the information provided by the user to the program and
     * pretty prints it to the appropriate text file. If the file is not empty, meaning there are
     * already one or more entries, a row of 20 dashes separated by a single space should be printed to separate
     * the entries. This information should be put to the appropriate file based on the student's college name. Refer
     * to the handout in order to understand the order of the data to be printed. In addition, keep in mind that the
     * tuition should be printed without a dollars sign but have two decimal places.
     * <p>
     * The files will be named as follows:
     * <p>
     * For Purdue University, data is stored in a file called purdueUniversityStudents.txt
     * For Indiana University, data is stored in a file called indianaUniversityStudents.txt
     * For University of Michigan, data is stored in a file called universityOfMichiganStudents.txt
     * For Pennsylvania State University, data is stored in a file called pennsylvaniaStateUniversityStudents.txt
     * For The Ohio State University, data is stored in a file called theOhioStateUniversityStudents.txt
     *
     * @param studentToWrite The {@code CollegeStudent} to write data about.
     */
    private static void writeStudentToFile(CollegeStudent studentToWrite) {
        //TODO write data to the appropriate file, as described by the handout

        if (studentToWrite instanceof PurdueStudent){
            File f = new File("purdueUniversityStudents.txt");
            try {
                if (f.length() == 0) {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }else {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write("— — — — — — — — — — — — — — — — — — — —\n");
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
            }

            }catch (IOException e){
                e.printStackTrace();
            }

        } else if (studentToWrite instanceof IndianaStudent){
            File f = new File("indianaUniversityStudents.txt");
            try {
                if (f.length() == 0) {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }else {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write("— — — — — — — — — — — — — — — — — — — —\n");
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        } else if (studentToWrite instanceof MichiganStudent){
            File f = new File("universityOfMichiganStudents.txt");
            try {
                if (f.length() == 0) {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }else {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write("— — — — — — — — — — — — — — — — — — — —\n");
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        } else if (studentToWrite instanceof OhioStateStudent) {
            File f = new File("theOhioStateUniversityStudents.txt");
            try {
                if (f.length() == 0) {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }else {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write("— — — — — — — — — — — — — — — — — — — —\n");
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        } else if (studentToWrite instanceof PennStateStudent) {
            File f = new File("pennsylvaniaStateUniversityStudents.txt");
            try {
                if (f.length() == 0) {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }else {
                    PrintWriter purdue = new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
                    purdue.write("— — — — — — — — — — — — — — — — — — — —\n");
                    purdue.write(studentToWrite.getID()+"\n");
                    purdue.write(studentToWrite.getStudentLastName().toUpperCase()+", " + studentToWrite.getStudentFirstName().toUpperCase()+"\n");
                    purdue.write(studentToWrite.getStudentAge()+"\n");
                    purdue.write(studentToWrite.getHousing()+"\n");
                    purdue.write(studentToWrite.getMajor()+"\n");
                    purdue.write(studentToWrite.getStateOfResidence() + "\n");
                    String tuition = String.format("%.2f", studentToWrite.getTuition());
                    purdue.write(tuition + "\n");
                    purdue.flush();
                    purdue.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
   }

    private static boolean lookupID(CollegeStudent student) {
        //TODO lookup a student's ID to find out whether it is valid or not.

        File f;
        String tester;
        if (student instanceof PurdueStudent){
            f = new File("purdueUniversityStudents.txt");
            tester = "purdue";
        } else if (student instanceof IndianaStudent){
            f = new File("indianaUniversityStudents.txt");
            tester = "indiana";
        } else if (student instanceof MichiganStudent){
            f = new File("universityOfMichiganStudents.txt");
            tester = "michigan";
        } else if (student instanceof OhioStateStudent){
            f = new File("theOhioStateUniversityStudents.txt");
            tester = "ohio";
        } else if(student instanceof PennStateStudent){
            f = new File("pennsylvaniaStateUniversityStudents.txt");
            tester = "penn";
        } else{
            return false;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            String checkID = student.getID();
            while ((line = br.readLine()) != null){
                if (line.equals(checkID)){
                    line = br.readLine();
                    int indexOf = line.indexOf(",");
                    String fname = line.substring(indexOf+2);
                    fname = toNameCase(fname);
                    String lname = line.substring(0, indexOf);
                    lname = toNameCase(lname);
                    line = br.readLine();
                    int age = Integer.parseInt(line);
                    line = br.readLine();
                    String housing = line;
                    line = br.readLine();
                    String major = line;
                    line = br.readLine();
                    String origin = line;
                    switch (tester){
                        case "purdue":{
                            lookedupStudent = new PurdueStudent(age, fname, lname, origin, major, housing);
                            break;
                        }
                        case "indiana":{
                            lookedupStudent = new IndianaStudent(age, fname, lname, origin, major, housing);
                            break;
                        }
                        case "michigan":{
                            lookedupStudent = new MichiganStudent(age, fname, lname, origin, major, housing);
                            break;
                        }
                        case "ohio":{
                            lookedupStudent = new OhioStateStudent(age, fname, lname, origin, major, housing);
                            break;
                        }
                        case "penn":{
                            lookedupStudent = new PennStateStudent(age, fname, lname, origin, major, housing);
                            break;
                        }

                    }
                    br.close();
                    return true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return false;


    }

    private static String toNameCase(String str) {
        //TODO convert the passed String to "Name Case", where the first letter of string passed in is capitalized,
       //and the rest is converted to lower case.
        String output = str.substring(0, 1);
        output = output.toUpperCase() + str.substring(1).toLowerCase();
        return output;
    }
}

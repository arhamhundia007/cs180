import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    public static void main(String[] args) throws IOException {
        File out = new File("Database.txt");

        ArrayList<String> list = new ArrayList<String>();

        File f = new File("Names.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        PrintWriter pw = new PrintWriter(out);

        int counter = 0;

        String line;

        while ((line = br.readLine()) != null) {
            list.add(line);
            counter +=1;
        }
        br.close();




        File f2 = new File("Phones.txt");
        fr = new FileReader(f2);
        br = new BufferedReader(fr);
        ArrayList<String> list1 = new ArrayList<String>();
        int counter2 = 0;
        String line2;

        while ((line2 = br.readLine()) != null){
            list1.add(line2);
            counter2 += 1;
        }


        for (int i = 0; i < counter2; i++) {
            pw.write("NAME: " +list.get(i) + "\n" + "PHONE: " + list1.get(i) + "\n\n");

        }
        pw.close();

        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the DMV Phone Book.");
        System.out.printf("Enter name of DMV: ");
        String name = s.nextLine();
        System.out.println();
        int index = -1;
        for (int i = 0; i < counter; i++){
            if (name.equals(list.get(i))){
                index = i;
                break;
            }
        }
        if (index != -1){
            System.out.printf("The phone number for %s is %s", list.get(index),list1.get(index));
        } else {
            System.out.println("The name entered does not exist in the database.");
        }
    }








}

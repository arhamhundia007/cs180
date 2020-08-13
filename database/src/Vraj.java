import java.io.*;

public class Vraj {
    public static void main(String[] args) throws IOException {
        File f = new File("Names.txt");

        FileReader fr = new FileReader (f);


        BufferedReader br = new BufferedReader(fr);
        String vraj= "";



        while (true){
            String name = br.readLine();
            if (name == null){
                break;
            }
            vraj = name;
        }
        System.out.println(vraj);


    }
}

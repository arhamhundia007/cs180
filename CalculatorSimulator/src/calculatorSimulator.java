import javax.swing.*;
import java.util.Arrays;

public class calculatorSimulator {
    private static double[] nums;
    private static boolean clicked = false;

    public static void main(String[] args) {
        boolean bool;

        do {


            String input = JOptionPane.showInputDialog("Number of Observations");
            int occ;
            while (true) {
                occ = Integer.parseInt(input);
                if (occ > 0) {

                    break;

                } else {

                    JOptionPane.showMessageDialog(null, "Invalid Input", "ERROR: Input", JOptionPane.ERROR_MESSAGE);
                    input = JOptionPane.showInputDialog("Number of Observations");

                }
            }

            nums = new double[occ];

            for (int i = 0; i < nums.length; i++) {

                input = JOptionPane.showInputDialog("Enter observation number:");
                nums[i] = Integer.parseInt(input);

            }

            boolean checker;
            do {

                String[] option = {"Min", "Max", "Median", "Mean", "Sum"};

                int calculate = JOptionPane.showOptionDialog(null, "Choose type of Analysis.", "Data Analyzer",
                        JOptionPane.INFORMATION_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, option, option[4]);

                if (calculate == 4){

                    double sum = 0;

                    for (int i = 0; i < nums.length; i++){
                        sum = sum + nums[i];
                    }

                    String output = String.format("Sum: %.2f", sum);
                    JOptionPane.showMessageDialog(null, output, "Sum", JOptionPane.INFORMATION_MESSAGE);

                } else if (calculate == 3) {

                    double sum = 0;

                    for (int i = 0; i < nums.length; i++) {
                        sum = sum + nums[i];
                    }

                    double mean = sum/nums.length;

                    String output = String.format("Mean: %.2f", mean);
                    JOptionPane.showMessageDialog(null, output, "Mean", JOptionPane.INFORMATION_MESSAGE);

                } else if (calculate == 2) {

                    Arrays.sort(nums);
                    double median;

                    if (nums.length % 2 != 0) {

                        median = nums[nums.length / 2];

                    } else {

                        double num1 = nums[nums.length / 2];
                        double num2 = nums[nums.length / 2 - 1];
                        median = (num1 + num2) / 2;

                    }

                    String output = String.format("Median: %.2f", median);
                    JOptionPane.showMessageDialog(null, output, "Median", JOptionPane.INFORMATION_MESSAGE);

                } else if (calculate == 1) {

                    Arrays.sort(nums);
                    double max = nums[nums.length-1];

                    String output = String.format("Max: %.2f", max);
                    JOptionPane.showMessageDialog(null, output, "Max", JOptionPane.INFORMATION_MESSAGE);

                } else if (calculate == 0) {

                    Arrays.sort(nums);
                    double min = nums[0];

                    String output = String.format("Min: %.2f", min);
                    JOptionPane.showMessageDialog(null, output, "Min", JOptionPane.INFORMATION_MESSAGE);

                }

                int input2 = JOptionPane.showConfirmDialog(null, "Do you want to get a new Analysis for the same set of data?",
                        "Data Analyzer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (input2 == JOptionPane.YES_OPTION){

                    checker = true;

                }else {

                    checker = false;

                }
            }while (checker == true);

            int input2 = JOptionPane.showConfirmDialog(null, "Wanna do the analysis again with new sets of data?",
                    "Data Analyzer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (input2 == JOptionPane.YES_OPTION){

                bool = true;

            } else {

                bool = false;

            }
        } while (bool == true);
    }
}


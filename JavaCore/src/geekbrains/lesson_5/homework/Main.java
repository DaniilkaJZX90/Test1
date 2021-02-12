package geekbrains.lesson_5.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String[] header = {"val1", "val2", "val3"};
        int[][] values = {{1000, 2000, 3000}, {4000, 5000, 6000}, {7000, 8000, 9000}};

        AppData appData = new AppData(header, values);
        writeFile(appData);
        appData.printAppData();





    }


    public static class AppData implements Serializable {
        String[] header;
        int[][] values;

        public AppData(String[] header, int[][] values) {
            this.header = header;
            this.values = values;
        }

        public String[] getHeader() {
            return header;
        }

        public int[][] getValues() {
            return values;
        }


        public void printAppData() throws IOException {
            try{
                AppData readAppDataHeader = readFile();
                for (String v: readAppDataHeader.getHeader()) {
                    System.out.print(v + ";");
                }
                System.out.println();

                int[][] readAppDataValues = readAppDataHeader.getValues();
                for (int i = 0; i < readAppDataValues.length; i++) {
                    for (int j = 0; j < readAppDataValues.length; j++) {
                        System.out.print(readAppDataValues[i][j] + ";");
                    }
                    System.out.print("\r\n");
                }
            }catch (IOException e){
                e.printStackTrace();
            }


        }

    }


    public static void writeFile(AppData appData) {
        try (PrintWriter out = new PrintWriter("test.csv")) {
            for (String v : appData.getHeader()) {
                out.print(v + ";");
            }
            out.println();

            int[][] values = appData.getValues();
            for (int i = 0; i < values.length; i++) {
                for (int j = 0; j < values[i].length; j++) {
                    out.print(values[i][j] + ";");
                }
                out.write("\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("test.csv"));
        List<int[]> appDataArr = new ArrayList<>();
        String[] appDataHeader = in.readLine().split(";");
        String readValues = null;
        while ((readValues = in.readLine()) != null) {
            List<Integer> valuesArr = new ArrayList<>();
            String[] tokens = readValues.split(";");
            for (int i = 0; i < tokens.length; i++) {
                valuesArr.add(Integer.parseInt(tokens[i]));
            }
            appDataArr.add(valuesArr.stream().mapToInt(i -> i).toArray());
        }
        AppData appData2 = new AppData(appDataHeader, appDataArr.toArray(new int[0][]));
        int[][] vv = appData2.getValues();
        return appData2;

    }


}

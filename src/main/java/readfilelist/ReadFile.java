package readfilelist;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public ArrayList<Line> readFile(String filePath){
        ArrayList<Line> resultList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                resultList.add(checkString(line));
            }
        }catch (IOException e) {
            System.out.println("Error reading data from file");
        }
        return resultList;
    }

    private Line checkString(String line){
        int lineId=0;
        try{
            lineId = Integer.parseInt(line.split(",")[0]);
            if (lineId<0) throw new NumberFormatException();
        } catch (NumberFormatException e){
            System.out.println("incorrect Id");
        }
        return new Line(lineId,line.split(",")[1]);
    }
 }

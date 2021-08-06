package writeFile;

import readfilelist.Line;
import readfilelist.ResultLine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WriteFile<T extends Line> {
    private BufferedWriter bufferedWriter;

    public WriteFile(String path) {

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeFileArr(ArrayList<T> result, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( s+ "\n");
        for (T line : result) {

            stringBuilder.append(line);
        }

        try {
            bufferedWriter.append(stringBuilder);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFileLink(LinkedList<T> result,String s) {
        StringBuilder builder = new StringBuilder();
        builder.append( s+ "\n");
        for (T line : result) {
            builder.append(line);
        }
        try {
            bufferedWriter.append(builder);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFileMap(HashMap<Integer, ArrayList<T>> result, String s) {
        StringBuilder builderMap = new StringBuilder();
        builderMap.append( s+ "\n");
        for (Map.Entry<Integer, ArrayList<T>> entry : result.entrySet()) {
            for (T line : entry.getValue())
            builderMap.append(line);
        }
        try {
            bufferedWriter.append(builderMap);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


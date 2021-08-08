package writeFile;


import readfilelist.ResultLine;
import readfilelist.ValueMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteFile {
    private String path;

    public WriteFile(String path) {
        this.path = path;

    }

    public void writeFileList(List<ResultLine> result, String s) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.append(s).append("\n");

            for (ResultLine line : result) {

                bufferedWriter.append(line.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeFileMap(HashMap<Integer, ArrayList<ValueMap>> result, String s) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.append(s).append("\n");
        for (Map.Entry<Integer, ArrayList<ValueMap>> entry : result.entrySet()) {
            for (ValueMap line : entry.getValue())
                bufferedWriter.append(entry.getKey().toString()).append(", ").append(line.toString());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


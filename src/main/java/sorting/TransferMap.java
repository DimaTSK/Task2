package sorting;

import readfilelist.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransferMap {
    public HashMap<Integer, ArrayList<String>> transferToHashMap(List<Line> list) {
        HashMap<Integer, ArrayList<String>> result = new HashMap<>();
        for (Line list1 : list) {
            if (result.containsKey(list1.getId())) {
                result.get(list1.getId()).add(list1.getValue());
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(list1.getValue());
                result.put(list1.getId(), arrayList);
            }


        }

        return result;
    }
}

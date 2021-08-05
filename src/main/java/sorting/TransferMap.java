package sorting;

import readfilelist.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransferMap {
   public HashMap<Integer, ArrayList<Line>> transferToHashMap(List<Line> list){
       HashMap<Integer,ArrayList<Line>> result = new HashMap<>();
        for (Line list1 : list){

            result.computeIfAbsent(list1.getId(),ArrayList::new).add(list1);

        }

       return result;
   }
}

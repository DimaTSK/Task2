package leftjoin;

import readfilelist.Line;
import readfilelist.ResultLine;

import java.util.*;

public class LeftJoin {

    public ArrayList<ResultLine> leftJoin(ArrayList<Line> firstList, ArrayList<Line> secondList) {
        ArrayList<ResultLine> result = new ArrayList<>();

        for (Line lineList1 : firstList) {
            boolean isAdd = false;
            for (Line lineList2 : secondList) {
                if (lineList1.getId() == lineList2.getId()) {
                    //resultLine.setSecondValue(lineList2.getValue());
                    result.add(new ResultLine(lineList1, lineList2));
                    isAdd = true;
                }
            }
            if (!isAdd) {
                result.add(new ResultLine(lineList1));
            }
        }
        return result;
    }

    public LinkedList<ResultLine> leftJoin(LinkedList<Line> firstList, LinkedList<Line> secondList) {
        LinkedList<ResultLine> result = new LinkedList<>();
        Iterator<Line> iteratorFirst = firstList.iterator();

        while (iteratorFirst.hasNext()) {
            boolean isAdd = false;
            Line lineValue1 = iteratorFirst.next();
            Iterator<Line> iteratorSecond = secondList.iterator();
            ResultLine resultLine = new ResultLine(lineValue1);
            while (iteratorSecond.hasNext()) {
                Line lineValue2 = iteratorSecond.next();
                if (lineValue1.getId() == lineValue2.getId()) {
                    resultLine.setSecondValue(lineValue2.getValue());
                    result.add(new ResultLine(lineValue1, lineValue2));
                    isAdd = true;

                }

            }
            if (!isAdd) {
                result.add(new ResultLine(lineValue1));
            }
        }


        return result;
    }

    public HashMap<Integer, ArrayList<ResultLine>> leftJoin(HashMap<Integer, ArrayList<Line>> firstMap,
                                                            HashMap<Integer, ArrayList<Line>> secondMap) {

        HashMap<Integer, ArrayList<ResultLine>> result = new HashMap<>();

        for (Map.Entry<Integer, ArrayList<Line>> entry1 : firstMap.entrySet()) {
            for (Line line : entry1.getValue()) {
                if (secondMap.containsKey(entry1.getKey())) {
                    for (Line line2 : secondMap.get(entry1.getKey())) {
                        result.computeIfAbsent(entry1.getKey(), ArrayList::new).add(new ResultLine(line, line2));
                    }
                } else {
                    result.computeIfAbsent(entry1.getKey(), ArrayList::new).add(new ResultLine(line));
                }
            }
        }


        return result;

    }
}






/*public HashMap<String, String> leftJoin (HashMap<Integer,String> firstMap, HashMap<Integer, String> secondMap){
        HashMap<String,String> result = new HashMap<>();
        for(Map.Entry<Integer,String> entry : firstMap.entrySet()){

            int id = entry.getKey();
            if(secondMap.containsKey(id)){
                result.put(entry.getValue(),secondMap.get(id));
            }
            else {
                result.put(entry.getValue(),null);
            }

        }
        return result;
    }*/
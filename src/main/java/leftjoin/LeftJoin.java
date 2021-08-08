package leftjoin;

import readfilelist.Line;
import readfilelist.ResultLine;
import readfilelist.ValueMap;

import java.util.*;

public class LeftJoin {

    public ArrayList<ResultLine> leftJoin(ArrayList<Line> firstList, ArrayList<Line> secondList) {
        ArrayList<ResultLine> result = new ArrayList<>();

        for (Line lineList1 : firstList) {
            boolean isAdd = false;
            for (Line lineList2 : secondList) {
                if (lineList1.getId() == lineList2.getId()) {
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
        //todo change to usual iterator
        ListIterator<Line> iteratorFirst = firstList.listIterator();
        ListIterator<Line> iteratorSecond = secondList.listIterator();
        int count = 0;
        int oldId = -1;
        while (iteratorFirst.hasNext()) {
            Line lineValue1 = iteratorFirst.next();
            if (lineValue1.getId() == oldId){
                for (int i = count; i > 0; i--){
                    iteratorSecond.previous();
                }
            }
            count = 0;
            if (iteratorSecond.hasNext()) {
                while (iteratorSecond.hasNext()) {
                    Line lineValue2 = iteratorSecond.next();
                    if (lineValue1.getId() == lineValue2.getId()) {
                        result.add(new ResultLine(lineValue1, lineValue2));
                        count++;
                    } else if (lineValue1.getId() < lineValue2.getId()) {
                        if (count == 0) {
                            result.add(new ResultLine(lineValue1));
                        }
                        iteratorSecond.previous();
                        break;
                    }
                }
            } else {
                result.add(new ResultLine(lineValue1));
            }
            oldId = lineValue1.getId();
        }
        return result;

    }


    public HashMap<Integer, ArrayList<String>> leftJoin(HashMap<Integer, ArrayList<String>> firstMap,
                                                        HashMap<Integer, ArrayList<String>> secondMap) {

        HashMap<Integer, ArrayList<String>> result = new HashMap<>();

        for (Map.Entry<Integer, ArrayList<String>> entry1 : firstMap.entrySet()) {
            ArrayList<String> arrList = new ArrayList<>();
            if (secondMap.containsKey(entry1.getKey())) {
                for (String line : entry1.getValue()) {

                    for (String line2 : secondMap.get(entry1.getKey())) {
                        arrList.add(line + " " + line2);
                    }
                }
            } else {
                for (String line : entry1.getValue()) {
                    arrList.add(line + " " + null);
                }
                //arrList.addAll(entry1.getValue());

            }
            result.put(entry1.getKey(), arrList);
        }


        return result;

    }
}



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
        ListIterator<Line> iteratorFirst = firstList.listIterator();
        ListIterator<Line> iteratorSecond = secondList.listIterator();
        int count = 0;

        while (iteratorFirst.hasNext()) {
            Line lineValue1 = iteratorFirst.next();
            while (iteratorSecond.hasNext()){
                Line lineValue2 = iteratorSecond.next();
                if (lineValue1.getId()==lineValue2.getId()){
                    result.add(new ResultLine(lineValue1,lineValue2));
                    break;
                }
                else if (lineValue1.getId()<lineValue2.getId()){
                    iteratorSecond.previous(); count;
                    break;;
                }else if (lineValue1.getId()>lineValue2.getId()){
                    iteratorFirst.previous(); count;
                    break;

                }


            }
            if (lineValue1.getId() == oldId) {
                countSecondEquals
            }
            oldId = lineValue1.getId();
            Line lineValue2 = iteratorSecond.next();
            if (lineValue1.getId() == lineValue2.getId()) {
                countSecondEquals++;
                iteratorFirst.previous();
                result.add(new ResultLine(lineValue1, lineValue2));
            } else if (lineValue1.getId() < lineValue2.getId()) {
                iteratorSecond.previous();
                result.add(new ResultLine(lineValue1));
            } else if (lineValue1.getId() > lineValue2.getId()) {
                iteratorFirst.previous();
            }

        }

        return result;
    }

    public HashMap<Integer, ArrayList<ValueMap>> leftJoin(HashMap<Integer, ArrayList<String>> firstMap,
                                                          HashMap<Integer, ArrayList<String>> secondMap) {

        HashMap<Integer, ArrayList<ValueMap>> result = new HashMap<>();

        for (Map.Entry<Integer, ArrayList<String>> entry1 : firstMap.entrySet()) {
            ArrayList<ValueMap> arrList = new ArrayList<>();
            if (secondMap.containsKey(entry1.getKey())) {
                for (String line : entry1.getValue()) {

                    for (String line2 : secondMap.get(entry1.getKey())) {
                        arrList.add(new ValueMap(line, line2));
                    }
                }
            } else {
                for (String line : entry1.getValue()) {
                    arrList.add(new ValueMap(line));
                }

            }
            result.put(entry1.getKey(),arrList);
        }


        return result;

    }
}


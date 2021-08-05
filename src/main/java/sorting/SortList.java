package sorting;

import readfilelist.Line;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.*;

public class SortList {
    public LinkedList<Line> sortingToLinkedList(List<Line> list){
        LinkedList<Line> result = new LinkedList<>(list);
        result.sort(Comparator.comparing(Line::getId));
        return result;
    }
}


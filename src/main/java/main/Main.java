package main;


import leftjoin.LeftJoin;
import readfilelist.Line;
import readfilelist.ReadFile;
import sorting.SortList;
import sorting.TransferMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        if (args.length == 0 ) {
            System.out.println("The path to the file is not specified correctly");
            return;
        }
        String filePathList1 = args[0];
        String filePathList2 = args[1];
        LeftJoin leftJoin = new LeftJoin();
        ReadFile readFile = new ReadFile();


        ArrayList <Line> firstList =readFile.readFile(filePathList1);
        ArrayList <Line> secondList = readFile.readFile(filePathList2);
      /*  System.out.println(firstList);
        System.out.println(secondList);
        System.out.println(leftJoin.leftJoin(firstList,secondList));
*/

        SortList sortList = new SortList();
        LinkedList <Line> firstLinkedList =sortList.sortingToLinkedList(firstList);
        LinkedList <Line> secondLinkedList =sortList.sortingToLinkedList(secondList);
      /*  System.out.println(firstLinkedList);
        System.out.println(secondLinkedList);
        System.out.println(leftJoin.leftJoin(firstLinkedList,secondLinkedList));

*/
        TransferMap transferMap = new TransferMap();
        HashMap <Integer,ArrayList<Line>> firstMap = transferMap.transferToHashMap(firstList);
        HashMap <Integer,ArrayList<Line>> secondMap = transferMap.transferToHashMap(secondList);
        System.out.println(firstMap);
        System.out.println(secondMap);
        System.out.println(leftJoin.leftJoin(firstMap,secondMap));

    }
}

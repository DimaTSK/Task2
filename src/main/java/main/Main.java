package main;


import leftjoin.LeftJoin;
import readfilelist.Line;
import readfilelist.ReadFile;
import sorting.SortList;
import sorting.TransferMap;
import writeFile.WriteFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        if (args.length < 5 ) {
            System.out.println("The path to the file is not specified correctly");
            return;
        }
        String filePathList1 = args[0];
        String filePathList2 = args[1];
        String pathArr = args[2];
        String pathLink = args[3];
        String pathMap =args[4];

        LeftJoin leftJoin = new LeftJoin();
        ReadFile readFile = new ReadFile();
        TransferMap transferMap = new TransferMap();
        SortList sortList = new SortList();
        WriteFile writeFileArr = new WriteFile(pathArr);
        WriteFile writeFileLink = new WriteFile(pathLink);
        WriteFile writeFileMap = new WriteFile(pathMap);

        ArrayList <Line> firstList =readFile.readFile(filePathList1);
        ArrayList <Line> secondList = readFile.readFile(filePathList2);

        LinkedList <Line> firstLinkedList =sortList.sortingToLinkedList(firstList);
        LinkedList <Line> secondLinkedList =sortList.sortingToLinkedList(secondList);

        HashMap <Integer,ArrayList<String>> firstMap = transferMap.transferToHashMap(firstList);
        HashMap <Integer,ArrayList<String>> secondMap = transferMap.transferToHashMap(secondList);

        writeFileArr.writeFileList(leftJoin.leftJoin(firstList,secondList), "Таблица Result");


        writeFileLink.writeFileList(leftJoin.leftJoin(firstLinkedList,secondLinkedList),"Таблица Result");


        writeFileMap.writeFileMap(leftJoin.leftJoin(firstMap,secondMap),"Таблица Result");
    }
}

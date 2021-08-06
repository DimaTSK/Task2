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
        LeftJoin leftJoin = new LeftJoin();
        ReadFile readFile = new ReadFile();

        String pathArr = args[2];
        String pathLink = args[3];
        String pathMap =args[4];



        ArrayList <Line> firstList =readFile.readFile(filePathList1);
        ArrayList <Line> secondList = readFile.readFile(filePathList2);


        SortList sortList = new SortList();
        LinkedList <Line> firstLinkedList =sortList.sortingToLinkedList(firstList);
        LinkedList <Line> secondLinkedList =sortList.sortingToLinkedList(secondList);



        TransferMap transferMap = new TransferMap();
        HashMap <Integer,ArrayList<Line>> firstMap = transferMap.transferToHashMap(firstList);
        HashMap <Integer,ArrayList<Line>> secondMap = transferMap.transferToHashMap(secondList);


        WriteFile writeFileArr = new WriteFile(pathArr);
        writeFileArr.writeFileArr(firstList,"Таблица 1");
        writeFileArr.writeFileArr(secondList, "Таблица 2");
        writeFileArr.writeFileArr(leftJoin.leftJoin(firstList,secondList), "Таблица Result");

        WriteFile writeFileLink = new WriteFile(pathLink);
        writeFileLink.writeFileLink(firstLinkedList,"Таблица 1");
        writeFileLink.writeFileLink(secondLinkedList,"Таблица 2");
        writeFileLink.writeFileLink(leftJoin.leftJoin(firstLinkedList,secondLinkedList),"Таблица Result");


        WriteFile writeFileMap = new WriteFile(pathMap);
        writeFileMap.writeFileMap(firstMap,"Таблица 1");
        writeFileMap.writeFileMap(secondMap, "Таблица 2");
        writeFileMap.writeFileMap(leftJoin.leftJoin(firstMap,secondMap),"Таблица Result");
    }
}

package jcf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lists {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String allElements = reader.readLine();
        List<Integer> bigList = createBigList(allElements);

        //add the necessary elements from bigList to div2list,div3list,otherlist and sort all three lists
        ArrayList<Integer> div2list = bigList.stream().filter(k->(k%2)==0).sorted().
                collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> div3list = bigList.stream().filter(k->(k%3)==0).sorted().
                collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> otherlist = bigList.stream().filter(k->(k%2)!=0 && (k%3)!=0).
                sorted().collect(Collectors.toCollection(ArrayList::new));


        //get result list from createListOfLists
        List<List<Integer>> resultList = createListOfLists(div2list, div3list, otherlist);

        //call printInLine() for resultList
        printInLine(resultList);
    }

    public static List<Integer> createBigList(String str){
        List<Integer> bigList = new ArrayList<Integer>();
        String[] strarr = str.split(" ");

        for(String s : strarr){
            bigList.add(Integer.parseInt(s));
        }
        return bigList;
    }

    public static List<List<Integer>> createListOfLists(List<Integer> div2list, List<Integer> div3list ,List<Integer> otherList){
        //add all lists like items in resultList(list of lists) and return it, first-div2list, second-div3list, third-otherList
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(div2list);
        resultList.add(div3list);
        resultList.add(otherList);
        return resultList;
    }

    private static void printInLine(List<List<Integer>> resultList) {
        StringJoiner joiner = new StringJoiner(";");
        for (int i = 0; i < resultList.size(); i++) {
            StringJoiner tempJoiner = new StringJoiner(" ");
            for (Integer integer : resultList.get(i)) {
                tempJoiner.add(integer + "");
            }
            joiner.add(tempJoiner.toString());
        }
        System.out.println(joiner);
    }
}

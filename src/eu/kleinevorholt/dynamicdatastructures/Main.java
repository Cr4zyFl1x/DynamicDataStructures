package eu.kleinevorholt.dynamicdatastructures;

import eu.kleinevorholt.dynamicdatastructures.list.List;

public class Main {

    public static void main(String[] args) {

        List<String> l1 = new List<>(new String[]{"A", "B", "C", "D"});
        List<String> l2 = new List<>(new String[]{"E", "F", "G", "H"});


        List<Integer> l3 = new List<>(new Integer[]{1,2,3,4,5,6,7,8,9});
        List<Integer> l4 = new List<>(l3);

        l4.print();
    }
}

package hackerrank.contest.gr;

import com.landawn.abacus.util.N;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PowerSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet baseSet = new HashSet<Integer>();
        baseSet.add(in.nextInt());
        while (in.hasNextInt()){
            baseSet.add(in.nextInt());
        }

        Set<Set<Integer>> powerSetRes = powerSet(baseSet);
        for (Set<Integer> hs : powerSetRes) {
            displaySet(hs);
        }
        System.out.println("{}");



//        baseSet.stream().forEach( x -> System.out.println(x));

    }

    private static void displaySet(Set<Integer> hs) {

        System.out.println("{" + N.join(hs.toArray()) + "}");
    }

    public static Set<Set<Integer>> powerSet(final Set<Integer> mySet) {
        if (mySet.size() == 1 ){
            HashSet<Set<Integer>> res = new HashSet<>();
            res.add(mySet);
            res.add(new HashSet<>());
            return res;
        }


        int head = mySet.iterator().next(); //mySet has one element less
        mySet.remove(head);
        Set<Integer> tail = mySet;
        Set<Set<Integer>> powerOfRest = powerSet(new HashSet<>(tail));
        HashSet<Set<Integer>> res = new HashSet<>();

        for (Set<Integer> hs : powerOfRest) {
            res.add(hs);
            Set<Integer> hsAugmented = new HashSet<>(hs);
            hsAugmented.add(head);
        }
        return res;
    }




//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        HashSet baseSet = new HashSet<Integer>();
//        baseSet.add(in.nextInt());
//        while (in.hasNextInt()){
//            baseSet.add(in.nextInt());
//        }
//
//        HashSet<HashSet<Integer>> powerSetRes = powerSet(baseSet);
//        for (HashSet<Integer> hs : powerSetRes) {
//            displaySet(hs);
//        }
//        System.out.println("{}");
//
//
//
////        baseSet.stream().forEach( x -> System.out.println(x));
//
//    }
//
//    private static void displaySet(HashSet<Integer> hs) {
//
//        System.out.println("{" + N.join(hs.toArray()) + "}");
//    }
//
//    public static HashSet<HashSet<Integer>> powerSet(final HashSet<Integer> mySet) {
//        if (mySet.size() == 1 ){
//            HashSet<HashSet<Integer>> res = new HashSet<>();
//            res.add(mySet);
//            res.add(mySet);
//            return res;
//        }
//
//        if (mySet.isEmpty()) {
//            HashSet<HashSet<Integer>> res = new HashSet<>();
//            res.add(new HashSet<>());
//            return res;
//        }
//
//        int eltToAdd = mySet.iterator().next(); //mySet has one element less
//        mySet.remove(eltToAdd);
//        HashSet<HashSet<Integer>> intermediateSet = powerSet(new HashSet<>(mySet));
//        HashSet<HashSet<Integer>> intermediateSet2 = powerSet(new HashSet<>(mySet));
//        for (HashSet<Integer> hs : intermediateSet2) {
//            hs.add(eltToAdd);
//        }
//        intermediateSet.addAll(intermediateSet2);
//        return intermediateSet;
//    }
}

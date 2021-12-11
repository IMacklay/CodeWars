

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubtractsArrays {

    public static void main(String[] args) {

        int[] a = {1,2,2,7};
        int[] b = {7,9,10};


        System.out.println( Arrays.toString(arrayDiff(a,b)) );
    }

    public static int[] arrayDiff(int[] a, int[] b) {
//        Set<Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());
//        return Arrays.stream(a).filter(x->!setB.contains(x)).toArray();
        //Best
        return IntStream.of(a).filter( x-> IntStream.of(b).noneMatch(y -> y == x) ).toArray();
    }
}

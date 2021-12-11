

public class PrimesInNumbers {
    public static String factors(int n) {

        int prime=2;

        String result="";
        int countResult=0;
        int tempEval=n;

        for (int i=0; i<n; i++){

            if (tempEval%prime==0) {
                countResult++;
                tempEval = tempEval / prime;
            }else {
                if (countResult>0)
                    result = result +  "("+(countResult==1 ? prime : prime + "**" + countResult )+")";
                countResult = 0;
                prime = getNextPrime(prime,tempEval);
            }

            if (prime == 1) break;
        }

        return result;
    }

    private static int getNextPrime(int currentPrime, int sizeN){

        int nextPrimeDigits = sizeN;
        for(int i=currentPrime+1; i<sizeN; i++){
            if (i%2==0) continue;
            if (sizeN % i == 0) {
                nextPrimeDigits = i;
                break;
            }
        }
        System.out.println(nextPrimeDigits);
        return nextPrimeDigits;
    }

    //Best practices
    public static String factorsBest(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }
            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }
}

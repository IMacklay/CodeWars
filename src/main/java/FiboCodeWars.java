

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class FiboCodeWars {
    public static void main(String[] args) {

        long timeStart;
        long timeEnd;


        timeStart = System.currentTimeMillis();
        BigInteger Res = fibonacci(new BigInteger("-10"));
        timeEnd = System.currentTimeMillis();
        System.out.println("Time Evalute Fibonacci of Matrix is - "+(timeEnd-timeStart)+" ms.");

        System.out.println(Res);
    }
    //Dinamic variable evalute - normal speed
    private static BigInteger fib(BigInteger n){

        long SizeSequence = n.abs().longValue();
        if (SizeSequence==0 || SizeSequence==1) return n;

        String sign = "";
        if (n.longValue()<0) sign = "-";

        BigInteger resFibo = new BigInteger("0");
        BigInteger pz1 = new BigInteger("0");
        BigInteger pz2 = new BigInteger(sign+"1");


//        System.out.println(pz1);
//        System.out.println(pz2);

        for(int i=1; i<SizeSequence; i++){

            resFibo = pz1.add(pz2);
            pz1 = pz2;
            pz2 = resFibo;

            //System.out.println(resFibo);
        }


        if ( SizeSequence % 2 != 0 && sign.equals("-") )  {
            resFibo = resFibo.negate();
        }

        return resFibo;
    }

    //Out heap space
    private static BigInteger fibNew(BigInteger n){
        int sizeSequence = Math.abs(n.intValue());

        if (sizeSequence == 0 || sizeSequence == 1)
            return n;

        BigInteger[] masFibo = new BigInteger[sizeSequence+1];
        masFibo[0] = BigInteger.ZERO;
        masFibo[1] = BigInteger.ONE;

        System.out.println(masFibo[0]);
        System.out.println(masFibo[1]);

        for(int i=2; i<sizeSequence+1;i++){
            masFibo[i] = masFibo[i-1].add(masFibo[i-2]);

            System.out.println(masFibo[i]);
        }

        BigInteger resFibo = masFibo[masFibo.length-1];
        if ( sizeSequence % 2 == 0 && n.longValue()<0){
            resFibo = resFibo.negate();
        }

        return resFibo;
    }

    static Map<Integer, BigInteger> memo = new HashMap<>();
    //StackOverFlow
    private static BigInteger fibRecurs(int n){


        long SizeSequence = Math.abs(n);
        if (SizeSequence==0 || SizeSequence==1) return BigInteger.valueOf(n);


        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        BigInteger v = fibRecurs(n - 2).add(fibRecurs(n - 1));
        memo.put(n, v);
        return v;
    }

    //Dynamic massive evalute - faster than variable
    private static BigInteger fibMas(BigInteger n){

        long sizeSequence = n.longValue();


        if (sizeSequence==0 || sizeSequence==1) return n;

        boolean isNegative = false;
        if (sizeSequence<0){
            isNegative = true;
            sizeSequence = Math.abs(sizeSequence);
        }

        BigInteger[] masFib = new BigInteger[2];

        masFib[0] = BigInteger.ONE;
        masFib[1] = BigInteger.ONE;

        int i = 2;
        do{
            masFib[i%2] = masFib[0].add(masFib[1]);
            i++;
            //System.out.println(i-1+" -> "+masFib[i%2]);
        }while (sizeSequence>=i);


        BigInteger fiboRes = masFib[i%2];
        if ( sizeSequence % 2 == 0 && isNegative)  {
            fiboRes=fiboRes.negate();
        }

        return fiboRes;
    }



    //Matrix evalute
    // матричное умножение двух матриц размера 2 на 2
    public static BigInteger[][] matrixMultiplication(BigInteger[][] a, BigInteger[][] b) {
        // [a00 * b00 + a01 * b10, a00 * b01 + a01 * b11]
        // [a10 * b00 + a11 * b10, a10 * b01 + a11 * b11]
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))},
        };
    }

    // возведение матрицы размера 2 на 2 в степень n
    public static BigInteger[][] matrixPowerFast(BigInteger[][] a, long n) {
        if (n == 0) {
            // любая матрица в нулевой степени равна единичной матрице
            return new BigInteger[][]{
                    {BigInteger.ONE, BigInteger.ZERO},
                    {BigInteger.ZERO, BigInteger.ONE}
            };
        } else if (n % 2 == 0) {
            // a ^ (2k) = (a ^ 2) ^ k
            return matrixPowerFast(matrixMultiplication(a, a), n / 2);
        } else {
            // a ^ (2k + 1) = (a) * (a ^ 2k)
            return matrixMultiplication(matrixPowerFast(a, n - 1), a);
        }
    }

    // функция, возвращающая n-ое число Фибоначчи
    public static BigInteger fibonacci(BigInteger n) {

        long sizeSequence = n.longValue();
        if (sizeSequence==0 || sizeSequence==1) return n;

        boolean isNegative = false;
        if (sizeSequence<0){
            isNegative = true;
            sizeSequence = Math.abs(sizeSequence);
        }


        BigInteger[][] a = {
                {BigInteger.ONE, BigInteger.ONE},
                {BigInteger.ONE, BigInteger.ZERO}
        };

        BigInteger[][] powerOfA = matrixPowerFast(a, sizeSequence - 1);
        // nthFibonacci = powerOfA[0][0] * F_1 + powerOfA[0][0] * F_0 = powerOfA[0][0] * 1 + powerOfA[0][0] * 0
        BigInteger nthFibonacci = powerOfA[0][0];

        if ( sizeSequence % 2 == 0 && isNegative)  {
            nthFibonacci=nthFibonacci.negate();
        }

        return nthFibonacci;
    }

}

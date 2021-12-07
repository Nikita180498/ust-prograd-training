package Day3;

public class SumOfCube{
    public static long sumCubes(long n)
    {
        long sum = 0;
        for (int x = 1; x <= n; x++)
            sum += (long)x * x * x;
        return sum;
    }

}
package main.java.problem187;

public class Euler_187
{
    public static void main( String[] args )
    {
        long time = System.currentTimeMillis();

        int Limit = 100000000;
        byte[] sieb = new byte[Limit];
        for ( int p = 2; p < Limit; p++ )
        {
            if ( sieb[p] == 0 ) // weitere Primzahl p gefunden
            {
                for ( int j = 1; j*p < Limit; j++ )
                {
                    sieb[j*p]++;
                    int t = j;
                    while ( t%p == 0 )
                    {
                        sieb[j*p]++;
                        t = t / p;
                    }
                }
            }
        }

        int result = 0;
        for ( int i = 0; i < sieb.length; i++ )
        {
            if ( sieb[i] == 2 ) result++;
        }

        System.out.println( "Result: " + result );

        System.out.println( "Time (s): " + ( System.currentTimeMillis() - time ) / 1000. );
    }
/*************************************************/
    /*           functions and subroutines           */
/*************************************************/
}

// 17427258
/*
Result: 17427258
Time (s): 59.526
*/
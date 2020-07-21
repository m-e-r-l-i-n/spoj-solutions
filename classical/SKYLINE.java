problem link-https://www.spoj.com/problems/SKYLINE/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i,j,N=1000;
        int a[][]=new int[N+1][N+1];
        for(i=0;i<=N;i++)   //find n'th Catalan number
        for(j=0;j<=i;j++)
        if(j==0) a[i][j]=1;
        else a[i][j]=(a[i-1][j]+a[i][j-1])%1000000;
        int n=Integer.parseInt(bu.readLine());
        while(n!=0)
        {
            sb.append(a[n][n]+"\n");
            n=Integer.parseInt(bu.readLine());
        }
        System.out.print(sb);
    }
}

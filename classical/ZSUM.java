problem link-https://www.spoj.com/problems/ZSUM/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bu.readLine().trim());
        int n=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
        while(n!=0 && k!=0)
        {
            long M=10000007,ans=power(n,k,M)+power(n,n,M);
            ans%=M;
            ans+=(power(n-1,n-1,M)+power(n-1,k,M))*2%M;
            ans%=M;
            sb.append(ans+"\n");

            st=new StringTokenizer(bu.readLine().trim());
            n=Integer.parseInt(st.nextToken()); k=Integer.parseInt(st.nextToken());
        }
        System.out.print(sb);
    }

    static long power(long a,long b,long M)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}

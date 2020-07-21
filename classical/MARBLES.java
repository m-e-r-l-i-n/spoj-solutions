problem link-https://www.spoj.com/problems/MARBLES/

import java.io.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]),i;
            if(n-k<k-1) k=n-k+1;
            long res=1;
            for(i=1;i<k;i++)
                res=res*(n-i)/i;
            sb.append(res+"\n");
        }
        System.out.print(sb);
    }
}

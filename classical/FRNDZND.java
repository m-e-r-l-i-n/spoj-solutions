problem link-https://www.spoj.com/problems/FRNDZND/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bu.readLine());
        int n=Integer.parseInt(st.nextToken()),q=Integer.parseInt(st.nextToken());
        int i,a[]=new int[n],l,r;
        st=new StringTokenizer(bu.readLine());
        for(i=0;i<n;i++)
        a[i]=Integer.parseInt(st.nextToken());

        while(q-->0)
        {
            st=new StringTokenizer(bu.readLine());
            l=Integer.parseInt(st.nextToken()); r=Integer.parseInt(st.nextToken());
            l--; r--;
            if(l==r) sb.append(a[l]+"\n");
            else sb.append("0\n");
        }
        System.out.print(sb);
    }
}

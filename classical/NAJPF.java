problem link-https://www.spoj.com/problems/NAJPF/

import java.io.*;
import java.util.*;

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
            char a[]=s[0].toCharArray(),b[]=s[1].toCharArray();
            int i,j,n=a.length,m=b.length,lps[]=new int[m];
            j=0;    //j is len of lps
            i=1;
            while(i<m)  //computing lps array
            {
                if(b[i]==b[j]) lps[i++]=++j;
                else
                {
                    if(j!=0) j=lps[j-1];
                    else lps[i++]=j;
                }
            }

            i=0; j=0;
            ArrayList<Integer> al=new ArrayList<>();
            while(i<n)	//finding patterns(KMP Algorithm)
            {
                if(a[i]==b[j]) {j++; i++;}
                if(j==m)
                {al.add(i-j+1); j=lps[j-1];}
                else if(i<n && a[i]!=b[j])
                {
                    if(j!=0) j=lps[j-1];
                    else i++;
                }
            }
            if(al.size()==0) sb.append("Not Found\n\n");
            else
            {
                sb.append(al.size()+"\n");
                for(i=0;i<al.size();i++)
                    sb.append(al.get(i)+" ");
                sb.append("\n\n");
            }
        }
        System.out.print(sb);
    }
}

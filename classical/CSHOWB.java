problem link-https://www.spoj.com/problems/CSHOWB/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),p=Integer.parseInt(s[1]),i,ans=0;
        Stack<Integer> st[]=new Stack[6];
        for(i=0;i<6;i++)
            st[i]=new Stack<>();
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            int x=Integer.parseInt(s[0])-1,f=Integer.parseInt(s[1]);
            while(!st[x].isEmpty() && st[x].peek()>f)
            {
                ans++;
                st[x].pop();
            }
            if(!st[x].isEmpty() &&st[x].peek()==f)
            {
                ans--;
                st[x].pop();
            }
            st[x].push(f);
            ans++;
        }
        System.out.print(ans);
    }
}

problem link-https://www.spoj.com/problems/HISTOGRA/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        while(n!=0)
        {
            int i,a[]=new int[n];
            for(i=1;i<=n;i++)
            a[i-1]=Integer.parseInt(s[i]);

            Stack<Integer> st=new Stack<>();
            i=0;
            long ans=0,cur;
            while(i<n)
            {
                if(st.isEmpty() || a[st.peek()]<=a[i]) st.push(i++);
                else
                {
                    int t=st.pop();
                    cur=1l*a[t]*(st.isEmpty()?i:i-st.peek()-1);
                    ans=Math.max(ans,cur);
                }
            }

            while(!st.isEmpty())
            {
                int t=st.pop();
                cur=1l*a[t]*(st.isEmpty()?i:i-st.peek()-1);
                ans=Math.max(ans,cur);
            }
            sb.append(ans+"\n");
            s=bu.readLine().split(" ");
            n=Integer.parseInt(s[0]);
        }
        System.out.print(sb);
    }
}

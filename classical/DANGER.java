problem link-https://www.spoj.com/problems/DANGER/

import java.io.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s=bu.readLine();
        int n=getnumber(s);
        while(n!=0)
        {
            int i=1;
            while(i<=n) i*=2;
            i/=2;
            int ans=2*(n-i)+1;  //Josephus problem
            sb.append(ans+"\n");
            s=bu.readLine();
            n=getnumber(s);
        }
        System.out.print(sb);
    }

    static int getnumber(String s)
    {
        String an=""+s.charAt(0)+s.charAt(1);
        int c=Integer.parseInt(s.substring(3)),i;
        for(i=0;i<c;i++)
            an+='0';
        return Integer.parseInt(an);
    }
}

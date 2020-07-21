problem link-https://www.spoj.com/problems/HANGOVER/

import java.io.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        double n=Double.parseDouble(bu.readLine());
        while(n!=0)
        {
            int c=0,i=2; double v=0;
            while(v<n)
            {
                c++;
                v+=1.0/i;
                i++;
            }
            sb.append(c+" card(s)\n");
            n=Double.parseDouble(bu.readLine());
        }
        System.out.print(sb);
    }

}

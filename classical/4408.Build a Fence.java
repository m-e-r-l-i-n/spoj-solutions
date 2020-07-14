problem link-https://www.spoj.com/problems/FENCE1/

import java.io.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        while(n!=0)
        {
            double r=n;
            //find area enclosed by semi circle of arc length r
            r=(1/2.0)*r*r/Math.PI;
            sb.append(String.format("%.2f",r)+"\n");
            n=Integer.parseInt(bu.readLine());
        }
        System.out.print(sb);
    }
}

problem link-https://www.spoj.com/problems/ALLIZWEL/

import java.io.*;
class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        char w[]="ALLIZZWELL".toCharArray();
        while(t-->0)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]),i,j;
            char b[][]=new char[n][m];
            for(i=0;i<n;i++)
            {
                String st=bu.readLine();
                for(j=0;j<m;j++)
                b[i][j]=st.charAt(j);
            }

            boolean ans=false;
            for(i=0;i<n;i++)
            {
                for(j=0;j<m;j++)
                {
                    if(b[i][j]==w[0]) ans=dfs(b,w,0,n,m,i,j);
                    if(ans) break;
                }
                if(ans) break;
            }
            if(ans) sb.append("YES\n");
            else sb.append("NO\n");
            bu.readLine();
        }
        System.out.print(sb);
    }

    static boolean dfs(char b[][],char w[],int i,int n,int m,int r,int c)
    {
        if(i==10) return true;
        if(r<0 || r>=n || c<0 || c>=m) return false;
        if(b[r][c]!=w[i]) return false;

        b[r][c]^=256;
        i++;
        boolean check=false;
        int moves[]={1,0,-1},x,y;
        for(x=0;x<3;x++)
        for(y=0;y<3;y++)
        if(x==y && x==1) continue;
        else check|=dfs(b,w,i,n,m,r+moves[x],c+moves[y]);

        b[r][c]^=256;
        return check;
    }
}

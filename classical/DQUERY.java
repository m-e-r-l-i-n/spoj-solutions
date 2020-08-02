problem link-https://www.spoj.com/problems/DQUERY/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String[] args)throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bu.readLine()),q;
        int a[]=new int[n],i;
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(s[i]);

        q=Integer.parseInt(bu.readLine());
        Query[] queries=new Query[q];
        for(i=0;i<q;i++)
        {
            queries[i]=new Query();
            s=bu.readLine().split(" ");
            queries[i].l=Integer.parseInt(s[0])-1;
            queries[i].r=Integer.parseInt(s[1])-1;
            queries[i].idx=i;
        }

        Arrays.sort(queries, new Comparator<Query>()
        {
            public int compare(Query x, Query y)
            {
                if(x.r<y.r) return -1;
                else if(x.r==y.r) return 0;
                else return 1;
            }});
        answeringQueries(a, n, queries, q);
    }

    static class Query
    {
        int l, r, idx;
    }

    static void update(int i,int v,int bit[],int n)
    {
        while(i<=n)
        {
            bit[i]+=v;
            i+=i&(-i);
        }
    }

    static int query(int i,int bit[])
    {
        int sum=0;
        while(i>0)
        {
            sum+=bit[i];
            i-=i&-i;
        }
        return sum;
    }

    static void answeringQueries(int a[], int n, Query[] queries, int q)
    {
        int[] bit=new int[n+1],last_visit=new int[1000001];
        Arrays.fill(last_visit,-1);

        int ans[]=new int[q],c=0,i;
        for(i=0;i<n;i++)
        {
            if(last_visit[a[i]]!=-1) update(last_visit[a[i]]+1,-1,bit,n);
            last_visit[a[i]]=i;
            update(i+1,1,bit,n);
            while(c<q && queries[c].r==i)
            {
                ans[queries[c].idx]=query(queries[c].r+1,bit)-query(queries[c].l,bit);
                c++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(i=0;i<q;i++)
        sb.append(ans[i]+"\n");
        System.out.print(sb);
    }
}

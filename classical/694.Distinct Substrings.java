problem link-https://www.spoj.com/problems/DISUBSTR/

import java.io.*;
import java.util.*;

class Spoj
{
    static int N=100000,rank[]=new int[N],pos[]=new int[N],cnt[]=new int[N],next[]=new int[N];
    static boolean bh[]=new boolean[N],b2h[]=new boolean[N];
    static char s[];

    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            s=bu.readLine().toCharArray();
            int i,n=s.length,ans=n*(n+1)/2;
            suffixsort(n);
            height(n);
            for(i=0;i<n;i++)
                ans-=height[i];
            sb.append(ans+"\n");
        }
        System.out.print(sb);
    }

    static int height[]=new int[N];

    static void suffixsort(int n)
    {
        int i,k,pos2[][]=new int[n][2];
        for(i=0;i<n;i++)
        {
            pos2[i][0]=i;
            pos2[i][1]=s[i];
        }
        Arrays.sort(pos2, new Comparator<int[]>() {
            public int compare(int o1[],int o2[])
            {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]>o2[0]?1:-1;
                else return -1;
            }});

        for(i=0;i<n;++i)
        {
            pos[i]=pos2[i][0];
            bh[i]= i==0 || s[pos[i]]!=s[pos[i-1]];
            b2h[i]=false;
        }

        for(k=1;k<n;k<<=1)
        {
            int buckets=0,j;
            for(i=0;i<n;i=j)
            {
                j=i+1;
                while(j<n && !bh[j]) j++;
                next[i]=j;
                buckets++;
            }
            if(buckets==n) break;
            for(i=0;i<n;i=next[i])
            {
                cnt[i]=0;
                for(j=i;j<next[i];++j)
                    rank[pos[j]]=i;
            }

            cnt[rank[n-k]]++;
            b2h[rank[n-k]]=true;
            for(i=0;i<n;i=next[i])
            {
                for(j=i;j<next[i];++j)
                {
                    int s=pos[j]-k;
                    if(s>=0)
                    {
                        int head=rank[s];
                        rank[s]=head+cnt[head]++;
                        b2h[rank[s]]=true;
                    }
                }

                for(j=i;j<next[i];++j)
                {
                    int s=pos[j]-k;
                    if(s>=0 && b2h[rank[s]])
                        for(int l=rank[s]+1;!bh[l] && b2h[l];l++) b2h[l]=false;
                }
            }
            for(i=0;i<n;i++)
            {
                pos[rank[i]]=i;
                bh[i]|=b2h[i];
            }
        }
        for(i=0;i<n;++i)
            rank[pos[i]]=i;
    }

    static void height(int n)   //Kasai's algorithm
    {
        int i,h;
        for(i=0;i<n;i++) rank[pos[i]]=i;
        height[0]=0;
        for(i=0,h=0;i<n;++i)
        if(rank[i]>0)
        {
            int j=pos[rank[i]-1];
            while(i+h<n && j+h<n && s[i+h]==s[j+h]) h++;
            height[rank[i]]=h;
            if(h>0) h--;
        }
    }
}

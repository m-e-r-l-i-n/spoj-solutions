problem link-https://www.spoj.com/problems/LCA/

//problem specifically designed for c++ only(other languages wont pass the given time limit)

#include<bits/stdc++.h>
using namespace std;
int main()
{
    int t,c=0,d[1005],dp[1005][12];
    scanf("%d",&t);
    while(t--)
    {
        int n,x,i,j;
        scanf("%d",&n);
        vector<int> g[n+1];
        for(i=1;i<=n;i++)
        {
            int m,k;
            scanf("%d",&m);
            for(j=0;j<m;j++)
            {
                scanf("%d",&k);
                g[i].push_back(k);
                g[k].push_back(i);
            }
        }

        bool vis[n+1];
        memset(vis,false,sizeof(vis));
        queue<int> q,l;
        q.push(1); l.push(1);
        dp[1][0]=1;
        while(!q.empty())   //find depths
        {
            int cur=q.front(),lv=l.front();
            q.pop(); l.pop();
            vis[cur]=true;
            d[cur]=lv;
            for(auto v:g[cur])
            if(!vis[v])
            {
                dp[v][0]=cur;
                q.push(v);
                l.push(lv+1);
            }
        }

        for(j=1;(1<<j)<=n;j++)    //generate sparse matrix
        for(i=1;i<=n;i++)
            dp[i][j]=dp[dp[i][j-1]][j-1];

        scanf("%d",&x);
        printf("Case %d:\n",++c);
        while(x--)
        {
            int u,v;
            scanf("%d%d",&u,&v);
            if(d[u]<d[v]) u=u^v^(v=u);
            int dif=(int)log2(d[u]);
            for(i=dif;i>=0;i--)
                if(d[u]-(1<<i)>=d[v]) u=dp[u][i];
            if(u==v) {printf("%d\n",u); continue;}

            for(i=dif;i>=0;i--)
            if(dp[u][i]!=dp[v][i])
            {
                u=dp[u][i];
                v=dp[v][i];
            }
            printf("%d\n",dp[u][0]);
        }
    }
    return 0;
}

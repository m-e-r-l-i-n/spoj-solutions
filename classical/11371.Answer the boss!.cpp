problem link-https://www.spoj.com/problems/RPLA/

//this problem has been specifically designed not to run on java(except a highly optimized ip/op version)..so this is the cpp equivalent of the java code

#include<bits/stdc++.h>
using namespace std;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int t,cnt=1;
    scanf("%d",&t);
    while(t--)
    {
        int n,r,i;
        scanf("%d%d",&n,&r);
        vector<int> g[n]; bool vis[n]; int deg[n];
        for(i=0;i<n;i++)
        {
            g[i].clear();
            vis[i]=false;
            deg[i]=0;
        }

        for(i=0;i<r;i++)
        {
            int l,f;
            scanf("%d%d",&l,&f);
            g[f].push_back(l);
            deg[l]++;
        }

        queue<pair<int,int>> q;
        vector<pair<int,int>> ans;
        for(i=0;i<n;i++)
        if(deg[i]==0)
        {
            q.push({i,1});
            vis[i]=true;
        }

        while(!q.empty())
        {
            pair<int,int> x;
            x.first=q.front().first;
            x.second=q.front().second;
            q.pop();
            ans.push_back({x.second,x.first});
            for(i=0;i<g[x.first].size();i++)
            if(!vis[g[x.first][i]])
            {
                deg[g[x.first][i]]--;
                if(deg[g[x.first][i]]==0)
                {
                    q.push({g[x.first][i],x.second+1});
                    vis[g[x.first][i]]=true;
                }
            }
        }

        sort(ans.begin(),ans.end());
        printf("Scenario #%d:\n",cnt);
        cnt++;
        for(i=0;i<ans.size();i++)
        printf("%d %d\n",ans[i].first,ans[i].second);
    }
    return 0;
}

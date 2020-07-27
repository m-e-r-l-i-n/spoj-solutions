problem link-https://www.spoj.com/problems/IITKWPCI/

//time limits probably too tight for java or python
#include<bits/stdc++.h>
using namespace std;

int c,val[1011];
bool vis[1011];
vector<int> g[1011];

void dfs(int n)
{
    val[n]=c;
    vis[n]=true;
    for(auto x:g[n])
    if(!vis[x])
    {
        vis[x]=true;
        dfs(x);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin>>t;
    while(t--)
    {
        int n,m,i,j;
        cin>>n>>m;
        int a[n],ans[n];
        for(i=0;i<n;i++)
        {
            g[i].clear();
            cin>>a[i];
            vis[i]=false;
            val[i]=-1;
        }

        for(i=0;i<m;i++)
        {
            int l,r;
            cin>>l>>r;
            l--; r--;
            g[l].push_back(r);
            g[r].push_back(l);
        }

        c=0;
        for(i=0;i<n;i++)
        if(!vis[i])
        {
            c++;
            dfs(i);
            vector<int> ac,bc;
            for(j=0;j<n;j++)
            if(val[j]==c)
            {
                ac.push_back(j);
                bc.push_back(a[j]);
            }
            sort(bc.begin(),bc.end());
            j=0;
            for(auto x:bc)
            {
                ans[ac[j]]=x;
                j++;
            }
        }

        for(i=0;i<n;i++)
        cout<<ans[i]<<" ";
        cout<<"\n";
    }
}

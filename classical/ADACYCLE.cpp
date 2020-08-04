problem link-https://www.spoj.com/problems/ADACYCLE/

#include<bits/stdc++.h>
using namespace std;

vector<int> g[2000];
bool v[2000];
int path(int n)
{
    queue<int> q,d;
    memset(v,false,sizeof(v));
    q.push(n); v[n]=true; d.push(1);
    while(!q.empty())
    {
        int p=q.front(),dis=d.front();
        q.pop(); d.pop();
        for(auto x:g[p])
        {
            if(x==n) return dis;
            if(!v[x])
            {
                v[x]=true;
                d.push(dis+1);
                q.push(x);
            }
        }
    }
    return -1;
}

int main()
{
    int n,i,j,k;
    scanf("%d",&n);
    for(i=0;i<n;i++)
    for(j=0;j<n;j++)
    {
        scanf("%d",&k);
        if(k) g[i].push_back(j);
    }

    for(i=0;i<n;i++)
    {
        k=path(i);
        if(k==-1) printf("NO WAY\n");
        else printf("%d\n",k);
    }
    return 0;
}

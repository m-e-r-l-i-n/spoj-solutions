problem link-https://www.spoj.com/problems/RPLN/

#include<bits/stdc++.h>
using namespace std;

int st[400000];

void update(int ss,int se,int i,int v,int n)
{
    if(i<ss || i>se) return;
    if(ss==se) st[n]=v;
    else
    {
        int m=ss+(se-ss)/2;
        if(i>=ss && i<=m) update(ss,m,i,v,2*n+1);
        else update(m+1,se,i,v,2*n+2);
        st[n]=min(st[2*n+1],st[2*n+2]);
    }
}

int query(int ss,int se,int qs,int qe,int n)
{
    if(qs<=ss && qe>=se) return st[n];
    if(se<qs || ss>qe) return INT32_MAX;

    int m=ss+(se-ss)/2;
    return min(query(ss,m,qs,qe,2*n+1),query(m+1,se,qs,qe,2*n+2));
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t,v=1;
    cin>>t;
    while(t--)
    {
        int i,n,q,a;
        cin>>n>>q;
        for(i=0;i<n;i++)
        {
            cin>>a;
            update(0,n-1,i,a,0);
        }
        cout<<"Scenario #"<<v<<":\n";
        v++;

        while(q--)
        {
            int x,y;
            cin>>x>>y;
            x--; y--;
            cout<<query(0,n-1,x,y,0)<<"\n";
        }
    }
    return 0;
}

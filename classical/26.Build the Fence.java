problem link-https://www.spoj.com/problems/BSHEEP/

import java.io.*;
import java.util.*;

class Spoj
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            bu.readLine();
            int i,n=Integer.parseInt(bu.readLine());
            ArrayList<Point> al=new ArrayList<>();
            HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
            for(i=0;i<n;i++)
            {
                StringTokenizer st=new StringTokenizer(bu.readLine());
                int l=Integer.parseInt(st.nextToken()),r=Integer.parseInt(st.nextToken());
                if(hm.get(l)==null)
                {
                    ArrayList<Integer> tem=new ArrayList<>();
                    tem.add(r);
                    hm.put(l,tem);
                }
                else
                {
                    if(hm.get(l).contains(r)) continue;
                    else hm.get(l).add(r);
                }
                al.add(new Point(l,r,i+1));
            }
            ArrayList<Point> fence=graham_scan(al);

            if(fence.size()==1) {sb.append("0.00\n"+fence.get(0).i+"\n\n"); continue;}
            double dis=0;
            for(i=1;i<fence.size();i++)
            dis+=Math.sqrt(distsq(fence.get(i),fence.get(i-1)));
            dis+=Math.sqrt(distsq(fence.get(fence.size()-1),fence.get(0)));
            sb.append(String.format("%.2f",dis)+"\n");

            for(Point x:fence)
                sb.append(x.i+" ");
            sb.append("\n\n");
        }
        System.out.print(sb);
    }

    static class Point
    {
        long x,y; int i;
        Point(long a,long b,int c)
        {
            x=a; y=b;
            i=c;
        }
    }

    static long distsq(Point a,Point b) //returns square of distance between 2 points
    {
        return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
    }

    static int orientation(Point a,Point b,Point c) //returns orientation of 3 points
    {
        long val=(b.y-a.y)*(c.x-b.x)-(c.y-b.y)*(b.x-a.x);

        if(val==0) return 0;
        return val>0?1:2;
    }

    static Point nextToTop(Stack<Point> s)
    {
        Point cur=s.pop();
        Point res=s.peek();
        s.push(cur);
        return res;
    }

    static ArrayList<Point> graham_scan(ArrayList<Point> al)    //get convex hull
    {
        if(al.size()<2) return al;
        int i,min=0;
        long ymin=al.get(0).y;
        for(i=1;i<al.size();i++)
            if(al.get(i).y<ymin || (al.get(i).y==ymin && al.get(i).x<al.get(min).x))
            {ymin=al.get(i).y; min=i;}

        Point t=al.get(min);
        Collections.sort(al,new Comparator<Point>(){
            public int compare(Point a,Point b)
            {
                int o=orientation(t,a,b);
                if(o==0) return distsq(t,b)>=distsq(t,a)?-1:1;
                return o==2?-1:1;
            }});
        Point pn=al.get(al.size()-1);
        int idx=1,n=al.size();
        for(i=1;i<n;i++)    //equal points or on same line(need not be considered)
        {
            while(i<n-1 && orientation(t,al.get(i),al.get(i+1))==0) i++;
            al.set(idx++,al.get(i));
        }

        Stack<Point> s=new Stack<>();
        s.push(al.get(0)); s.push(al.get(1));
        if(idx>2) s.push(al.get(2));
        else return new ArrayList<>(s);
        for(i=3;i<idx;i++)  //gets all required points in anticlockwise direction
        {
            while(orientation(nextToTop(s),s.peek(),al.get(i))!=2) s.pop();
            s.push(al.get(i));
        }
        return new ArrayList<>(s);
    }
}

problem link-https://www.spoj.com/problems/TDKPRIME/

import java.io.*;
import java.util.*;

class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bu.readLine());
		StringBuilder sb=new StringBuilder();
		
		//bitwise Sieve of Eratosthenes
		ArrayList<Integer> primes=new ArrayList<>();
		int i,maxs=87000000;
		// Assuming that n takes 32 bits, we reduce size to n/64 from n/2. 
        int pr[]=new int[maxs/64+1]; 
    	primes.add(2);
    	/*2 is the only even prime so we can ignore that 
        loop starts from 3 as we have used in sieve of Eratosthenes*/ 
        for(i=3; i*i<=maxs; i+=2) 
        {
        	// If i is prime, mark all its multiples as composite 
            /*int ifnotPrime(int prime[],int x)
            {
            	checking whether the value of element is set or not. 
        		Using prime[x/64], we find the slot in prime array.  
        		To find the bit number, we divide x by 2 and take its mod with 32. 
        		return (prime[x/64]&(1<<((x>>1)&31)));
        	}*/
            if((pr[i/64]&(1<<((i>>1)&31)))==0) 
            for(int j=i*i,k=i<<1; j<maxs;j+=k) 
            /*Marks x composite in prime[] 
    		static void makeComposite(int prime[], int x) 
    		{ 
        		Set a bit corresponding to given element. 
        		Using prime[x/64], we find the slot in prime array. To find the bit number, we divide x by 2 and take its mod with 32. 
        		prime[x/64] |=(1<<((x>>1)&31));
        	}*/
        	pr[j/64] |=(1<<((j>>1)&31));
        }
        for(i=3;i<=maxs;i+=2) 
        if((pr[i/64]&(1<<((i>>1)&31)))==0) 
        primes.add(i);
        
    	while(t-->0)
		{
			int n=Integer.parseInt(bu.readLine())-1;
			sb.append(primes.get(n)+"\n");
		}
		System.out.print(sb);
	}
}

# march16_2025
The problem that i solved today in leetcode

1.You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.

Return the minimum time taken to repair all the cars.

Note: All the mechanics can repair the cars simultaneously.

Code:
Sclass Solution {
    public long repairCars(int[] ranks, int cars) {
        long l=1,r,ans=0;
        long min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int x:ranks)
        {
            min=Math.min(min,x);
            max=Math.max(max,x);
        }
        int[] freq=new int[(int)max+1];
        for(int x:ranks)
            freq[x]++;
        r=min*cars*cars;
        while(l<=r)
        {
            long mid=(l+r)/2;
            long repair=0;
            for(int i=1;i<=max;i++)
                repair+=freq[i]*(long)Math.sqrt(mid/i);
            if(repair>=cars)
            {
                ans=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        return l;
    }
}

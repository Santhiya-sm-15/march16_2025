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
class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low, nums[i]);
            high += nums[i]; 
        }
        int ans=0;

        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(nums, mid,k)){
                ans =mid;
            high= mid-1;
            }
            else
            low = mid+1;
        }
        return ans;
    }

    boolean isPossible(int[] a, int threshold, int k){
        int partitions =1;
        int sum=0;
        for(int i=0;i<a.length;i++){
            if(sum+a[i]<=threshold)
            {
                sum+=a[i];
            }
            else{
                partitions++;
                sum=a[i];
            }
        }
        return partitions<=k;
    }
}
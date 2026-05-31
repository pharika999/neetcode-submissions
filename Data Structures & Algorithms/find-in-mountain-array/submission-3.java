/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        System.out.println(peak);
        // if(target>=mountainArr.get(0) && target<= mountainArr.get(peak))
        int ans1 = binarySearch(mountainArr, 0, peak, target);
        int ans2 = binarySearchDesc(mountainArr, peak+1, mountainArr.length()-1, target);

        if(ans1==-1)
        {
            if(ans2==-1)
            return -1;
            return ans2;
        }
        return ans1;
    }

     int binarySearchDesc(MountainArray mountainArr, int low, int high, int k){
        while(low<=high){
            int mid = (low+high)/2;
            int ele= mountainArr.get(mid);
            // System.out.println("----------"+mid);
            if(ele == k)
            return mid;
            if(ele<k)
            high = mid-1;
            else
            low = mid+1;
        }
        return -1;
    }

    int binarySearch(MountainArray mountainArr, int low, int high, int k){
        while(low<=high){
            int mid = (low+high)/2;
            int ele= mountainArr.get(mid);
            if(ele == k)
            return mid;
            if(ele<k)
            low= mid+1;
            else
            high = mid-1;
        }
        return -1;
    }

    int findPeak(MountainArray mountainArr){
         int low= 0;
        int high = mountainArr.length()-1;
        while(low<high){
            int mid = (low+high)/2;
            int ele= mountainArr.get(mid);
            int compEle = 0;
            if(mid>low){
            int prevEle = mountainArr.get(mid-1);
            if(prevEle<ele)
            low= mid;
            else
            high = mid-1;
            }
            else {
            int nextEle = mountainArr.get(mid+1);
            if(nextEle<ele)
            high= mid;
            else
            low=mid+1;
            }
            
        }
        return low;
    }
}
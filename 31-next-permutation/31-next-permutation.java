class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;     // 12323 ->  _   /\/
        // System.out.println(i);                  // 12332 -> / \
        
        if(i>=0) {
            int j=nums.length-1;
            while(nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
        
        
        // List<List<Integer>> l = permute(nums);
        // ArrayList<Integer> search = new ArrayList<>();
        // for(int n : nums) search.add(n);
        // int c=0;
        // for(List<Integer> l1 : l) {
        //     if(l1.containsAll(search)) {
        //         // System.out.println(l1);
        //         break;
        //     }
        //     c++;
        // }
        // List<Integer> finalList = new ArrayList<>();
        // System.out.println(c);
        // if(c==nums.length && l.size()>0) {
        //     finalList = l.get(0);
        // } else finalList = l.get(c+1);
        // for(int i=0;i<nums.length;i++) nums[i] = finalList.get(i);
    }
    
    public void swap(int[] a, int i, int j) {
        //System.out.println(a[i]+" "+a[j]);

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public void reverse(int[] a, int i, int j) {
        while(i<j) swap(a, i++,j--);
        //System.out.println(a[i]+" "+a[j]);
    }
    
    private void recurPermute(int[] nums, List<Integer> ds,List<List<Integer>> ans, boolean[] freq) {
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!freq[i]) {
                ds.add(nums[i]);
                freq[i] = true;
                recurPermute(nums, ds, ans, freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermute(nums, ds, ans, freq);
        return ans;
    }
    
    // 123  /
    // 132  /\  -> 213
    // 213  \/  -> 231
    // 231  /\
    // 312  \/
    // 321  \
}
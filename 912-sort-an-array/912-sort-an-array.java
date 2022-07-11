class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] list = new int[nums.length];
        
        for(int n : nums) {
            q.add(n);
        }
        
        int i = 0;
        while(q.size()>0) {
            list[i++] = q.poll(); 
        }
        return list;
        
        // List<Integer> arr = new ArrayList<>();
        // Stack<Integer> s = new Stack<>();
        // for(int num : nums) arr.add(num);
        // sort(arr);
        // return arr.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void sort(List<Integer> arr) {
        if(arr.size() == 1) return;
        
        
        int last = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        
        sort(arr);
        insert(arr, last);
    }
    
    public void insert(List<Integer> arr, int temp) {
        if(arr.size()==0 || arr.get(arr.size()-1)<=temp) {
            arr.add(temp);
            return;
        }
     
        int val = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        
        insert(arr, temp);
        arr.add(val);
    }
}
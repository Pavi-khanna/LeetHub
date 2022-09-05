class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // create a map of element -> frequency
        for(int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        // iterate on min heap & push key=freq,value=elem
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->{
            return a[0] - b[0]; // -ive pe change , pos pe no change
        });
        List<Integer> list = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            heap.add(new int[]{pair.getValue(), pair.getKey()});

            if(heap.size()>k) heap.poll();
        }
        
        while(heap.size()>0) {
            list.add(heap.poll()[1]);
        }
        Collections.sort(list);
        Integer[] arr = new Integer[list.size()];
        return list.stream().mapToInt(i->i).toArray();
    }
}
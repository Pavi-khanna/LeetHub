class Solution {
    public int lastStoneWeight(int[] stones) {        
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<stones.length; i++) {
            q.add(stones[i]);
        }
        
        while(q.size()>1) {
            int first = q.remove();
            int second = q.remove();
            
            if (first != second) {
                q.add(first - second);
            }
        }
        return q.isEmpty() ? 0 : q.remove();
    }
}
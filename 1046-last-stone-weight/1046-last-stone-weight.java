class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }
        Collections.sort(stoneList);

        while (stoneList.size() > 1) {
            int stone1 = stoneList.remove(stoneList.size() - 1);
            int stone2 = stoneList.remove(stoneList.size() - 1);

            if (stone1 != stone2) {
                if(stone1>stone2) stoneList.add(stone1-stone2);
                else if(stone1<stone2) stoneList.add(stone2-stone1);
            }
            Collections.sort(stoneList);
        }

        return !stoneList.isEmpty() ? stoneList.remove(0) : 0;
        
        
        // nlogn, logn/1
//         PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
//         for(int i=0; i<stones.length; i++) {
//             q.add(stones[i]);
//         }
        
//         while(q.size()>1) {
//             int first = q.remove();
//             int second = q.remove();
            
//             if (first != second) {
//                 q.add(first - second);
//             }
//         }
//         return q.isEmpty() ? 0 : q.remove();
    }
}
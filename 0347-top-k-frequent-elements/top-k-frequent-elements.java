// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//          //  List<Integer> li = new ArrayList<>();
//         int ans[] = new int[k];
        
//         Map<Integer,Integer> mp = new HashMap<>();
        
//         for(int i : nums){
//             mp.put(i, mp.getOrDefault(i,0)+1);
//             // if(mp.get(i)==k) li.add(i);
//         }

//         List<Map.Entry<Integer,Integer>> li  =new ArrayList<>(mp.entrySet());

//         Collections.sort(li, (a, b)-> b.getValue()-a.getValue());

//         for(int i=0; i< k; ++i) ans[i] = li.get(i).getKey();
//         return ans;
        
//         // return li.stream().mapToInt(i->i).toArray();
        
//     }
// }




class Solution {
    int[] unique;
    Map<Integer, Integer> count;

    // Swap elements in 'unique' array
    private void swap(int a, int b) {
        int temp = unique[a];
        unique[a] = unique[b];
        unique[b] = temp;
    }

    // Partition using rightmost index as pivot
    private int partition(int left, int right) {
        int pivot_frequency = count.get(unique[right]); // right is pivot
        int store_index = left;

        for (int i = left; i < right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        swap(store_index, right); // Move pivot to its correct position
        return store_index;
    }

    // Quickselect to position the kth smallest frequency element
    private void quickselect(int left, int right, int k_smallest) {
        if (left >= right) return;

        // Partition the array and get pivot index
        int pivot_index = partition(left, right);

        if (k_smallest == pivot_index) return;
        else if (k_smallest < pivot_index)
            quickselect(left, pivot_index - 1, k_smallest);
        else
            quickselect(pivot_index + 1, right, k_smallest);
    }

    // Top K Frequent Elements
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Frequency count
        count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Unique elements
        unique = new int[count.size()];
        int i = 0;
        for (int num : count.keySet()) {
            unique[i++] = num;
        }

        // Step 3: Quickselect to get top k frequent
        int n = unique.length;
        quickselect(0, n - 1, n - k);

        // Step 4: Return top k elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
}
class Solution {
    List<Integer> li;
    Random rnd;

    public Solution(int[] w) {
        li = new ArrayList<>();
        rnd = new Random();
        int prefixSum = 0;

        for (int weight : w) {
            prefixSum += weight;
            li.add(prefixSum);
        }
    }

    public int pickIndex() {
        int next = rnd.nextInt(li.get(li.size() - 1)) + 1;
        int index = Collections.binarySearch(li, next);
        if (index < 0) index = -index - 1; 
        return index;
    }
}
class Solution { public int numRabbits(int[] answers) { Map<Integer, Integer> freq = new HashMap<>();

    for (int answer : answers) {
        freq.put(answer, freq.getOrDefault(answer, 0) + 1);
    }
    
    int total = 0;
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        int r = entry.getKey();
        int count = entry.getValue();
        int groupSize = r + 1;
        int groups = (count + groupSize - 1) / groupSize;
        total += groups * groupSize;
    }
    
    return total;
}
}
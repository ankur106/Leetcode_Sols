class Solution {

    public record entry(String str, int index){}

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);
        Queue<entry> que = new LinkedList<>();
        que.offer(new entry(beginWord, 0));
        if(st.contains(beginWord)) st.remove(beginWord);


        while(!que.isEmpty()){
            entry p = que.poll();
            String curr = p.str;
            int level = p.index;
        
            if(curr.equals(endWord)) return level + 1;

            for(int i = 0 ; i < curr.length(); ++i){
                char[] charArray = curr.toCharArray();

                for(char c = 'a'; c <= 'z'; c++){
                    charArray[i] = c;
                    String converted = new String(charArray);
                    if(!converted.equals(curr) && st.contains(converted)) {
                        que.offer(new entry(converted, level+1));
                        st.remove(converted);
                    }
                }
            }


        }


        return 0;



    }
}
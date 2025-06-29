class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        StringBuilder sb = new StringBuilder();
        Map<String, String> mp = new HashMap<>();

        for(List<String> kn : knowledge){
            mp.put(kn.get(0), kn.get(1));
        }

        int len = s.length();
        int i=0;

        while( i < len){    
            while( i <len && Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
                i++;
            }

            if(i < len && s.charAt(i) == '('){
                StringBuilder key = new StringBuilder();
                i++;

                while(s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }
                if(!mp.containsKey(key.toString())) sb.append('?');
                else sb.append(mp.get(key.toString()));

            }

            i++;
        }

        return sb.toString();
    }
}

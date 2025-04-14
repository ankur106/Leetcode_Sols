class Solution {
    Map<String, String> emailToName = new HashMap<>();
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> size = new HashMap<>();

    private void union(String email1, String email2){

        String p1 = findParent(email1);
        String p2 = findParent(email2);
        
        if(p1.equals(p2)) return;

        int size1 = size.get(p1);
        int size2 = size.get(p2);

        if(size1  <  size2) {
            parent.put(p1, p2);
            size.put(p2, size.get(p2) + size.get(p1));
        }else{
            parent.put(p2, p1);
            size.put(p1, size.get(p2) + size.get(p1));
        }
        



    }

    private String findParent(String email){
        if(parent.get(email) != email){
        
            String topParent = findParent(parent.get(email));
            parent.put(email, topParent);
        }

        return parent.get(email);
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> ans;

        Map<String, List<String>> ultParent = new HashMap<>();
        Set<String> emails = new HashSet<>();


        for(List<String> account : accounts){
            String name = account.get(0);

            if(account.size() == 2) {
                String email = account.get(1);
                parent.put(email, email);
                size.put(email, 1);
                emailToName.put(email, name);
                emails.add(email);
                continue;
            }
            for(int i =1;i < account.size()-1; ++i){
                String email1 = account.get(i);
                String email2 = account.get(i + 1);
                
                if(!parent.containsKey(email1)) {

                    parent.put(email1, email1);
                    size.put(email1, 1);
                    emailToName.put(email1, name);
                    emails.add(email1);

                }
                

                if(!parent.containsKey(email2)) {
                    parent.put(email2, email2);
                    size.put(email2, 1);
                    emailToName.put(email2, name);
                    emails.add(email2);
                }

                union(email1, email2);
            }
        }

        for(String s : emails){
            String tParent = findParent(s);
            ultParent.putIfAbsent(tParent, new ArrayList<String>());
            ultParent.get(tParent).add(s);
        }

        ans = new ArrayList<>(ultParent.values());
        for(List<String> li: ans){
            Collections.sort(li);
            li.add(0, emailToName.get(li.get(0)));
        }

        return ans;

        
    }
}
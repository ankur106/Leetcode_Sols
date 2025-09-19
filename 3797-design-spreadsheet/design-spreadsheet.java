class Spreadsheet {

    HashMap<String,Integer> map=new HashMap<>();

    public Spreadsheet(int rows) {
        map=new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.remove(cell);
    }
    
    public int getValue(String formula) {
         
         formula=formula.substring(1);
         int res=0;
         
         int plus=formula.indexOf('+');
         String left=formula.substring(0,plus);
         String right=formula.substring(plus+1);

         if(Character.isDigit(left.charAt(0))){
            res+=Integer.parseInt(left);
         }else{
            res+=map.getOrDefault(left,0);
         }


         if(Character.isDigit(right.charAt(0))){
            res+=Integer.parseInt(right);
         }else{
           res+=map.getOrDefault(right,0);
         }

        

        return res;
    }
}
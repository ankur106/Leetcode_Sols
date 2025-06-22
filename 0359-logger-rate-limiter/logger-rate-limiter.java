class Logger {
    Map<String, Integer> mp;
    public Logger() {
        mp = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(mp.containsKey(message)){
            if(timestamp - mp.get(message) < 10){
                return false;

            }else{
                mp.put(message, timestamp);
                return true;
            }
        }else{
            mp.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
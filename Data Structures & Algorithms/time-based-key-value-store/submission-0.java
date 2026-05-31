class TimeMap {
    HashMap<String, List<Entry>> store;
    class Entry{
        int timestamp;
        String value;
         Entry(int timestamp, String value){
            this.timestamp = timestamp;
            this.value= value;
        }
    }
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key))
        store.put(key, new ArrayList<Entry>());

        store.get(key).add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key))
        return "";

        String res="";
        int low=0;
        int high = store.get(key).size()-1;
        List<Entry> entries = store.get(key);

        while(low<=high){
            int mid = (low+high)/2;

            if(entries.get(mid).timestamp<=timestamp){
                res = entries.get(mid).value;
                low= mid+1;
            }
            else 
            high=mid-1;
        }
        return res;
    }
}

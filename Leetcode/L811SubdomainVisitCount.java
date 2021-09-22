class L811SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> op = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(String domain: cpdomains){
            String[] temp = domain.split("\\s+");
            int count = Integer.parseInt(temp[0]);
            String domains = temp[1];
            String[] items = domains.split("\\.");
            
            String str = items[items.length-1];
            map.put(str, map.getOrDefault(str, 0) + count);
            for(int i=items.length-2; i>=0; i--){
                str = items[i] + "." + str;
                map.put(str, map.getOrDefault(str, 0) + count);
            }
        }
        
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String domain = entry.getKey();
            int count = entry.getValue();
            op.add(count + " " + domain);
        }
        return op;
    }
}
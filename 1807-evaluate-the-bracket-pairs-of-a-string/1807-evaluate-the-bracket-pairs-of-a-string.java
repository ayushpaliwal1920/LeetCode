class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> mp = new HashMap<>();

        for(List<String> list : knowledge){
            mp.put(list.get(0) , list.get(1));
        }

        StringBuilder str = new StringBuilder();

        int i = 0;
      
        
        while( i < s.length()){
            char ch = s.charAt(i);
            
            if(ch == '('){
                int st = i + 1;
                i++;

                while(s.charAt(i) != ')'){
                    i++;
                }

                String key = s.substring(st , i);

                if(mp.containsKey(key)){
                    str.append(mp.get(key));
                }else{
                    str.append("?");
                }
                i++;
            }else{
                str.append(ch);
                i++;
            }
        }

        return str.toString();

    }
}
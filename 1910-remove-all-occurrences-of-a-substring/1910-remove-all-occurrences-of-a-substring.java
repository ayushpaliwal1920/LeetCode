class Solution {
    public String removeOccurrences(String s, String part) {

        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()){
            str.append(ch);
            if(str.length() >= part.length()){
                int st = str.length() - part.length();
                if(str.substring(st).equals(part)){
                    str.delete(st , str.length());
                }
            }
        }

        return str.toString();

    }
}
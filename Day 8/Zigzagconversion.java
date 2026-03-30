class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows]; 
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }
        boolean dir = false; 
        int currrow = 0;  
        for(int i = 0; i < s.length(); i++){
            sb[currrow].append(s.charAt(i));
            if(currrow == 0 || currrow == numRows - 1){
                dir = !dir;
            } 
            if(dir){
                currrow++; 
            } else {
                currrow--; 
            }
        } 
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < sb.length; i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}

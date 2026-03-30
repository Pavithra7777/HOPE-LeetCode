class Solution{
    public char secondMostOccuring(String s) {
        int max=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        char m=' ';
        char sec=' '; 
        for(int i=0; i<s.length(); i++){
            boolean flag=false;
            for(int j=0; j<i; j++){
                if(s.charAt(i)==s.charAt(j)){
                    flag=true;
                    break;
                }
            }
            if(flag) continue;
            int count=0;
            for(int j=i; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j)) count++;
            }
            if(count>max){
                second=max;
                max=count;
                sec=m;
                m=s.charAt(i);
            }
            else if(count>second && count!=max){
                second=count;
                sec=s.charAt(i);
            }

        }
        return sec;
    }
}

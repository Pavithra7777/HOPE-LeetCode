class Solution {
    public static void main(String[] args) {
        String str = "Hello##123";
        int alphabet = 0;
        int digit = 0;
        int special = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                alphabet++;
            } else if (ch >= '0' && ch <= '9') {
                digit++;
            } else {
                special++;
            }
        }

        System.out.println(alphabet+" "+digit+" "+special);    }
}
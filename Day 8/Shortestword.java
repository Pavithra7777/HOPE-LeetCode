public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int min = Integer.MAX_VALUE;
        String value = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i)); 
            } else {
                if (sb.length() > 0 && sb.length() < min) {
                    min = sb.length();
                    value = sb.toString();
                }
                sb.setLength(0); 
            }
        }
        System.out.print(value);
    }
}

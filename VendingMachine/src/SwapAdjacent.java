public class SwapAdjacent {
    public boolean canTransform(String start, String end) {
        int x = 0;
        int step = 1;
        String s = "";
        while (step < start.length()) {
            char c = start.charAt(x);
            char a = start.charAt(step);
            s = s + a;
            s += c;
            step = step + 2;
            x = step - 1;
        }
        System.out.println(s);
        int start1 = 0;
        while (start1 < start.length()) {
            if (start.charAt(start1) != end.charAt(start1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwapAdjacent obj = new SwapAdjacent();

    }
}

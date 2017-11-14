package String;

public class compress {

    //46%
    public static int compress(char[] chars) {
        if(chars == null || chars.length <= 0)
            return 0;

        char var = chars[0];
        int left=0, right=0;
        for(int i=0; i<chars.length;){
            right = i;
            while(right<chars.length && chars[right] == var) right ++;
            int len = right - i;
            chars[left++] = var;
            if(len != 1) {
                char[] tmp = String.valueOf(len).toCharArray();
                for(char num : tmp)
                    chars[left++] = num;
            }
            if (right >= chars.length)
                break;
            i = right;
            var = chars[right];
        }
        return left;
    }

    public static void main(String[]args){
        char[] s = {'a','a','b','b','c','c','c'};
        System.out.println(compress(s));
    }
}

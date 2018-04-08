package MSRA_100;

public class T017_firstSingle {

    public char firstSingle(String s){
        int [] count = new int[256];
        char[] ch = s.toCharArray();
        for (int i=0; i<ch.length; i++){
            if(count[ch[i]] == 0)
                count[ch[i]] = i+1;
            else if(count[ch[i]] >= 1)
                count[ch[i]] = -1;
        }

        int min = s.length();
        char res = ch[s.length()-1];
        for(int i=0; i<256; i++){
            if(count[i] >= 1 && min > count[i]) {
                min = count[i] - 1;
                res = (char)i;
            }
        }
        return res;
    }
}

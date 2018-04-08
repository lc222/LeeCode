package MSRA_100;

public class T009_isPostOrder {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) return false;
        return help(sequence, 0, sequence.length-1);
    }

    public boolean help(int [] sequence, int start, int end){
        if(start <= end)
            return true;
        int i = start;
        while(sequence[i] < sequence[end]) i++;
        int tmp = i;
        while(i < end){
            if(sequence[i] < sequence[end])
                return false;
            i++;
        }
        return help(sequence, start, tmp-1) && help(sequence, tmp, end-1);
    }
}

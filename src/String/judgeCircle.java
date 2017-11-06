package String;

/*

657. Judge Route Circle

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,

which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R

(Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false

 */


public class judgeCircle {

    //36%
    public boolean judgeCircle(String moves) {
        int up=0, right=0;
        for(int i=0; i<moves.length(); i++){
            if(moves.charAt(i) == 'U')
                up ++;
            else if(moves.charAt(i) == 'D')
                up --;
            else if(moves.charAt(i) == 'R')
                right ++;
            else
                right --;
        }
        if(up == 0 && right == 0)
            return true;
        else
            return false;
    }

    //65%
    public boolean judgeCircle1(String moves){
        char [] move = moves.toCharArray();
        int up=0, right=0;
        for(char c : move){
            if(c == 'U')
                up ++;
            else if(c == 'D')
                up --;
            else if(c == 'R')
                right ++;
            else
                right --;

        }
        return up == 0 && right ==0;
    }

    //4%
    public boolean judgeCircle2(String moves) {
        moves=" " + moves + " ";
        return moves.split("L").length==moves.split("R").length && moves.split("U").length == moves.split("D").length;
    }
}

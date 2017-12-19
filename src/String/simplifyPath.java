package String;

import java.util.*;

/**

 71. Simplify Path

 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 click to show corner cases.

 Corner Cases:
 Did you consider the case where path = "/../"?
 In this case, you should return "/".
 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".

 */


public class simplifyPath {

    //95%
    public String simplifyPath(String path) {
        //使用两个数组，第一个数组用于保存切分之后的内容，然后遍历
        //遇到.或者空的时候直接跳过，遇到文件夹名的时候向第二个数组添加，遇到..的时候将第二个数组的最后一个内容删除，其实
        //就是游标向前移动一个值
        String[] dir = path.split("/");
        String[] stack = new String[dir.length];
        int ptr = 0;
        for(int i = 0; i < dir.length; i++){
            if(dir[i].equals(".") || dir[i].equals(""))
                continue;
            else if(dir[i].equals("..")){
                if(ptr > 0) ptr--;
            }else{
                stack[ptr] = dir[i];
                ptr++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < ptr; i++){
            result.append("/");
            result.append(stack[i]);
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    //96.5%
    public String simplifyPath1(String path) {
        int len = path.length();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < len; ) {
            char c = path.charAt(i);
            if (c == '/') { ++i; }  // skip the separator '/'
            else if (c == '.') {
                int j = i + 1;
                while (j < len && path.charAt(j) != '/') { ++j; }
                if (j - i == 2 && path.charAt(i + 1) == '.' && !stack.isEmpty()) {  // go up to parent directory
                    stack.removeLast();
                } else if (j - i > 2) {
                    stack.addLast(path.substring(i, j));  // go down to child directory
                }
                i = j;
            } else {
                int j = i + 1;
                while (j < len && path.charAt(j) != '/') { ++j; }
                stack.addLast(path.substring(i, j));  // go down to child directory
                i = j;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String dir: stack) { ans.append('/').append(dir); }
        if (ans.length() == 0) { return "/"; }
        return ans.toString();
    }

    //34%
    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            if (!stack.empty() && p[i].equals(".."))
                stack.pop();
            else if (!p[i].equals(".") && !p[i].equals("") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        List<String> list = new ArrayList(stack);
        return "/"+String.join("/", list);
    }
}

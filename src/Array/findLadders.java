package Array;

import java.util.*;

/**
 * Created by liuchong on 2017/6/17.
 */
public class findLadders {
    static int min = Integer.MAX_VALUE;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> res = new ArrayList<>();
//        List<String> tmp = new ArrayList<>();
//        tmp.add(beginWord);
//        if(!wordList.contains(endWord))
//            return res;
//        dfs(res, tmp, beginWord, endWord, wordList);
//        for(int i=0; i<res.size(); i++){
//            if(res.get(i).size() > min) {
//                res.remove(i);
//                i--;
//            }
//        }
//        System.out.println(res.toString());
//        return res;

        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// 保存每个节点的neighbor信息，也就是相差一个字符的所有组合
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// 记录每个字符串到beginWord的距离
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs1(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    private static void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance){
        for(String ss:dict)
            nodeNeighbors.put(ss, new ArrayList<>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while(!queue.isEmpty()){
            int count = queue.size();
            boolean foundEnd = false;
            for(int i=0; i<count; i++){
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for(String neighbor:neighbors){
                    nodeNeighbors.get(cur).add(neighbor);
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if(end.equals(neighbor))
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            if(foundEnd)
                break;
        }
    }

    private static ArrayList<String> getNeighbors(String node, Set<String> dict){
        ArrayList<String> res = new ArrayList<>();
        char[] chs = node.toCharArray();

        for(char ch='a'; ch<='z'; ch++){
            for(int i=0; i<chs.length; i++){
                if(chs[i] == ch)continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if(dict.contains(String.valueOf(chs))){
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }
        return res;
    }

    private static ArrayList<String> getNeighbors1(String node, Set<String> dict){
        ArrayList<String> res = new ArrayList<>();
        for(String ss : dict){
            if(isOne(node, ss))
                res.add(ss);
        }
        return res;
    }

    private static void dfs1(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res){
        solution.add(cur);
        if(end.equals(cur))
            res.add(new ArrayList<>(solution));
        else{
            for(String next:nodeNeighbors.get(cur)){
                if(distance.get(next) == distance.get(cur) + 1)
                    dfs1(next, end, dict, nodeNeighbors, distance, solution, res);
            }
        }
        solution.remove(solution.size()-1);
    }

    public static void dfs(List<List<String>> res, List<String> tmp, String beginWord, String endWord, List<String> wordList){
        if(isOne(beginWord, endWord)){
            tmp.add(endWord);
            min = Math.min(min, tmp.size());
            res.add(new ArrayList<>(tmp));
            tmp.remove(endWord);
            return;
        }
        for(String tt : wordList){
            if(!tmp.contains(tt) && isOne(beginWord, tt)){
                tmp.add(tt);
                dfs(res, tmp, tt, endWord, wordList);
                tmp.remove(tt);
            }

        }
    }

    public static boolean isOne(String s, String t){
        int k=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != t.charAt(i))
                k++;
        }
        if(k == 1)
            return true;
        else
            return false;
    }

    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
            //we use bi-directional BFS to find shortest path
            List<List<String>> result = new ArrayList<List<String>>();
            if(!wordList.contains(endWord))
                return result;
            HashSet<String> dict = new HashSet<String>(wordList);
            Set<String> fwd = new HashSet<String>();
            fwd.add(beginWord);

            Set<String> bwd = new HashSet<String>();
            bwd.add(endWord);

            Map<String, List<String>> hs = new HashMap<String, List<String>>();
            BFS(fwd, bwd, dict, false, hs);



            //if two parts cannot be connected, then return empty list
            if(!isConnected) return result;

            //we need to add start node to temp list as there is no other node can get start node
            List<String> temp = new ArrayList<String>();
            temp.add(beginWord);

            DFS(result, temp, beginWord, endWord, hs);

            return result;
        }

    //flag of whether we have connected two parts
    boolean isConnected = false;

    public void BFS(Set<String> forward, Set<String> backward, Set<String> dict, boolean swap, Map<String, List<String>> hs){

            //boundary check
            if(forward.isEmpty() || backward.isEmpty()){
                return;
            }

            //we always do BFS on direction with less nodes
            //here we assume forward set has less nodes, if not, we swap them
            if(forward.size() > backward.size()){
                BFS(backward, forward, dict, !swap, hs);
                return;
            }

            //remove all forward/backward words from dict to avoid duplicate addition
            dict.removeAll(forward);
            dict.removeAll(backward);

            //new set contains all new nodes from forward set
            Set<String> set3 = new HashSet<String>();

            //do BFS on every node of forward direction
            for(String str : forward){
                //try to change each char of str
                for(int i = 0; i < str.length(); i++){
                    //try to replace current char with every chars from a to z
                    char[] ary = str.toCharArray();
                    for(char j = 'a'; j <= 'z'; j++){
                        ary[i] = j;
                        String temp = new String(ary);

                        //we skip this string if it is not in dict nor in backward
                        if(!backward.contains(temp) && !dict.contains(temp)){
                            continue;
                        }

                        //we follow forward direction
                        String key = !swap? str : temp;
                        String val = !swap? temp : str;

                        if(!hs.containsKey(key)) hs.put(key, new ArrayList<String>());

                        //if temp string is in backward set, then it will connect two parts
                        if(backward.contains(temp)){
                            hs.get(key).add(val);
                            isConnected = true;
                        }

                        //if temp is in dict, then we can add it to set3 as new nodes in next layer
                        if(!isConnected && dict.contains(temp)){
                            hs.get(key).add(val);
                            set3.add(temp);
                        }
                    }

                }
            }

            //to force our path to be shortest, we will not do BFS if we have found shortest path(isConnected = true)
            if(!isConnected){
                BFS(set3, backward, dict, swap, hs);
            }
        }

    public void DFS(List<List<String>> result, List<String> temp, String start, String end, Map<String, List<String>> hs){
            //we will use DFS, more specifically backtracking to build paths

            //boundary case
            if(start.equals(end)){
                result.add(new ArrayList<String>(temp));
                return;
            }

            //not each node in hs is valid node in shortest path, if we found current node does not have children node,
            //then it means it is not in shortest path
            if(!hs.containsKey(start)){
                return;
            }

            for(String s : hs.get(start)){
                temp.add(s);
                DFS(result, temp, s, end, hs);
                temp.remove(temp.size()-1);

            }
        }


    public static void main(String [] args){

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
//        wordList.add("lot");
//        wordList.add("log");
//        wordList.add("cog");
        findLadders("hot", "dog", wordList);
    }
}

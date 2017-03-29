package HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        for(int num : nums)
        {
        	if(!tmp.add(num))
        		return true;
        }
        return false;
    }
    
    //��������֮��ʱ�����ӣ�˵������������Զ�����һ�������ǵ�ѡ��
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> tmp = new HashSet<>();
        Arrays.sort(nums);
        for(int num : nums)
        {
        	if(!tmp.add(num))
        		return true;
        }
        return false;
    }    
  //����Ч����ߵ�ʵ�ַ��������set���������һ��ѭ��
    public boolean containsDuplicate2(int[] nums) {
    	Arrays.sort(nums);
    	for(int i=0; i<nums.length; i++)
    		if(nums[i] == nums[i+1])
    			return true;
    	return false;
    }
    
    //����㷨�����98%��ѡ�֣�����������������������������������������������������
    //����byte��λ������������һ��Ҫ���ף�������������������������������������
    public boolean containsDuplicate3(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i/8;
            int k = i%8;
            int check = 1<<k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j]|=check;
        }
        return false;
    }
}

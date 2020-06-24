package com.zuijianren.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *      害，第一次刷算法题，果然我弱爆了，大学学的什么数据结构，算法之类的忘得干干净净
 * 总结：
 *      很耿直的想到了暴力解决法，并将它写了上去，提交！ 淦，过于真实
 *      看了下官方和前三的评论，有学到新知识。
 *          对于元素和索引相对应的关系，应该优先思考到哈希表，然后通过空间换时间，将查找时间 O(n) 降低为 O(1)
 *      另外，
 *          由于元素都是数字，而数字的哈希值就是本身，因此不存在哈希碰撞
 *          每种输入只会对应一个答案 --> 答案相关的元素最多出现两次，所以哈希覆盖key，是不影响结果的
 */
public class 两数之和 {
    public static int[] twoSum(int[] nums, int target) {
        //暴力法：      时间复杂度 O(n的2次方)   空间复杂度：O(1)
        /*
        for(int i=0; i<nums.length; i++){
            for(int j=1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{nums[i], nums[j]};
                }
                continue;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        */
        //两遍hash      时间复杂度 O(n)   空间复杂度：O(n)
        /*
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int complement ;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if( map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        */
        //一遍hash       时间复杂度 O(n)   空间复杂度：O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int complement;
        for (int i = 0; i < nums.length; i++) {
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 2, 2}, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

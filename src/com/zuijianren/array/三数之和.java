package com.zuijianren.array;

import sun.security.util.ArrayUtil;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return null;
        }
        int b,c;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            b = i+1;
            c = nums.length-1;

            while(b < c){

                if(nums[i] + nums[b] + nums[c] > 0){
                    c--;
                }else if(nums[i] + nums[b] + nums[c] < 0){
                    b++;
                }else{
                    List list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    lists.add(list);
                    while(b < nums.length -1 && nums[b+1] == nums[b]){
                        b++;
                    }
                    while (c > 0 && nums[c-1] == nums[c]){
                        c--;
                    }
                    c--;
                    b++;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}

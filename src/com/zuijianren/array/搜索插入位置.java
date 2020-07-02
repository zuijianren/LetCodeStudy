package com.zuijianren.array;

import org.junit.Test;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            if(nums[0] >= target){
                return 0;
            }else {
                return 1;
            }
        }
        int a = 0;
        int b = nums.length - 1;
        while(a<b){
            int i = (a+b)/2;
            if(nums[i] > target){
                b = i-1;
            }else if(nums[i] < target){
                a = i+1;
            }else {
                return i;
            }
        }
        if(target<=nums[a]){
            return a;
        }else if(target>nums[a] && target<=nums[b]){
            return a+1;
        }else{
            return b+1;
        }
    }

    @Test
    public void test(){
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }
}

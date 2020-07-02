package com.zuijianren.array;

import org.junit.Test;

/**
 *
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        //排除空数组
        if(nums.length == 0){
            return -1;
        }
        int a = 0;
        int b = nums.length-1;
        //指针
        int i = (a+b)/2;
        while(a < b){
            i = (a+b)/2;
            //不存在重复数，因此值相等的情况只有i等于a或者b
            //左边有序
            if(a == i || b==i){
                break;
            }else if(nums[a] < nums[i]){
                //判断目标数是否可能在左边
                if(target >= nums[a] && target <= nums[i]){
                    b = i;
                }else{
                    a = i;
                }
            }else{
                //判断目标数是否在右边
                if(target >= nums[i] && target <= nums[b]){
                    a = i;
                }else{
                    b = i;
                }
            }
        }
        if(nums[a] == target){
            return a;
        }else if(nums[b] == target){
            return b;
        }else if(nums[i] == target){
            return i;
        }else{
            return -1;
        }
    }

    @Test
    public void test(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int search = search(nums, target);
        System.out.println(search);
    }
}

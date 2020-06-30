package com.zuijianren.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 下一个排列 {
    public static void nextPermutation(int[] nums) {
        int size = nums.length;
        int temp;
        int j;
        for (int i = size - 1; i >= 0; i--) {
            if(i == 0){
                Arrays.sort(nums);
                break;
            }
            if(nums[i] > nums[i-1]){
                temp = nums[i];
                //查找刚好比nums[i-1]大的值，与nums[i-1]交换，nums[i]到nums[size-1]降序排列
                j = i+1;
                while(j<size && nums[j] > nums[i-1]){
                    temp = nums[j];
                    j++;
                }
                nums[--j] = nums[i-1];
                nums[i-1] = temp;
                Arrays.sort(nums, i, size);
                /*int x = i;
                int y = size -1;
                while(x < y){
                    temp = nums[x];
                    nums[x] = nums[y];
                    nums[y] = temp;
                    x++;
                    y--;
                }*/
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        nextPermutation(nums);
        System.out.println(nums);
    }
}

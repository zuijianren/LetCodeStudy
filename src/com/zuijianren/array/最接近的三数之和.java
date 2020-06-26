package com.zuijianren.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最接近的三数之和 {
    public static int threeSumClosest(int[] nums, int target) {
        /**思路： 三数之和减去target，取最小值，为0跳出
        * 三个for循环？
        * 先进行排序，双指针
         */
        Arrays.sort(nums);
        int b,c;
        int value = Integer.MAX_VALUE;
        int sum;
        Boolean zf = false;
        for (int i = 0; i < nums.length; i++) {
            b = i+1;
            c = nums.length - 1;
            while(b<c){
                sum = nums[i] + nums[b] + nums[c];
                if(sum < target){
                    if(target - sum > value ){
                        value = value;
                    }else{
                        value = target - sum;
                        zf = false;
                    }
                    while(b+1<c && nums[b] == nums[b+1]){
                        b++;
                    }
                    b++;
                }else if(sum > target){
                    if(sum - target > value){
                        value = value;
                    }else{
                        value = sum - target;
                        zf = true;
                    }
                    while(c-1>b && nums[c] == nums[c-1]){
                        c--;
                    }
                    c--;
                }else{
                    return target;
                }
            }
        }
        if(zf){
            return target + value;
        }else{
            return target - value;
        }
    }
    public static void main(String[] args) {
        int[] nums =  new int[]{0,2,1,-3};
        int target = 1;
        int i = threeSumClosest(nums, target);
        System.out.println(i);
    }
}

package com.zuijianren.array;

import org.junit.Test;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 2){
            if(nums.length == 0){
                return new int[]{-1,-1};
            }else if( nums[0] == target){
                return new int[]{0, 0};
            }else{
                return new int[]{-1, -1};
            }
        }

        int a = 0;
        int b = nums.length-1;
        int first;
        int last;
        int i = (a+b)/2;
        while(a<b){
            i = (a+b)/2;
            //当只有两值时才会到达边界
            if(i == a || i == b){
                if(target == nums[a]){
                    i = a;
                    break;
                }else if(target == nums[b]){
                    i = b;
                    break;
                }else{
                    return new int[]{-1, -1};
                }
            }
            if(target < nums[i]){
                //目标值小于数组的中间值
                b = i;
            }else if(target > nums[i]){
                //目标值大于数组的中间值
                a = i;
            }else{
                break;
            }
        }
        //遍历左右
        first = i;
        last = i;
        while( first >= 0 && target == nums[first]){
            first--;
        }
        while(last <= nums.length-1 && target == nums[last] ){
            last++;
        }
        return new int[]{++first, --last};
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3};
        int target = 3;
        int[] ints = searchRange(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

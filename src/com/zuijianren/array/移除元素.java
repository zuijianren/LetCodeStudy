package com.zuijianren.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 移除元素 {
    public static int removeElement(int[] nums, int val) {
        int a = 0;
        for (int b = 0; b < nums.length; b++) {
            if (nums[b] == val){
                continue;
            }
            nums[a] = nums[b];
            a++;
        }
        return a;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int len = removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
    }
}

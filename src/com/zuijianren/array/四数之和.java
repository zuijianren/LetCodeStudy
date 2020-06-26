package com.zuijianren.array;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 四数之和 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4){
            return new ArrayList<List<Integer>>();
        }
        //先进行排序
        Arrays.sort(nums);

        int a,b,c,d;
        int sum;
        List<List<Integer>> lists = new ArrayList<>();
        for (a = 0; a < nums.length; a++) {
            if(a>0 && nums[a]==nums[a-1]){
                continue;
            }
            for (b = a+1; b < nums.length; b++) {
                if(b > a+1 && nums[b] == nums[b-1]){
                    continue;
                }
                c = b+1;
                d = nums.length-1;
                while(c<d){
                    sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if(sum>target){
                        d--;
                    }else if(sum<target){
                        c++;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        lists.add(list);
                        while(c+1<d && nums[c]==nums[c+1]){
                            c++;
                        }
                        while(d-1>c && nums[d]==nums[d-1]){
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return lists;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-3, -1, 0, 2, 4, 5};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}

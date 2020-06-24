package com.zuijianren.array;

/**
 *给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{9, 8, 6, 2, 5, 4, 8, 3, 9}));
    }
    public static int maxArea(int[] height) {
        //憨憨法   时间复杂度 O(n的2次方)  空间复杂度 O(1)
       /*
       int x,y;
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                x = j-i;
                y = height[i] <= height[j] ? height[i] : height[j];
                area = x*y >= area ? x*y : area;
            }
        }
        return area;
        */
        //双指针法  时间复杂度 O(n)  空间复杂度 O(1):只需要额外的常数级别的空间。
        int area = 0;
        int temp = 0;
        int i = 0;
        int j = height.length-1;
        while(i != j){
            temp = (j-i)*(height[i]<=height[j]? height[i] : height[j]);
            area = area>=temp ? area : temp;
            if(height[i] >= height[j]){
                j--;
            }else if(height[i] < height[j]){
                i++;
            }
        }
        return area;
    }
}

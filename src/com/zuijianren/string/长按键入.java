package com.zuijianren.string;

import org.junit.Test;

import java.util.Scanner;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 *
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 *
 * 思路：根据官方题解获得，一开始就没明白是什么意思，
 * 本题主要采用双指针的方法：
 *  一个指针指向一个字符串，进行比较，
 *  如果两个指针指向的字符相同，则两指针同时加一
 *  如果不同，则判断指向输入的字符串的指针的字符是否和另一个指针的上一个字符相同,这是在判断长按的情形
 *      如果相同，则将typed的指针加一，继续判断
 *      如果都不同，则直接返回false
 *
 */

/**
 * @author zuijianren
 * @date 2020/10/22 10:31
 */
public class 长按键入 {
    @Test
    public void test() {
        String name = "saeed";
        String typed = "ssaaedd";
        System.out.println(isLongPressedName(name, typed));
    }

    public boolean isLongPressedName(String name, String typed) {
        /*// name 和 typed 的指针
        int i1 = 0;
        int i2 = 0;
        // 判断输入长度，及最后的字符，因为下方要避免空指针，所以无法判断到最后一个字符，得在这判断
        if(name.length() > typed.length() || name.charAt(name.length()-1) != typed.charAt(typed.length()-1)){
            return false;
        }
        for (int i = 0; i < typed.length(); i++) {
            if(typed.charAt(i2) == name.charAt(i1)){

                // 等于当前对应的字符
                if(i1<name.length()-1){
                    i1++;
                }
                if(i2<typed.length()-1){
                    i2++;
                }
            }else if(i1 != 0 && typed.charAt(i2) == name.charAt(i1-1)){
                // 等于前一个字符
                if(i2<typed.length()-1){
                    i2++;
                }
            }else {
                return false;
            }
        }

        return true;*/
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

}

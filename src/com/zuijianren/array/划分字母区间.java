package com.zuijianren.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 提示：
 *  S的长度在[1, 500]之间。
 *  S只包含小写字母 'a' 到 'z' 。
 *
 *  又是长知识的一道题，这我真不想不出来，瞄了无数眼答案，终于懂了，并假装是自己的想法做了出来，哈哈哈哈
 *
 *  思路：根据题意，要将所有相同的字母放在一块区域，因此，需要记录每个字符最后一次出现的时间，
 *  仅有a~z，还是很容易想到用数组进行一一对应存值
 *  比较难的是想到具体的划分
 *  参考答案得： 从0开始遍历，将end设为当前已经扫描过的字符的最大的最后一次出现时间，
 *  如果，i和end相等，说明可以将当前内容分一个段，然后更新start为end的下一位
 *
 *
 * @author zuijianren
 * @date 2020/10/22 17:24
 */
public class 划分字母区间 {

    @Test
    public void test(){
        /*System.out.println("a".getBytes()[0]);
        System.out.println("z".charAt(0));
        int i = "a".charAt(0)-97;
        int i2 = 'a' - 97;
        System.out.println(i);
        System.out.println(i2);*/
        /*int[] nums = new int[100];
        System.out.println(nums['a']);*/
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();

        // 分别代表 a~z
        int[] last = new int[26];

        for (int i = 0; i < S.length(); i++) {
            // 记录每个字符最后一次出现的位置
            last[S.charAt(i)-'a'] = i;
        }


        int end = 0;
        int start = 0;
        char c;

        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            end = last[c-'a']>end?last[c-'a']:end;
            if(i==end){
                list.add(end-start+1);
                start=end+1;
            }
        }

        return list;
    }
}

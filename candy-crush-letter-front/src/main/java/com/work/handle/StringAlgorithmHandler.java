package com.work.handle;

import java.util.LinkedList;
import java.util.List;

public class StringAlgorithmHandler {
    /**
     * 移除相邻重复字符
     * @param s 字符串
     * @param k 相邻重复数
     * @return
     */
    public static List<String> removeDuplicates(String s, int k) {
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s);
        int length = -1;
        while (length != sb.length()) {
            length = sb.length();
            for (int i = 0, count = 1; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else if (++count >= k) {
                    list.add(sb.delete(i - k + 1, i + 1).toString());//删除相邻重复3个以上的字符 存放到list
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 替换相邻重复字符
     * @param s 字符串
     * @param k 相邻重复数
     * @return
     */
    public static List<String> replacedDuplicates(String s, int k) {
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s);
        int length = -1;
        while (length != sb.length()) {
            length = sb.length();
            for (int i = 0, count = 1; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;//对相邻重复计数
                } else if (++count >= k) {//大于计数3个以上时则删除
                    String replacedStr = "";//替换相邻重复3个以上的字符为重复最初的前一个
                    if(i-k>0){
                        replacedStr = ", " + sb.substring(i - k + 1, i + 1) +" is replaced by " + sb.charAt(i-k);
                    }
                    list.add(sb.delete(i - k + 1, i + 1).toString()+replacedStr);//存放到list
                    break;
                }
            }
        }
        return list;
    }
}

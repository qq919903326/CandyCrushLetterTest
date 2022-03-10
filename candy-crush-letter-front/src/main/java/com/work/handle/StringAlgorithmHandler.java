package com.work.handle;

import java.util.*;

public class StringAlgorithmHandler {
    /**
     * 顺序获取出需操作的字符
     * @param s
     * @param k
     * @return
     */
    public static List<Character> getOperationDuplicates(String s, int k) {
        // 构造两个栈，第一个栈储存字符，第二个栈储存数目
        List<Character> list = new LinkedList<>();
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // 第一个不一样的字符或者栈为空入栈
            if (stack1.isEmpty() || stack1.peekLast() != c) {
                stack1.addLast(c);
                stack2.addLast(1);
            }
            // 计数+1
            else {
                stack2.addLast(stack2.pollLast() + 1);
            }
            // 如果长度为K，那么直接先加入有序list
            if (stack2.peekLast() == k) {
                list.add(stack1.removeLast());
                stack2.removeLast();
            }
        }
        return list;
    }
    public static Optional<List<String>> rmDuplicates(String s, int k){
        List<Character> characterList = getOperationDuplicates(s,k);
        List<String> result = new ArrayList<>();
        for (Character character : characterList) {
            s = s.replace(character,'\0').replace("\u0000", "");//替换为空字符
            result.add(s);
        }
        if(result.isEmpty())
            return Optional.empty();
        return Optional.of(result);
    }
    /**
     * 替换相邻重复字符
     * @param s 字符串
     * @param k 相邻重复数
     * @return
     */
    public static Optional<List<String>> replacedDuplicates(String s, int k) {
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
        if(list.isEmpty())
            return Optional.empty();
        return Optional.of(list);
    }
    /**
     * 移除相邻重复字符
     * @param s 字符串
     * @param k 相邻重复数
     * @return
     */
    public static Optional<List<String>> removeDuplicates(String s, int k) {
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
        if(list.isEmpty())
            return Optional.empty();
        return Optional.of(list);
    }
}

package com.lxd.daily.lettcode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * 考验链表的遍历与节点新增
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2TwoAdd {
    public static class ListNode implements Serializable {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void addLast(ListNode node) {
            if (this.next == null) {
                this.next = node;
            } else {

            }

        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            throw new IllegalArgumentException("l1 || l2 can't be null");
        }
        // 链表遍历
        List<Integer> l1Nums = new ArrayList<Integer>();
        do{
            l1Nums.add(l1.val);
            l1 = l1.next;
        }while(l1 != null);
        List<Integer> l2Nums = new ArrayList<Integer>();
        do{
            l2Nums.add(l2.val);
            l2 = l2.next;
        }while(l2 != null);
        String num1 = "";
        // 数字拼接
        for(int i=l1Nums.size()-1;i>=0;i--){
            num1 += l1Nums.get(i) + "";
        }
        String num2 = "";
        for(int i=l2Nums.size()-1;i>=0;i--){
            num2 += l2Nums.get(i) + "";
        }
        // 大数转换与运算
        String result = new BigDecimal(num1).add(new BigDecimal(num2)).toString();
        int[] ls = new int[result.length()];
        for(int i=0;i<result.length();i++){
            ls[i] = Integer.parseInt(result.substring(i,i+1));
        }
        // 链表插入操作
        // 头节点
        ListNode head = new ListNode(ls[ls.length-1]);
        for(int i = ls.length-2;i>=0;i--){
            ListNode teamp = head;// 指针引用
            ListNode node = new ListNode(ls[i]);
            while(teamp.next != null){//遍历获取尾节点
                teamp = teamp.next;
            }
            teamp.next = node;// 新节点添加到尾节点
        }
        return head;
    }


    public static void main(String[] args){
        /*ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(5);
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode6 = addTwoNumbers(listNode, listNode3);
        System.out.println(listNode6);

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int[] ints1 = new int[nums1.length + nums2.length];
        new BigDecimal(1);
        System.arraycopy(nums1,0,ints1,0,nums1.length);
        System.arraycopy(nums2,0,ints1,nums1.length,nums2.length);
        System.out.println(ints1);

        Set<Object> objects = new HashSet<>();
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();

        }*/
        Set<Integer> objects = new LinkedHashSet<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        Iterator<Integer> iterator1 = objects.iterator();
        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            System.out.println(next);
        }
        /*ArrayList<Integer> objects1 = new ArrayList<>();
        Integer[] objects2 = (Integer[])objects.toArray();*/
        int[] nums = {1,2,3,3,4,4,5,6,7,8,9,9};
        int[] test = test(nums);
        System.out.println(test);
        System.out.println(test2(nums));


        double pow = Math.sqrt(16);
        System.out.println(pow);

        System.out.println(judgeSquareSum(8));
        System.out.println(judgeSquareSum(Integer.MAX_VALUE));
    }

    public static boolean judgeSquareSum(int c) {
        if(c < 0){
            return false;
        }
        int middle = (int)Math.sqrt(c);
        Set<Integer> nums = new HashSet<>();
        for(int i=0;i<=middle;i++){
            nums.add(i * i);
        }
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (nums.contains(c - next)) {
                return true;
            }
        }
        return false;
    }

    public static int[] test(int[] nums){
        if(nums == null || nums.length == 0){
            return nums;
        }
        Set<Integer> set = new LinkedHashSet<Integer>();
        for(int i:nums){
            set.add(i);
        }
        int[] result = new int[set.size()];
        int index =0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            result[index++] = iterator.next();
        }
        return result;
    }

    public static List<Integer> test2(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        int pre = nums[0];
        List<Integer> result = new ArrayList<Integer>();
        result.add(pre);
        for(int i=1;i<nums.length;i++){

            if(pre == nums[i]){
                continue;
            }
            pre = nums[i];
            result.add(pre);
        }
        return result;
    }
}

package com.gxl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /**53最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int []dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1;i<length;i++){
            dp[i] =  Math.max(nums[i],dp[i-1]+nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**20. 有效的括号
     *给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * @param s
     * @return
     */
    public  static boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        //只把左括号存储在站内。
        int length = s.length();
        for (int i = 0; i<length; i++){
            char str = s.charAt(i);
            if (isLeft(str)){
                stack.add(str);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char left = stack.remove(stack.size()-1);
                if(!isMatch(left,str)){
                    return false;
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;

    }
    public static boolean isLeft(char left){
        if (left=='('||left=='{'||left=='['){
            return true;
        }
        return false;
    }
    public static boolean isMatch(char left,char right){
        if (left=='('){
            if (right==')'){
                return true;
            }
            return false;
        }
        if (left=='{'){
            if (right=='}'){
                return true;
            }
            return false;
        }
        if (left=='['){
            if (right==']'){
                return true;
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
        //20
        String s = "(){";
        System.out.println(isValid(s));

	// write your code here53
//        int []nums =new int[]{
//                -2,1,-3,4,-1,2,1,-5,4
//        };
//        System.out.println(maxSubArray(nums));
    }
}

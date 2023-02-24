package com.itheima.test;

import org.junit.jupiter.api.Test;

import java.util.*;

public class UploadFileTest {
    @Test
    public void test1(){
        String fileName = "ererewe.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }


    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        int res;
        for(String token : tokens){
            if(!token.equals("+")&&!token.equals("/")&&!token.equals("*")&&!token.equals("-")){
                stack.push(token);
            }else if(token.equals("+")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                String sum = num1+num2+"";
                stack.push(sum);
            }else if(token.equals("-")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                String sum = num1-num2+"";
                stack.push(sum);
            }else if(token.equals("*")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                String sum = num1*num2+"";
                stack.push(sum);
            }else if(token.equals("/")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                String sum = num2/num1+"";
                stack.push(sum);
            }else{
                return -1;
            }
        }
        res = Integer.valueOf(stack.pop());
        return res;


    }


    @Test
    public void test2(){
        String[] tokens = new String[]{"4","13","5","/","+"};
        int i = evalRPN(tokens);
        System.out.println(i);
    }
}

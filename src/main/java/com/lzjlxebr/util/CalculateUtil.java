package com.lzjlxebr.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * create: lzjlxebr
 * time: 2018/12/11 下午8:42
 * description: 解析并计算一个算术表达式，目前可支持常规的四则运算
 * TODO 1 负数无法识别
 * TODO 2 小数计算存在精确度的问题
 **/
public class CalculateUtil {

    /**
     * 将计算语句转化为list集合
     *
     * @param middleStatement 运算式
     * @return
     */
    public static List<String> parseStatementToList(String middleStatement){
        List<String> stringList = new ArrayList<>();

        char[] sChar = middleStatement.toCharArray();

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < sChar.length; i++) {
            char c = sChar[i];

            if ('0' <= c && '9' >= c || '.' == c) {
                int number = c - '0';
                System.out.println("buffer appended a number: " + number);
                buffer.append(c);
                System.out.println("now buffer: " + buffer);
            } else {
                String prev = buffer.toString();
                if(prev != null && !"".equals(prev)){

                    stringList.add(prev);
                    buffer = new StringBuffer();
                }

                stringList.add(String.valueOf(c));
            }
        }
        String prev = buffer.toString();
        if(!StringUtil.isEmpty(prev)){
            stringList.add(prev);
        }

        return stringList;
    }

    /**
     * 将中缀表达式转化为后缀表达式
     *
     * @param buffer 中缀表达式列表
     * @return
     */
    public static List<String> parseMiddleToSuffixStatement(List<String> buffer){

        /*
        中缀表达式转换为后缀表达式规则：
        1、当当前字符为数字时，直接输出；
        2、当当前字符为'('时，将其压栈；
        3、当当前字符为')'时，则弹出堆栈中最上的'('之前的所有运算符并输出，然后删除堆栈中的'(' ；
        4、当当前字符为运算符时，则依次弹出堆栈中优先级大于等于当前运算符的（到'('之前为止），输出，再将当前运算符压栈；
        5、最后弹出所有栈中的内容输出
         */

        // 最后需要返回的列表
        List<String> list = new ArrayList<>();

        // 定义栈
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < buffer.size(); i++) {
            String str = buffer.get(i);

            if (StringUtil.canConvertToNumber(str)) {
                list.add(str);
            }else{
                switch (str){
                    case "(":{
                        stack.push(str);
                        break;
                    }
                    case ")":{
                        int index = stack.indexOf("(");
                        int stackSize = stack.size();
                        for (int j = stackSize - 1; j > index; j--) {
                            String op = stack.get(j);
                            if(StringUtil.isNormalOperator(op)){
                                list.add(op);
                                stack.remove(j);
                            }
                        }
                        stack.remove(index);

                        break;
                    }
                    case "+":
                    case "-":{
                        int index = stack.indexOf("(");
                        int stackSize = stack.size();
                        for (int j = stackSize - 1; j > index; j--) {
                            String op = stack.get(j);
                            if(StringUtil.isNormalOperator(op)){
                                list.add(op);
                                stack.remove(j);
                            }
                        }
                        stack.push(str);

                        break;
                    }
                    case "*":
                    case "/":{
                        int index = stack.indexOf("(");
                        int stackSize = stack.size();
                        for (int j = stackSize - 1; j > index; j--) {
                            String op = stack.get(j);
                            if(StringUtil.isHighLevelOperator(op)){
                                list.add(op);
                                stack.remove(j);
                            }
                        }
                        stack.push(str);
                        break;
                    }
                }
            }
        }

        while (stack.size() > 0){
            list.add(stack.pop());
        }

        return list;
    }

    /**
     * 计算后缀表达式
     *
     * @param statement 表达式
     * @return
     */
    public static String operatorSuffixResolve(List<String> statement) {

        /*
         后缀表达式运算规则：
         1、遇到数字直接压栈；
         2、遇到运算符，先将栈顶的数字弹出放置在运算表达式的右侧，
            再次弹栈得到的栈顶值放在左侧，赋予当前的运算符计算，将计算得到的值压栈；
         3、知道栈中只剩下一个，且表达式已经遍历完成，这个值就是最后的结果。
         */

        // 声明一个栈
        Stack<String> stack = new Stack<>();

        // 定义结果
        String result = null;

        // 计算次数，没什么意义
        int count = 0;
        for (int i = 0; i < statement.size(); i++) {
            //int a = (int)s[i];
            String c = statement.get(i);
            if (StringUtil.canConvertToNumber(c)) {
                stack.push(c);
                System.out.println("now stack: " + stack);
            } else {
                // The top one at right
                Number right = StringUtil.convertToNumber(stack.pop());

                // The next top one at left
                Number left = StringUtil.convertToNumber(stack.pop());

                result = calculate(left,right,c);

                System.out.println("result of " + (++count) + " times calculate: " + result);

                // Push result to stack
                System.out.println("stack pushed a number: " + result);
                stack.push(result);
                System.out.println("now stack: " + stack);
            }
        }

        return result;
    }

    /**
     * 处理简单的加减乘除
     *
     * @param left
     * @param right
     * @param operator
     * @return
     */
    private static String calculate(Number left, Number right, String operator) {
        Number result = null;
        switch (operator){
            case "+":{
                result = left.doubleValue() + right.doubleValue();
                break;
            }
            case "-":{
                result = left.doubleValue() - right.doubleValue();
                break;
            }
            case "*":{
                result = left.doubleValue() * right.doubleValue();
                break;
            }
            case "/":{
                result = left.doubleValue() / right.doubleValue();
                break;
            }
        }
        return result + "";
    }

    public static void main(String[] args) {
        System.out.println("the final result: "+operatorSuffixResolve(
                parseMiddleToSuffixStatement(
                        parseStatementToList("(341.8+456)-443.03*5478/(78841/223.89-(43243+899))"))));
    }
}

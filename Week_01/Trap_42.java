package Week01;

import java.util.Stack;

/**
 * 42. 接雨水
 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

 */
public class Trap_42 {

    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>(); //存放数组下标  左边界下标
        for (int i = 0 ; i < height.length ; i++) {
            //计算面积并累加
            while (!stack.empty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.empty()) break;
                int distance = i - stack.peek() - 1;
                int bounded_height = Math.min(height[i],height[stack.peek()]) - height[top];
                result += distance * bounded_height;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Trap_42 largestRectangleArea = new Trap_42();
        System.out.println(largestRectangleArea.trap(new int[] {4,2,3}));
    }



}

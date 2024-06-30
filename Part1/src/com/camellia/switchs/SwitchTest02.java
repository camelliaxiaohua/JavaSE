package com.camellia.switchs;

public class SwitchTest02 {
        public static void main(String[] args) {
            int day = 13;
            String dayType = switch (day) {
                case 1, 2, 3, 4, 5 -> "Weekday"; // 使用表达式作为分支条件
                case 6, 7 -> "Weekend";
                default -> { // default分支
                    yield "Invalid day"; // 使用yield返回值
                }
            };
            System.out.println("Day type: " + dayType);
        }
}

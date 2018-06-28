package com.tyr.designpattern.behavior.strategy;

import java.util.Arrays;

/**
 * @Auther: TaoYiran
 * @Date: 2018/6/27 18:18
 * @Description:比起模板方法模式，更加解耦——将多种算法都必须实现的基本方法（length、needSwap）等抽象到接口中，
 */
public class BubbleSorter<T>{

    private SorterHandler sorterHandler;

    public BubbleSorter(SorterHandler sorterHandler){
        this.sorterHandler = sorterHandler;
    }

    /**
     * 冒泡排序
     */
    public int sort(T array) {
        sorterHandler.setArray(array);
        int length = sorterHandler.getLength();

        int operations = 0;
        if (length <= 1) {
            return operations;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                operations++;
                if (sorterHandler.needSwap(j)) {
                    sorterHandler.swap(j);
                }
            }
        }

        return operations;
    }
}

/**
 * 将不同算法的共用
 * @param <T>
 */
interface SorterHandler<T>{
    public void setArray(T array);

    public int getLength();

    public boolean needSwap(int index);

    public void swap(int index);
}

class IntArrayBubbleHandler implements SorterHandler<int[]> {

    private int[] array;

    @Override
    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public int getLength() {
        return array.length;
    }

    @Override
    public boolean needSwap(int index) {
        return array[index]>array[index+1];
    }

    @Override
    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}

class TestClass{
    public static void main(String[] args) {
        int[] ints = {33, 23, 22, 655, 7, 21, 82, 421, 95, 10, 4, 5430};
        BubbleSorter<Object> sorter = new BubbleSorter<>(new IntArrayBubbleHandler());
        int operates = sorter.sort(ints);
        System.out.println("operates:"+operates+",arrays:"+ Arrays.toString(ints));


    }
}
package com.tyr.designpattern.behavior.templatemethod;

import java.util.Arrays;

/**
 * @Auther: TaoYiran
 * @Date: 2018/6/27 17:24
 * @Description:  也是非常好用的设计模式。提高代码复用性，尤其针对于算法代码，父类引用子类方法：通过泛型和抽象方法。
 */
public abstract class BubbleSorter<T> {
    /**
     * 冒泡排序
     */
    public int sort(T array) {

        setArray(array);
        int length = getLength();

        int operations = 0;
        if (length <= 1) {
            return operations;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                operations++;
                if (needSwap(j)) {
                    swap(j);
                }
            }
        }

        return operations;
    }

    /**
     * 初始化排序数组
     */
    protected abstract void setArray(T array);

    /**
     * @return 返回数组长度
     */
    protected abstract int getLength();

    /**
     * @return 是否需要交换数组中 index 和 index+1 元素
     */
    protected abstract boolean needSwap(int index);

    /**
     * 交换array数组中的 index 和 index+1 元素
     */
    protected abstract void swap(int index);
}

class IntArrayBubbleSorter extends BubbleSorter<int[]>{

    private int[] array;

    @Override
    protected void setArray(int[] array) {
        this.array = array;
    }

    @Override
    protected int getLength() {
        return array.length;
    }

    @Override
    protected boolean needSwap(int index) {
        return array[index]>array[index+1];
    }

    @Override
    protected void swap(int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}

class StringBubbleSorter extends BubbleSorter<String[]>{

    private String[] array;

    @Override
    protected void setArray(String[] array) {
        this.array = array;
    }

    @Override
    protected int getLength() {
        return array.length;
    }

    @Override
    protected boolean needSwap(int index) {
        return array[index].hashCode()>array[index+1].hashCode();
    }

    @Override
    protected void swap(int index) {
        String temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }
}

class test{
    public static void main(String[] args) {
        IntArrayBubbleSorter intArrayBubbleSorter = new IntArrayBubbleSorter();
        int[] ints = {3, 4, 65, 12, 43, 62, 89, 2, 33, 55};
        intArrayBubbleSorter.sort(ints);
        System.out.println(Arrays.toString(ints));

        StringBubbleSorter stringBubbleSorter = new StringBubbleSorter();
        String[] strings = {"abc","rew","joisd","erwyqui","924421","fjhdposf"};
        stringBubbleSorter.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
package com.beini.test.javase.pattern.strategy;


/**
 * Created by beini on 2018/2/5.
 * 1、消除了if else或者switch case的分支判断；
 * 2、采用独立的算法类，易于根据新需求进行扩展；
 * 3、方便开发者对算法细节做自定义处理；
 * 4、允许随时设定策略，即可在构造时设置，也可用专门的set方法设置，还可在执行时设置算法；
 */
public class Test {

    public static void main(String args[]) {
        Context contextAdd = new Context(new DoOperationAdd());
        int rusultAdd = contextAdd.executeStrategy(33, 44);
        System.out.println("rusultAdd=" + rusultAdd);
        Context contextReduce = new Context(new DoOperationReduce());
        int rusultReduce = contextReduce.executeStrategy(33, 44);
        System.out.println("rusultReduce=" + rusultReduce);
        Context contextMultiply = new Context(new DoOperationMultiply());
        int rusultMultiply = contextMultiply.executeStrategy(33, 44);
        System.out.println("rusultMultiply=" + rusultMultiply);
    }

}

package com.springboot.eqd.utils;

/**
 * @author: 李自强
 * @description: ColaBeanUtilsCallBack
 * @date: 2021/5/10 下午1:17
 */
@FunctionalInterface
public interface BeanCpUtilCallBack<S, T> {

    void callBack(S t, T s);
}

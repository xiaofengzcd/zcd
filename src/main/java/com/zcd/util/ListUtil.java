package com.zcd.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @description: 两个list之间的对比,是否增加,包含,减少元素
 * @create 2020/6/2 18:01
 */
public class ListUtil {

    /**
     * 判断元素element是否是sourceList列表中的一个子元素
     * @param sourceList 源列表
     * @param element 待判断的包含元素
     * @return 包含返回 true，不包含返回 false
     */
    private static <E> boolean myListContains(List<E> sourceList, E element) {
        if (sourceList == null || element == null){
            return false;
        }
        if (sourceList.isEmpty()){
            return false;
        }
        for (E tip : sourceList){
            if(element.equals(tip)){
                return true;
            }
        }
        return false;
    }

    /**
     * 计算列表aList相对于bList的增加的情况，兼容任何类型元素的列表数据结构
     * @param aList 本列表
     * @param bList 对照列表
     * @return 返回增加的元素组成的列表
     */
    public static <E> List<E> getAddaListThanbList(List<E> aList, List<E> bList){
        List<E> addList = new ArrayList<E>();
        for (int i = 0; i < aList.size(); i++){
            if(!myListContains(bList, aList.get(i))){
                addList.add(aList.get(i));
            }
        }
        return addList;
    }

    /**
     * 计算列表aList相对于bList的减少的情况，兼容任何类型元素的列表数据结构
     * @param aList 本列表
     * @param bList 对照列表
     * @return 返回减少的元素组成的列表
     */
    public static <E> List<E> getReduceaListThanbList(List<E> aList, List<E> bList){
        List<E> reduceaList = new ArrayList<E>();
        for (int i = 0; i < bList.size(); i++){
            if(!myListContains(aList, bList.get(i))){
                reduceaList.add(bList.get(i));
            }
        }
        return reduceaList;
    }
}

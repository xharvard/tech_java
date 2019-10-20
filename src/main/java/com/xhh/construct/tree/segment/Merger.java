package com.xhh.construct.tree.segment;

/**
 * 线段树的合并方法
 * 
 * @param <E>
 */
public interface Merger<E> {
	E merge(E a, E b);
}

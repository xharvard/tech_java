package com.xhh.construct.tree.segment;

@SuppressWarnings("unchecked")
public class SegmentTree<E> {

	private E[] tree; // 存储线段树对应的平衡二叉树的值
	private E[] data; // 原始数据的数组
	Merger<E> merger; // 线段合并算法

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;
		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}

		tree = (E[]) new Object[4 * arr.length];
		buildSegmentTree(0, 0, arr.length - 1);
	}

	public int getSize() {
		return data.length;
	}

	public E get(int index) {
		if (index < 0 || index >= data.length)
			throw new IllegalArgumentException("Index is illegal.");
		return data[index];
	}

	/**
	 * 构建线段树
	 * 
	 * @param index
	 *            树的索引
	 * @param start
	 *            区间开始
	 * @param end
	 *            区间结束
	 */
	private void buildSegmentTree(int index, int start, int end) {
		if (start == end) {
			tree[index] = data[start];
			return;
		}

		int left = leftChild(index);
		int right = rightChild(index);
		int mid = start + (end - start) / 2;
		buildSegmentTree(left, start, mid);
		buildSegmentTree(right, mid + 1, end);
		tree[index] = merger.merge(tree[left], tree[right]);
	}

	/**
	 * 返回 [queryL - queryR] 区间的值
	 * 
	 * @param queryL
	 * @param queryR
	 * @return
	 */
	public E query(int queryL, int queryR) {
		if (queryL < 0 || queryL >= tree.length || queryR < 0 || queryR >= tree.length || queryL > queryR)
			throw new IllegalArgumentException("parameter is illegal.");

		return query(0, 0, data.length - 1, queryL, queryR);
	}

	/**
	 * 
	 * @param index
	 *            根索引
	 * @param start
	 *            值的开始区间
	 * @param end
	 *            值的结束区间
	 * @param queryL
	 *            查询的开始区间
	 * @param queryR
	 *            查询的结束区间
	 * @return
	 */
	private E query(int index, int start, int end, int queryL, int queryR) {
		if (start == queryL && end == queryR)
			return tree[index];

		int leftIndex = leftChild(index);
		int rightIndex = rightChild(index);
		int mid = start + (end - start) / 2;

		// 在右边
		if (queryL >= mid + 1)
			return query(rightIndex, mid + 1, end, queryL, queryR);
		// 在左边
		else if (queryR <= mid)
			return query(leftIndex, start, mid, queryL, queryR);

		// 两边都有
		E leftValue = query(leftIndex, start, mid, queryL, mid);
		E rightValue = query(rightIndex, mid + 1, end, mid + 1, queryR);
		return merger.merge(leftValue, rightValue);
	}

	// 返回完全二叉树的数组中，索引对应的左孩子节点
	private int leftChild(int index) {
		return 2 * index + 1;
	}

	// 返回完全二叉树的数组中，索引对应的右孩子节点
	private int rightChild(int index) {
		return 2 * index + 2;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] != null)
				sb.append(tree[i]);
			else
				sb.append("null");

			if (i != tree.length - 1)
				sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
}

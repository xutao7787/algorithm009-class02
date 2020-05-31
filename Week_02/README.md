学习笔记 - Week_02

------

**1.哈希表：**

​	通过哈希函数可以把要存储的值映射到一个位置。  不同的值通过哈希函数算出来的位置有可能相同，发生哈希碰撞。  可以通过链表的方式解决（拉链式解决冲突法），在重复的元素向后累加。  正常情况下，添加、删除、查询都是O(1)的时间复杂度，如果哈希函数选的不好，造成链表不断累加，就会是O(n)的时间复杂度。
  工程中常用的就是：Map：key不重复  key - value对                  Set：不重复元素的集合。  HashSet底层实现是基于HashMap的.

**HashMap的源码分析**：

​	在JDK1.6，JDK1.7中，HashMap采用位桶+链表实现，即使用链表处理冲突，同一hash值的链表都存储在一个链表里。但是当位于一个桶中元素较多，即hash值相等的值过多时，通过key值依次查找的效率较低。而在JDK 1.8中，HashMap采用位桶+链表+红黑树实现，当链表长度超过阀值（8）时，将链表转换为红黑树，这样大大减少了查询时间。

​	get(Object key)、getNode(int hash,Object key)：获取key的hash值，计算hash & (n-1)得到在链表数组中的位置first=tab[hash&(n-1)]，先判断first的key是否与参数key相等，不等就遍历后面的链表/红黑树找到相同的key值返回对应的Value值即可。

​	put(K key,V value)、putVal(int hash,K key,V value ...)：

​	1.先检擦table是否为空，为空调用resize()方法进行容量分配。

​	2.根据传入的key计算hash值，如果hash所在的位置为空，则新建一个节点在该位置。否则发生冲突，判断是链表方式还是红黑树，分别处理。

**2.树、二叉树、二叉搜索树的实现和特性：**

​	树相当于在一维链表的结构上扩展，进行升维，一个节点可以有多个指针。

​     二叉树：一个根只有两个子节点。   LinkedList是特殊化的Tree

​     图：树中有节点形成了环。  Thee树是特殊化的图Graph

  定义 - 示例代码  

```
public class TreeNode{                    
	public int val;
    public TreeNode left,right;
    public TreeNode(int val){
    	this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

二叉树遍历：Pre-order/In-order/Post-order

​     1.前序（Pre-Order）:根 - 左 - 右

​     2.中序（In-Order）: 左- 根 - 右	

​	 3.后序（Post-Order）: 左 - 右 - 根

​     二叉搜索树： Binary Search Tree     排序二叉树，左子树**所有节点**的值均小于它的根节点的值。  右子树**所有节点**的值均大于它的根节点的值。 

​     中序遍历是升序排序

**3.堆（Heap）、二叉堆(Binary Heap)和图(Graph)：**

​	Heap:可以迅速找到一堆数中的最大或者最小值的数据结构。根节点最大的堆叫大顶堆或大根堆、根节点最小 - 小根堆、小顶堆。  常见的有二叉堆、斐波那契堆。  

​	大顶堆：find-max: O(1)  delete-max : O(logn)  insert: O(logn) or O(1)

​	二叉堆：通过完全二叉树实现（注意：不是二叉搜索树）

​    二叉堆实现细节：     1.二叉堆一般都通过“数组”来实现     2.假设“第一个元素”在数组中的索引为0的话，则父节点和子节点的位置关系如下：     

​	（1）索引为i的左孩子的索引是（2*i+1）; 

​	（2）索引为i的右孩子的索引是（2*i+2）;

​    （3）索引为i的父节点的索引是  floor（（i-1）/2）;



2.实战题目解析：最小的K个数、滑动窗口的最大值等问题：主要是对于Priortary Queue的应用，可以好好看看，之前的底层代码实现也相应的看一看。



3.图的实现和特性：现在面试和工程上用的较少，可以略看。 高频的面试题看下解法！
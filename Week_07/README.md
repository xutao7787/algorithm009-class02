**学习笔记 - Week_07**

------

**第7周 第13课 | 字典树和并查集**

**1.Trie(字典树、前缀树)**   需要复习一下前面学过的树的相关知识点，前中后序遍历、层序遍历、BFS、DFS等。

​	1.字典树的数据结构

​		又称单词树或键树，是一种树形结构。典型应用是用于统计大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

​		它的优点是：最大限度的减少无畏的字符串比较，查询效率比哈希表高。

​	2.字典树的核心思想

​		空间换时间

​		利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

​	3.字典树的基本性质

​		节点本身不存完整单词

​		从根节点到某一结点，路径上经过的字符串连接起来，为该结点对应的字符串

​		每个结点的所有子结点路径代表的字符都不相同
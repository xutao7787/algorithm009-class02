学习笔记 – Week_01

1、本周学习了解了Git工具的一些基本命令，并跟随教程进行本地配置。

Git：当今世界上最好用的版本管理工具；GitHub：当今最好的开源项目源码都托管在这里。  作为一个程序员，要让自己沉浸在这样的环境里。

一些基本git命令的使用：
git  status   查看git状态
git   clear     清屏幕
git   add   [文件名]/.(全部)
ls -al    查看当前文件夹下的文件状态
git   commint  -m  ""   提交到git仓库
git   push  -u  origin  master
git  clone  [路径]    克隆代码到本地仓库
pwd   查看当前位置

2、工欲善其事必先利其器，来到这个训练营更多的一个收获就是可以get到一些顶级程序员的开发经验，他们日常的工作习惯，常用的工具，比如：老师提到的自顶向下的编程方式，一些指法上的小操作，善用IDEA的代码补全，规范的code style等。跟随牛人的脚步，自己也可以慢慢成为牛人。

　　刷题的时候很多时候连题目都读不懂，很有挫败感，但据老师说这些都正常。先看题解，不懂的时候就先抄，看过题解明白了题目表达的意思，也理清了解题的思路，今天抄一遍，明天再复刷，加深印象。
　　很多时候，第二遍复刷也想不起来解法，那就再重复前面的动作，再抄一遍，然后过一段时间再复刷。本周的几道题，基本上我都是复刷到第三遍的时候才能比较顺利的默写出来，后面还要结合五毒神掌继续刷！

3、刷题过程中可以感觉到，很多类似结构的题目在解法上都有共通之处，这些需要在平时做的时候去总结积累。
	像移动零、删除数组重复元素、最大盛水量这种一维数组可以采用移动双指针的解法。
	两数之和、三数之和、单词规律这种可以借用哈希表来解决。
	在写程序的时候，还要考虑各种边界条件，有时候自己有思路，写出来的程序却跑不过测试用例，就是有些分支条件没有想到。这个时候就要多看题解，看看别人是怎么思考的，吸取别人的经验。

4、算法与数据结构一直是自己的一块短板，以前没重视，但是想提高这是必须要突破的一个瓶颈。本周每天做题都感觉自己像个弱智，读完题各种懵逼。有的题不用说解法，就连题里问的是啥都不知道，相当挫败。但既然决心要攻破这块，那就跟着老师一步一步学吧，谁曾经还没有当“弱智”的那么一个阶段呢，加油！

5. 设计循环双端队列 - 641 : 参考题解，原来可以这么样的操作数组。  设定两个指针，一个front头位置，一个rear尾位置，初始都为0。 当front == rear时队列为空状态，为了区分队列满和空状态，我们还需要人为的空出一个位置，这样当rear - 1 = front时就是满的状态。 同时我们还要考虑数组下标越界时的情况，这里巧妙的运用了 % 取模的运算，前移操作可以 (front + 1) % capacity，后移操作可以 (rear - 1 + capacity) % capacity 防止数组下标越界，学习到了！ 

6、分析 Queue 和 Priority Queue 的源码

.Queue是一个接口，继承自Collection接口，主要方法有：

boolean add(E e):在不违背队列容量的情况下成功插入返回true，超出容量会抛出IllegalStateException异常。

boolean offer(E e): 在不违背队列容量的情况下成功插入返回true，超出容量无法插入返回false。

E remove():删除并返回队首元素，如果是空队列抛出NoSuchElementException异常。

E poll():删除并返回队首元素，如果是空队列返回null

E element():查询并返回队首元素，如果为空队列抛出异常。

E peek():查询并返回队首元素，如果为空队列返回null。


.PriorityQueue: extends AbstractQueue  --  AbstractQueue implements Queue

private static final int DEFAULT_INITIAL_CAPACITY = 11;

默认初始容量：11

add()方法直接return offer(),两方法一致。

public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e);
    return true;
}

如果容量不够进行扩容，在插入过程中会通过siftUp方法进行排序。

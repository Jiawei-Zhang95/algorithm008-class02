# 学习笔记



### LeetCode 26:  删除排序树组中的重复项

**思路** 

创建两个指针i和j， i 为不重复的元素的index，j 为数组每一个元素的index。

当发现 nums[j] != num[i] 的时候，就把当前最后不重复的元素 nums[i] 改成 nums[j]。

最后返回 i + 1 (因为初始值 i = 0 )



### LeetCode 189: 旋转数组

**思路** 

1) 暴力解法：

```Java
for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
//原数组{1, 2, 3, 4, 5};
//修改完以后变成 {5,1,2,3,4}
```

在此循环之外再加一个i循环k次数即可

*时间复杂度 O(n*k)*

2) O(n) 循环一次的做法，用空间换时间。新建数组

（index +k ）% nums.length 即为每个元素应该出现的位置

```Java
 for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i]; // create temporary int[] a to store each element in correct index. 
        }
```

*时间复杂度：O(n)*

3) Most Voted Answer 

用rotate和reverse的方法

>nums = "----->-->"; k =3
>result = "-->----->";
>
>reverse "----->-->" we can get "<--<-----"
>reverse "<--" we can get "--><-----"
>reverse "<-----" we can get "-->----->"

*时间复杂度  O(N)*



### LeetCode 21: 合并两个有序链表

**思路**

首先建立prehead，让prev指向它

判断条件讲解：

当两个ListNode都非空的时候进行对比，如果有一个是空，那么就代表另外一个Node后面的值是肯定大于这个Node的，那么我们直接把prev.next连接到大的Node去就可以

```Java
while (l1 != null && l2 != null)
```



### LeetCode 88: 合并两个有序数组

**思路**
首先把nums1复制出来一份，O(m)的空间

然后用双指针将元素依次放进nums1中。



System.arraycopy()使用方法：

```Java
public static void arraycopy(Object source_arr, int sourcePos,
                            Object dest_arr, int destPos, int len)
```



*时间复杂度： O(m+n)*

### LeetCode 1: Two Sum

思路：首先读题，是返回index，不是返回目标数字

HashMap存的是<nums[i], i>， 返回的时候返回i

```Java
 if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
```

如果数组里面有这个余数，并且不是自己的话。那么就返回结果



### LeetCode 283: 移动零

**思路1**

第一次遍历记录多少个零，并且记录最后的位置。第二次遍历将此位置后面所有元素变成0

```Java
public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
```



### LeetCode 66: 加一

**思路**
从最后一个index，digit[i] ++

```Java
digits[i] = digits[i] % 10;
```

如果不是0的话，就可以直接return。因为不用进位。

如果所有都要进位的话，那么就新建int[nums.length +1 ] 然后将第一位变成1.

> 999 -> 1000







### Queue, Priority Queue源码分析



**Priority Queue:**

```Java
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
```

当加入一个新元素的时候，PQ会首先检查queue的长度，如果不够的话就使用grow（）增加队列长度。

然后使用

```Java
siftUp(i, e);
```

进行对最新加入元素选择最合适的地方插入。

```Java
private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (key.compareTo((E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = key;
    }
```

新加入的元素会一直和parent相对比，一直到compareTo返回结果大于等于0。然后插入该元素。





### LeetCode 641: 设计循环双端队列

思路：数组中始终有一个front和rear

rear永远指向一个空的地方。

insertFront，先减再赋值

insertLast，先赋值再加

>需要注意的点：1.数组大小是给定大小+1，因为rear所指向的位置始终是空的 2.末尾插入要先赋值再移动rear指针 3.队满和队空的条件需要注意的点：1.数组大小是给定大小+1，因为rear所指向的位置始终是空的 2.末尾插入要先赋值再移动rear指针 3.队满和队空的条件
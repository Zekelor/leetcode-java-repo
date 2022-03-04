<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [ListNode](#listnode)
    - [25.K个一组翻转链表](#25k%E4%B8%AA%E4%B8%80%E7%BB%84%E7%BF%BB%E8%BD%AC%E9%93%BE%E8%A1%A8)
- [Tree](#tree)
    - [124.二叉树的最大路径和](#124%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%A4%A7%E8%B7%AF%E5%BE%84%E5%92%8C)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## Hash相关

### 1.两数之和

### q387.字符串中的第一个唯一字符

## 链表操作

### q2.两数相加

### q19.删除链表的倒数第N个节点

### q25.k个一组翻转链表

### q61.旋转链表

### q138.复制带随机指针的链表

### q206.反转链表

## Tree

### q124.二叉树的最大路径和

> 求最大路径，可以理解为求二叉树从根节点到叶子节点的最大深度综合，因此考虑dfs遍历

解题思路

* __框架__ : 先说框架，很多二叉树的遍历框架如下：

```java
void traverse(TreeNode root){
        // 前序遍历代码位置
        traverse(root.left)
        // 中序遍历代码位置
        traverse(root.right)
        // 后序遍历代码位置
        }
```

* __递归函数__:
    * `dfs(TreeNode node)` 函数目的是向父节点提供最大的路径和；
    * 当前子树的收益情况分为三种：
        * 当前节点值，`node.val`
        * 当前节点 + 左侧节点的值 `node.val+dfs(node.left)`
        * 当前节点 + 右侧节点的值 `node.val + dfs(node.right)`
    * 在每次递归时都要更新下全局的最大值，下一次递归与当前存储的做比较选择最大的 `Math.max(ret,left + right + node.val)`
    * __返回__: 最终的返回值选择当前能够提供的最大路径，同时要包含当前节点 `Math.max(left,right)+node.val`

```java
public class Lc124 {

    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        getMax(root);

        return ret;
    }

    public int getMax(TreeNode node) {
        // 若当前节点为叶子节点，那么返回0
        if (node == null) {
            return 0;
        }

        // dfs遍历左子树，若为空则剪裁掉
        int left = Math.max(0, getMax(node.left));

        // dfs遍历右子树
        int right = Math.max(0, getMax(node.right));


        // 更新最大值，当前遍历的最大值= 左+根+右 ，与全局的ret比较，取最大的
        ret = Math.max(ret, (left + right + node.val));

        // 计算当前节点的左右的最大值，必须添加当前节点的值在内
        return Math.max(left, right) + node.val;
    }
}
```

## 双指针遍历/滑动窗口

### q3_无重复字符的最长子串

### q11_盛最多水的容器

### q15_三数之和

### q16_最接近的三数之和

### q26_删除排序数组中的重复项

### q42_接雨水

### q121_买卖股票的最佳时机

### q209_长度最小的子数组

## 快慢指针遍历

### q141_环形链表

* __快慢指针__

```java
publi

class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
```

### q202_快乐数

### q876_链表的中间结点




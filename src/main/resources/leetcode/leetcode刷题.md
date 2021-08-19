## Tree

### 124.二叉树的最大路径和

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


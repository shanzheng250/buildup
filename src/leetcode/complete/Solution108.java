package leetcode.complete;


/**
 * @ClassName:Solution101
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/20 8:35
 * @Version:1.0
 **/
public class Solution108 {
    /* 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

    示例:

    给定有序数组: [-10,-3,0,5,9],

    一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5

     **/

    /**
     * 功能描述 高度平衡二叉树  + 有序 实际上是树的中序遍历  使用二分法寻找树的节点。然后递归调用
     * @param:
     * @return:
     * @date: 2019/2/27 8:49
     */
    public static TreeNode findTreeNode(int start, int end, int ...a){
        if (start>=end){
            return null;
        }

        int mid = (start+end) /2;

        TreeNode treeNode = new TreeNode(a[mid]);
        treeNode.setLeftTree(findTreeNode(start,mid-1,a));
        treeNode.setRightTree(findTreeNode(mid+1,end,a));
        return treeNode;
    }


    public static void main(String[] args) {
        int [] a= new int[] {-10,-3,0,5,9};

        TreeNode treeNode =  findTreeNode(0,a.length-1,a);

        System.out.println(treeNode);
    }

}

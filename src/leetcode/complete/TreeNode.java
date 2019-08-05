package leetcode.complete;

/**
 * @ClassName:TreeNode
 * @Description: TODO
 * @Author: shanz
 * @Date: 2018/12/7 10:05
 * @Version:1.0
 **/
public class TreeNode {

    int value;

    TreeNode leftTree;

    TreeNode rightTree;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(TreeNode leftTree) {
        this.leftTree = leftTree;
    }

    public TreeNode getRightTree() {
        return rightTree;
    }

    public void setRightTree(TreeNode rightTree) {
        this.rightTree = rightTree;
    }
}

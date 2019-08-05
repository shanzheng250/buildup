package collection;


import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @version:1.0
 * @Author: shanz
 * @Date: 2018/11/6
 */
public class TreeNode {


    /**
     * 寻找节点
     * @param t
     * @return
     */
    public TreeType findTreeNode(TreeType o,TreeType t){
        TreeType temp;

        if (t.value.equals(o.value)){
            return o;
        }

        if ((temp = findTreeNode(o.left,t) )!=null){
            return temp;
        }


        if ((temp = findTreeNode(o.right,t) )!=null){
            return temp;
        }

        return null;
    }

    /**
     *
     * @param e 二叉树高度
     * @return
     */

    public int treeDeep(TreeType e){
        if (e == null){
            return 0;
        }

        int leftDept = treeDeep(e.left);

        int rigthDept = treeDeep(e.right);

        if (leftDept > rigthDept){
            return leftDept+1;
        }else{
            return rigthDept+1;
        }
    }


    /**
     * 先序遍历 根 -> 左 -> 右
     * @param t
     */
    public void DLR(TreeType t){
        if (t==null){
            return;
        }
        System.out.println(t.value);
        DLR(t.left);
        DLR(t.right);
    }

    /**
     * 中序遍历 左->->根->右
     * 当前遍历的节点做为根节点输出
     * @param t
     */
    public void LDR(TreeType t){
        TreeType temp = t;
        if (temp==null){
            return;
        }
        LDR(temp.left);
        System.out.println(temp.value);
        LDR(temp.right);
    }

    /**
     * 后序遍历 左->右->根
     * 当前遍历的节点做为根节点输出
     * @param t
     */
    public void LRD(TreeType t){
        TreeType temp = t;
        if (temp==null){
            return;
        }
        LRD(temp.left);
        LRD(temp.right);
        System.out.println(temp.value);
    }

    /**
     * 层级遍历 广度优先
     * 使用队列，循环遍历队列，队列不为空执行
     * 先入父节点、出父节点。入左节点，右节点
     *
     * @param t
     */
    public void level(TreeType t){
        Queue<TreeType> q = new LinkedBlockingQueue();
        q.add(t);
        int i = 0;

        while (!q.isEmpty()){
            TreeType temp = q.poll();
            System.out.println("level" + i +"为"+temp);
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            i++;
        }
    }

    /**
     * 深度优先算法
     *      * 使用栈，循环遍历栈，队列不为空执行
     *      * 先入父节点、出父节点。入右节点，坐节点
     * @param t
     */
    public void levelDeep(TreeType t){
        Stack<TreeType> s = new Stack<>();
        s.add(t);
        TreeType temp = t;

        while (!s.isEmpty() && temp != null){
            while(temp != null){
                System.out.println(temp.value);
                s.add(temp.left);
                temp = temp.left;
            }

            if (!s.isEmpty()){
                TreeType a = s.pop();
                temp =  a.right;
            }

        }
    }





    /**
     * 左右树节点
     */
    class TreeType{
        TreeType left;
        TreeType right;
        String value;
    }

}

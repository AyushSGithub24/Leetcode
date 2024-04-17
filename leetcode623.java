/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//bfs solution
class Solution {
    public TreeNode addOneRow(TreeNode root, int data, int depth) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            count++;
            for(int i=0;i<size;i++){
                if(count==depth-1){
                    TreeNode rt=q.poll();
                     if(root.left!=null){
                        q.add(root.left);
                    }
                    if(root.right!=null){
                        q.add(root.right);
                    }
                    TreeNode rval=new TreeNode(data);
            if(rt.left!=null){
                TreeNode storeLeft=rt.left;
                rt.left=rval;
                rval.left=storeLeft;
            }
            if(rt.left==null){
                rt.left=rval;
            }
            TreeNode rcal=new TreeNode(data);
            if(rt.right!=null){
                TreeNode storeRight=rt.right;
                rt.right=rcal;
                rcal.right=storeRight;
            }
            if(rt.right==null){
                rt.right=rcal;
            }


                }else{
                    TreeNode rt=q.poll();
                    if(root.left!=null){
                        q.add(root.left);
                    }
                    if(root.right!=null){
                        q.add(root.right);
                    }
                }
            }
        }

        return root;
    }
}
//dfs solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth!=1)
        printCurrentLevel(root,depth-1,val);
        else{
            TreeNode rval=new TreeNode(val);
            rval.left=root;
            root=rval;
        }
        return root;
    }
    void printCurrentLevel(TreeNode root, int level,int data)
    {
        if (root == null)
            return;
        if (level == 1){
            TreeNode rval=new TreeNode(data);
            if(root.left!=null){
                TreeNode storeLeft=root.left;
                root.left=rval;
                rval.left=storeLeft;
            }
            if(root.left==null){
                root.left=rval;
            }
            TreeNode rcal=new TreeNode(data);
            if(root.right!=null){
                TreeNode storeRight=root.right;
                root.right=rcal;
                rcal.right=storeRight;
            }
            if(root.right==null){
                root.right=rcal;
            }
            
            
        }
            
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1,data);
            printCurrentLevel(root.right, level - 1,data);
        }
    }
}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth!=1)
        printCurrentLevel(root,depth-1,val);
        else{
            TreeNode rval=new TreeNode(val);
            rval.left=root;
            root=rval;
        }
        return root;
    }
    void printCurrentLevel(TreeNode root, int level,int data)
    {
        if (root == null)
            return;
        if (level == 1){
            TreeNode rval=new TreeNode(data);
            if(root.left!=null){
                TreeNode storeLeft=root.left;
                root.left=rval;
                rval.left=storeLeft;
            }
            if(root.left==null){
                root.left=rval;
            }
            TreeNode rcal=new TreeNode(data);
            if(root.right!=null){
                TreeNode storeRight=root.right;
                root.right=rcal;
                rcal.right=storeRight;
            }
            if(root.right==null){
                root.right=rcal;
            }
            
            
        }
            
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1,data);
            printCurrentLevel(root.right, level - 1,data);
        }
    }
}

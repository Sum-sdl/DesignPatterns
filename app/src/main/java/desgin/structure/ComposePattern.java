package desgin.structure;

import java.util.Enumeration;
import java.util.Stack;
import java.util.Vector;

import desgin.BaseTest;

/**
 * Created by sdl on 2017/6/16.
 * <p>
 * 组合模式
 * <p>
 * 又叫部分-整体模式在处理类似树形结构的问题时比较方便
 */

public class ComposePattern extends BaseTest {

    @Override
    public void startTest() {

        Tree tree = new Tree("A");
        TreeNode nodeB1 = new TreeNode("B1");
        TreeNode nodeB1_C1 = new TreeNode("B1_C1");
        TreeNode nodeB1_C2 = new TreeNode("B1_C2");
        TreeNode nodeB1_C3 = new TreeNode("B1_C3");
        nodeB1.addChild(nodeB1_C1);
        nodeB1.addChild(nodeB1_C2);
        nodeB1.addChild(nodeB1_C3);


        TreeNode nodeB2 = new TreeNode("B2");
        TreeNode nodeB2_C1 = new TreeNode("B2_C1");
        nodeB2.addChild(nodeB2_C1);

        TreeNode nodeB3 = new TreeNode("B3");

        tree.node.addChild(nodeB1);
        tree.node.addChild(nodeB2);
        tree.node.addChild(nodeB3);

        //遍历
        tree.print();
    }

    private class TreeNode {

        private String name;
        private TreeNode parent;
        private Vector<TreeNode> children = new Vector<>();

        private TreeNode(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public void addChild(TreeNode node) {
            children.add(node);
        }

        public Enumeration<TreeNode> getChildren() {
            return children.elements();
        }

        public void printNode() {
            String size = children.size() > 0 ? "parent" : "child";
            print(size + ":" + name);
        }
    }

    private class Tree {
        public TreeNode node;

        private Tree(String node) {
            this.node = new TreeNode(node);
        }

        public void print() {
            ComposeIterator iterator = new ComposeIterator(node.getChildren());
            while (iterator.hasMoreElements()) {
                TreeNode o = (TreeNode) iterator.nextElement();
                o.printNode();
            }
        }
    }

    private class ComposeIterator implements Enumeration {

        private Stack<Enumeration> stack = new Stack<>();

        public ComposeIterator(Enumeration enumeration) {
            stack.push(enumeration);
        }

        @Override
        public boolean hasMoreElements() {
            if (stack.isEmpty()) {
                return false;
            }
            Enumeration peek = stack.peek();
            if (!peek.hasMoreElements()) {
                stack.pop();
                return hasMoreElements();
            } else {
                return true;
            }

        }

        @Override
        public Object nextElement() {
            if (hasMoreElements()) {
                Enumeration peek = stack.peek();
                TreeNode o = (TreeNode) peek.nextElement();
                stack.push(o.getChildren());
                return o;
            }
            return null;
        }
    }
}

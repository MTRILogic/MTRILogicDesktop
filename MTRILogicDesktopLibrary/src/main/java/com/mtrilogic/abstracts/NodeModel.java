package com.mtrilogic.abstracts;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

@SuppressWarnings("unused")
public abstract class NodeModel extends Model implements MutableTreeNode {

    protected final DefaultMutableTreeNode node;

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

    public NodeModel(long id, int type, boolean enabled) {
        this(id, type, enabled, false);
    }

    public NodeModel(long id, int type, boolean enabled, boolean allowsChildren) {
        super(id, type, enabled);
        node = new DefaultMutableTreeNode(this, allowsChildren);
    }

    public NodeModel(long id, int type, boolean enabled,DefaultMutableTreeNode node) {
        super(id, type, enabled);
        this.node = node;
    }

    /*==================================================================================================================
    OVERRIDE PUBLIC FINAL METHODS
    ==================================================================================================================*/

    @Override
    public final void insert(MutableTreeNode child, int index) {
        node.insert(child, index);
    }

    @Override
    public final void remove(int index) {
        node.remove(index);
    }

    @Override
    public final void remove(MutableTreeNode node) {
        this.node.remove(node);
    }

    @Override
    public final void setUserObject(Object object) {
        node.setUserObject(object);
    }

    @Override
    public final void removeFromParent() {
        node.removeFromParent();
    }

    @Override
    public final void setParent(MutableTreeNode newParent) {
        node.setParent(newParent);
    }

    @Override
    public final TreeNode getChildAt(int childIndex) {
        return node.getChildAt(childIndex);
    }

    @Override
    public final int getChildCount() {
        return node.getChildCount();
    }

    @Override
    public final TreeNode getParent() {
        return node.getParent();
    }

    @Override
    public final int getIndex(TreeNode node) {
        return this.node.getIndex(node);
    }

    @Override
    public final boolean getAllowsChildren() {
        return node.getAllowsChildren();
    }

    @Override
    public final boolean isLeaf() {
        return node.isLeaf();
    }

    @Override
    public final Enumeration<? extends TreeNode> children() {
        return node.children();
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final DefaultMutableTreeNode getNode() {
        return node;
    }
}

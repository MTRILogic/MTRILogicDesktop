package com.mtrilogic.classes;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.abstracts.NodeModel;
import com.mtrilogic.abstracts.TreeItem;
import com.mtrilogic.adapters.TreeAdapter;

import javax.swing.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultTree extends JTree {

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

    public DefaultTree() {
        super();
    }

    public DefaultTree(NodeModel[] nodeModels) {
        super(nodeModels);
    }

    public DefaultTree(List<NodeModel> nodeModelList) {
        super(new Vector<>(nodeModelList));
    }

    public DefaultTree(Hashtable<Model, NodeModel> nodeModelHashtable) {
        super(nodeModelHashtable);
    }

    public DefaultTree(NodeModel nodeModel) {
        super(nodeModel);
    }

    public DefaultTree(NodeModel nodeModel, boolean asksAllowsChildren) {
        super(nodeModel, asksAllowsChildren);
    }

    public DefaultTree(TreeAdapter adapter) {
        super(adapter);
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final TreeAdapter getTreeAdapter(){
        return (TreeAdapter) getModel();
    }

    public final void setTreeAdapter(TreeAdapter adapter){
        setModel(adapter);
    }

    public final <NM extends NodeModel> TreeItem<NM> getTreeItem(Class<TreeItem<NM>> clazz){
        return clazz.cast(getCellRenderer());
    }

    public final <NM extends NodeModel> void setItem(TreeItem<NM> item){
        setCellRenderer(item);
    }
}

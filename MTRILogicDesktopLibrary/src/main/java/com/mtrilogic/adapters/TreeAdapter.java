package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.NodeModel;

import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("unused")
public class TreeAdapter extends DefaultTreeModel {

    public TreeAdapter(NodeModel rootItem) {
        super(rootItem);
    }

    public TreeAdapter(NodeModel rootModel, boolean asksAllowsChildren) {
        super(rootModel, asksAllowsChildren);
    }

    public NodeModel getRootModel(){
        return (NodeModel) getRoot();
    }

    public NodeModel getChildModel(NodeModel parentModel, int position){
        return (NodeModel) getChild(parentModel, position);
    }

    public int getChildModelCount(NodeModel parentModel){
        return getChildCount(parentModel);
    }

    public int getChildModelPosition(NodeModel parentModel, NodeModel childModel){
        return getIndexOfChild(parentModel, childModel);
    }

    public void setRootModel(NodeModel rootModel){
        setRoot(rootModel);
    }

    public void insertChildModel(NodeModel parentModel, int position, NodeModel childModel){
        insertNodeInto(childModel, parentModel, position);
    }
}

package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.NodeModel;

import javax.swing.tree.DefaultTreeModel;

@SuppressWarnings("unused")
public class TreeAdapter extends DefaultTreeModel {

    /*==================================================================================================================
    CONSTRUCTORS
    ==================================================================================================================*/

    public TreeAdapter(NodeModel rootItem) {
        super(rootItem);
    }

    public TreeAdapter(NodeModel rootModel, boolean asksAllowsChildren) {
        super(rootModel, asksAllowsChildren);
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final NodeModel getRootModel(){
        return (NodeModel) getRoot();
    }

    public final NodeModel getChildModel(NodeModel parentModel, int position) {
        return (NodeModel) getChild(parentModel, position);
    }

    public final int getChildModelCount(NodeModel parentModel){
        return getChildCount(parentModel);
    }

    public final int getChildModelPosition(NodeModel parentModel, NodeModel childModel) {
        return getIndexOfChild(parentModel, childModel);
    }

    public final void setRootModel(NodeModel rootModel){
        setRoot(rootModel);
    }

    public final void insertChildModel(NodeModel parentModel, int position, NodeModel childModel) {
        insertNodeInto(childModel, parentModel, position);
    }
}

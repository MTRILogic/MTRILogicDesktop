package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.NodeModel;
import com.mtrilogic.adapters.TreeAdapter;
import com.mtrilogic.classes.DefaultTree;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TreeItemListener {

    void onTreeItemClick(MouseEvent event, NodeModel model, int row);

    DefaultTree getDefaultTree();

    TreeAdapter getTreeAdapter();
}

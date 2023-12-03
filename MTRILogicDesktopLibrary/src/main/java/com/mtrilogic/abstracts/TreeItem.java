package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.TreeAdapter;
import com.mtrilogic.classes.DefaultTree;
import com.mtrilogic.interfaces.TreeItemListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class TreeItem <NM extends NodeModel> extends SpringPanel implements TreeCellRenderer {

    private final DefaultTreeCellRenderer renderer;
    private final TreeItemListener listener;
    private final Class<NM> clazz;

    protected abstract boolean onTreeItemRenderer(DefaultTree tree, NM model, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus);

    public TreeItem(Class<NM> clazz, TreeItemListener listener){
        this(null, clazz, listener);
    }

    public TreeItem(DefaultTreeCellRenderer renderer, Class<NM> clazz, TreeItemListener listener){
        if (renderer == null){
            renderer = new DefaultTreeCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        listener.getDefaultTree().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int row = getDefaultTree().getRowForLocation(event.getX(), event.getY());
                if (row >= 0) {
                    TreeAdapter adapter = getTreeAdapter();
                    NM model = clazz.cast(adapter.getChild(adapter.getRoot(), row));
                    listener.onTreeItemClick(event, model, row);
                }
            }
        });
    }

    @Override
    public final Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if (!onTreeItemRenderer(getDefaultTree(), clazz.cast(value), selected, expanded, leaf, row, hasFocus)) {
            return renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        } else {
            return this;
        }
    }

    protected DefaultTree getDefaultTree(){
        return listener.getDefaultTree();
    }

    protected TreeAdapter getTreeAdapter(){
        return listener.getTreeAdapter();
    }
}

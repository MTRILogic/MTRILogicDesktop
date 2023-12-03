package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.ListAdapter;
import com.mtrilogic.classes.DefaultList;
import com.mtrilogic.interfaces.ListItemListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ListItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    protected final DefaultListCellRenderer renderer;
    protected final ListItemListener listener;
    protected final Class<M> clazz;

    protected abstract boolean onListItemRenderer(DefaultList list, M model, int index, boolean isSelected, boolean cellHasFocus);

    public ListItem(Class<M> clazz, ListItemListener listener){
        this(null, clazz, listener);
    }

    public ListItem(DefaultListCellRenderer renderer, Class<M> clazz, ListItemListener listener) {
        if (renderer == null) {
            renderer = new DefaultListCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        addMouseListener();
    }

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M model, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onListItemRenderer(getDefaultList(), model, index, isSelected, cellHasFocus)) {
            return renderer.getListCellRendererComponent(list, model, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    protected DefaultList getDefaultList(){
        return listener.getDefaultList();
    }

    protected ListAdapter getListAdapter(){
        return listener.getListAdapter();
    }

    protected void addMouseListener() {
        DefaultList list = getDefaultList();
        list.addMouseListener(new MouseAdapter() {
            @Override
            // See NOTE in method locationToIndex of the class DefaultList
            public void mouseClicked(MouseEvent e) {
                int index = list.locationToIndex(e.getPoint());
                if (index >= 0) {
                    M model = clazz.cast(getListAdapter().getElementAt(index));
                    listener.onListItemClick(e, model, index);
                } else {
                    if (!e.isShiftDown() && !isMenuShortcutKeyDown(e)) {
                        list.clearSelection();
                    }
                }
            }
        });
    }

    private boolean isMenuShortcutKeyDown(InputEvent event) {
        return (event.getModifiersEx() & Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()) != 0;
    }
}

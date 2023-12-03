package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.ComboBoxAdapter;
import com.mtrilogic.classes.DefaultComboBox;
import com.mtrilogic.interfaces.ComboBoxItemListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ComboBoxItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    protected final ComboBoxItemListener listener;
    protected final DefaultListCellRenderer renderer;
    protected final Class<M> clazz;


    protected abstract boolean onComboBoxItemRenderer(DefaultComboBox list, M model, int index, boolean isSelected, boolean cellHasFocus);

    public ComboBoxItem(Class<M> clazz, ComboBoxItemListener listener) {
        this(null, clazz, listener);
    }

    public ComboBoxItem(DefaultListCellRenderer renderer, Class<M> clazz, ComboBoxItemListener listener) {
        if (renderer == null) {
            renderer = new DefaultListCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        listener.getDefaultComboBox().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int index = getDefaultComboBox().getSelectedIndex();
                M model = clazz.cast(getAdapter().getElementAt(index));
                listener.onComboBoxItemClick(event, model, index);
            }
        });
    }

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M model, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onComboBoxItemRenderer(getDefaultComboBox(), model, index, isSelected, cellHasFocus)) {
            return renderer.getListCellRendererComponent(list, model, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    protected DefaultComboBox getDefaultComboBox(){
        return listener.getDefaultComboBox();
    }

    protected ComboBoxAdapter getAdapter(){
        return listener.getComboBoxAdapter();
    }
}

package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.ComboBoxAdapter;
import com.mtrilogic.classes.DefaultComboBox;
import com.mtrilogic.interfaces.ComboBoxItemListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("unused")
public abstract class ComboBoxItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    protected final ComboBoxItemListener listener;
    protected final DefaultListCellRenderer renderer;
    protected final Class<M> clazz;

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

    protected abstract boolean onComboBoxItemRenderer(DefaultComboBox list, M model, int index, boolean isSelected, boolean cellHasFocus);

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

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

        getDefaultComboBox().addMouseListener(getMouseListener());
    }

    /*==================================================================================================================
    OVERRIDE PUBLIC FINAL METHODS
    ==================================================================================================================*/

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M model, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onComboBoxItemRenderer(getDefaultComboBox(), model, index, isSelected, cellHasFocus)) {
            return renderer.getListCellRendererComponent(list, model, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    /*==================================================================================================================
    PROTECTED FINAL METHODS
    ==================================================================================================================*/

    protected final DefaultComboBox getDefaultComboBox(){
        return listener.getDefaultComboBox();
    }

    protected final ComboBoxAdapter getComboBoxAdapter(){
        return listener.getComboBoxAdapter();
    }

    /*==================================================================================================================
    PRIVATE METHODS
    ==================================================================================================================*/

    private MouseListener getMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int index = getDefaultComboBox().getSelectedIndex();
                M model = clazz.cast(getComboBoxAdapter().getElementAt(index));
                listener.onComboBoxItemClick(event, model, index);
            }
        };
    }
}

package com.mtrilogic.classes;

import com.mtrilogic.abstracts.ListItem;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ListAdapter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultList extends JList<Model> {

    /*==================================================================================================================
    CONSTRUCTORS
    ==================================================================================================================*/

    public DefaultList(ListAdapter adapter) {
        super(adapter);
    }

    public DefaultList(Model[] models) {
        super(models);
    }

    public DefaultList(List<Model> modelList) {
        super(new Vector<>(modelList));
    }

    public DefaultList() {
        super();
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final ListAdapter getListAdapter(){
        return (ListAdapter) getModel();
    }

    public final void setListAdapter(ListAdapter adapter){
        setModel(adapter);
    }

    public final ListItem<Model> getItem(Class<ListItem<Model>> clazz){
        return clazz.cast(getCellRenderer());
    }

    public final void setItem(ListItem<Model> item){
        setCellRenderer(item);
    }

    /*==================================================================================================================
    OVERRIDE PUBLIC FINAL METHODS
    ==================================================================================================================*/

    // NOTE: Helps prevent the last item from being selected when clicking on a blank space
    // https://stackoverflow.com/questions/11138665/how-to-prevent-jlist-from-making-selection-outside-cell-bounds
    @Override
    public final int locationToIndex(Point location) {
        int index = super.locationToIndex(location);
        if (index != -1 && !getCellBounds(index, index).contains(location)) {
            return -1;
        }
        else {
            return index;
        }
    }
}

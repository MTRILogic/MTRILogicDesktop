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

    public ListAdapter getListAdapter(){
        return (ListAdapter) getModel();
    }

    public void setAdapter(ListAdapter adapter){
        setModel(adapter);
    }

    public ListItem<Model> getItem(Class<ListItem<Model>> clazz){
        return clazz.cast(getCellRenderer());
    }

    public void setItem(ListItem<Model> item){
        setCellRenderer(item);
    }

    // NOTE: Helps prevent the last item from being selected when clicking on a blank space
    // https://stackoverflow.com/questions/11138665/how-to-prevent-jlist-from-making-selection-outside-cell-bounds
    @Override
    public int locationToIndex(Point location) {
        int index = super.locationToIndex(location);
        if (index != -1 && !getCellBounds(index, index).contains(location)) {
            return -1;
        }
        else {
            return index;
        }
    }
}

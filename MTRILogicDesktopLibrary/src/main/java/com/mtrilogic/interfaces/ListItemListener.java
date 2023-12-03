package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ListAdapter;
import com.mtrilogic.classes.DefaultList;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface ListItemListener {

    void onListItemClick(MouseEvent event, Model model, int index);

    DefaultList getDefaultList();

    ListAdapter getListAdapter();
}

package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.TableAdapter;
import com.mtrilogic.classes.DefaultTable;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TableItemListener {

    void onTableItemClick(MouseEvent event, Model model, int row, int column);

    DefaultTable getDefaultTable();

    TableAdapter getTableAdapter();
}

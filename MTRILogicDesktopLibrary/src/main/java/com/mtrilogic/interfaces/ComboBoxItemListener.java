package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ComboBoxAdapter;
import com.mtrilogic.classes.DefaultComboBox;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface ComboBoxItemListener {

    void onComboBoxItemClick(MouseEvent event, Model model, int index);

    DefaultComboBox getDefaultComboBox();

    ComboBoxAdapter getComboBoxAdapter();
}

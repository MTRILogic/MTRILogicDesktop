package com.mtrilogic.classes;

import com.mtrilogic.abstracts.ComboBoxItem;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ComboBoxAdapter;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultComboBox extends JComboBox<Model> {

    private final Class<Model> clazz = Model.class;

    /*==================================================================================================================
    CONSTRUCTORS
    ==================================================================================================================*/

    public DefaultComboBox(ComboBoxAdapter adapter) {
        super(adapter);
    }

    public DefaultComboBox(Model[] models) {
        super(models);
    }

    public DefaultComboBox(List<Model> modelList) {
        super(new Vector<>(modelList));
    }

    public DefaultComboBox() {
        super();
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final void addModel(Model model){
        addItem(model);
    }

    public final void insertModel(int position, Model model){
        insertItemAt(model, position);
    }

    public final ComboBoxAdapter getComboBoxAdapter(){
        return (ComboBoxAdapter) getModel();
    }

    public final Model getModel(int position){
        return getItemAt(position);
    }

    public final Model[] getSelectedModels(){
        return (Model[]) getSelectedObjects();
    }

    public final int getSelectedModelPosition(){
        return getSelectedIndex();
    }

    public final int getModelCount(){
        return getItemCount();
    }

    public final void setItem(ComboBoxItem<Model> item){
        setRenderer(item);
    }

    public final void setSelectedModel(Model model){
        setSelectedItem(model);
    }

    public final void setSelectedModelPosition(int position){
        setSelectedIndex(position);
    }

    public final void setAdapter(ComboBoxAdapter adapter){
        setModel(adapter);
    }

    public final void deleteModel(Model model){
        removeItem(model);
    }

    public final void deleteModelPosition(int position){
        removeItemAt(position);
    }
}

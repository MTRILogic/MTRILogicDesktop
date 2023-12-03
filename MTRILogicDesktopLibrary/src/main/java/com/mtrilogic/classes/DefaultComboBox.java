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
    PUBLIC METHODS
    ==================================================================================================================*/

    public void addModel(Model model){
        addItem(model);
    }

    public void insertModel(int position, Model model){
        insertItemAt(model, position);
    }

    public ComboBoxAdapter getComboBoxAdapter(){
        return (ComboBoxAdapter) getModel();
    }

    public Model getModel(int position){
        return getItemAt(position);
    }

    public Model[] getSelectedModels(){
        return (Model[]) getSelectedObjects();
    }

    public int getSelectedModelPosition(){
        return getSelectedIndex();
    }

    public int getModelCount(){
        return getItemCount();
    }

    public void setItem(ComboBoxItem<Model> item){
        setRenderer(item);
    }

    public void setSelectedModel(Model model){
        setSelectedItem(model);
    }

    public void setSelectedModelPosition(int position){
        setSelectedIndex(position);
    }

    public void setAdapter(ComboBoxAdapter adapter){
        setModel(adapter);
    }

    public void deleteModel(Model model){
        removeItem(model);
    }

    public void deleteModelPosition(int position){
        removeItemAt(position);
    }
}

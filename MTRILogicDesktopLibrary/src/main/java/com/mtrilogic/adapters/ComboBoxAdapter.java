package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

@SuppressWarnings("unused")
public class ComboBoxAdapter extends DefaultComboBoxModel<Model> {

    /*==================================================================================================================
    CONSTRUCTORS
    ==================================================================================================================*/

    public ComboBoxAdapter() {
        super();
    }

    public ComboBoxAdapter(Model[] models) {
        super(models);
    }

    public ComboBoxAdapter(List<Model> modelList) {
        super(new Vector<>(modelList));
    }

    /*==================================================================================================================
    PUBLIC METHODS
    ==================================================================================================================*/

    public boolean containsModel(Model model) {
        return getIndexOf(model) != -1;
    }

    // Append ==========================================================================================================

    public void appendModel(Model model) {
        addElement(model);
    }

    public void appendModels(Model[] models) {
        addAll(Arrays.asList(models));
    }

    public void appendModelList(List<Model> modelList) {
        addAll(modelList);
    }

    // Insert ==========================================================================================================

    public void insertModel(int position, Model model) {
        if (isValidPosition(position)) {
            insertElementAt(model, position);
        }
    }

    public void insertModels(int position, Model[] models) {
        if (isValidPosition(position)) {
            addAll(position, Arrays.asList(models));
        }
    }

    public void insertModelList(int position, List<Model> modelList) {
        if (isValidPosition(position)) {
            addAll(position, modelList);
        }
    }

    // Get =============================================================================================================

    public Model getSelectedModel() {
        return (Model) getSelectedItem();
    }

    public Model getModel(int position) {
        return isValidPosition(position) ? getElementAt(position) : null;
    }

    public Model[] getModels() {
        int size = getSize();
        Model[] models = new Model[size];
        for (int i = 0; i < size; i++) {
            models[i] = getElementAt(i);
        }
        return models;
    }

    public List<Model> getModelList() {
        List<Model> modelList = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            modelList.add(getElementAt(i));
        }
        return modelList;
    }

    public int getModelPosition(Model model) {
        return getIndexOf(model);
    }

    public int getModelCount() {
        return getSize();
    }

    // Set =============================================================================================================

    public void setSelectedModel(Model model) {
        setSelectedItem(model);
    }

    // Delete ==========================================================================================================

    public void deleteModel(Model model) {
        removeElement(model);
    }

    public void deletePosition(int position) {
        if (isValidPosition(position)) {
            removeElementAt(position);
        }
    }

    public void deleteModels(Model[] models) {
        for (Model model : models) {
            removeElement(model);
        }
    }

    public void deletePositions(int[] positions) {
        for (int position : positions) {
            removeElementAt(position);
        }
    }

    public void deleteModelList(List<Model> modelList) {
        for (Model model : modelList) {
            removeElement(model);
        }
    }

    public void deletePositionList(List<Integer> positions) {
        for (int position : positions) {
            removeElementAt(position);
        }
    }

    // Clear ===========================================================================================================

    public void clearModels() {
        removeAllElements();
    }

    /*==================================================================================================================
    PRIVATE METHODS
    ==================================================================================================================*/

    private boolean isValidPosition(int position) {
        return position > -1 && position < getSize();
    }
}

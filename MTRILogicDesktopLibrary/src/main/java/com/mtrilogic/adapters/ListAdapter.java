package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.Model;

import javax.swing.*;
import java.util.*;

@SuppressWarnings("unused")
public class ListAdapter extends DefaultListModel<Model> {

    /*==================================================================================================================
    CONSTRUCTORS
    ==================================================================================================================*/

    public ListAdapter() {
        super();
    }

    /*==================================================================================================================
    PUBLIC METHODS
    ==================================================================================================================*/

    public void sort(Comparator<Model> comparator) {
        ArrayList<Model> list = Collections.list(elements());
        list.sort(comparator);
        clear();
        addAll(list);
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
        add(position, model);
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

    public Model getModel(int position) {
        return isValidPosition(position) ? get(position) : null;
    }

    public Model[] getModels() {
        int size = getSize();
        Model[] models = new Model[size];
        for (int i = 0; i < size; i++) {
            models[i] = get(i);
        }
        return models;
    }

    public List<Model> getModelList() {
        List<Model> modelList = new ArrayList<>();
        for (int i = 0; i < getSize(); i++) {
            modelList.add(get(i));
        }
        return modelList;
    }

    public int getModelIndex(Model model) {
        return indexOf(model);
    }

    public int getModelIndex(int position, Model model) {
        return isValidPosition(position) ? indexOf(model, position) : -1;
    }

    public int getModelCount() {
        return getSize();
    }

    // Set =============================================================================================================

    public Model setModel(int position, Model model) {
        return isValidPosition(position) ? set(position, model) : null;
    }

    public Model[] setModels(int position, Model[] models) {
        Model[] oldModels = new Model[models.length];
        for (int i = 0; i < models.length; i++) {
            oldModels[i] = set(position++, models[i]);
        }
        return oldModels;
    }

    public List<Model> setModelList(int position, List<Model> list) {
        List<Model> oldList = new ArrayList<>();
        for (Model model : list) {
            oldList.add(set(position++, model));
        }
        return oldList;
    }

    // Delete ==========================================================================================================

    public Model deletePosition(int position) {
        return isValidPosition(position) ? remove(position) : null;
    }

    public boolean deleteModel(Model model) {
        return removeElement(model);
    }

    public Model[] deletePositions(int[] positions) {
        Model[] models = new Model[positions.length];
        for (int i = 0; i < positions.length; i++) {
            models[i] = remove(positions[i]);
        }
        return models;
    }

    public boolean[] deleteModels(Model[] models) {
        boolean[] removed = new boolean[models.length];
        for (int i = 0; i < models.length; i++) {
            removed[i] = removeElement(models[i]);
        }
        return removed;
    }

    public List<Model> deletePositionList(List<Integer> positions) {
        List<Model> modelList = new ArrayList<>();
        for (int position : positions) {
            modelList.add(remove(position));
        }
        return modelList;
    }

    public List<Boolean> deleteModelList(List<Model> models) {
        List<Boolean> removeList = new ArrayList<>();
        for (Model model : models) {
            removeList.add(removeElement(model));
        }
        return removeList;
    }

    // Clear ===========================================================================================================

    public void clearModels() {
        clear();
    }

    /*==================================================================================================================
    PRIVATE METHODS
    ==================================================================================================================*/

    private boolean isValidPosition(int position) {
        return position > 0 && position < getSize();
    }
}

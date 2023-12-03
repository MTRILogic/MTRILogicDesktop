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
        removeAllElements();
        for (Model model : list) {
            addElement(model);
        }
    }

    // Append ==========================================================================================================

    public void appendModel(Model model) {
        addElement(model);
    }

    public void appendModels(Model[] models) {
        for (Model model : models) {
            addElement(model);
        }
    }

    public void appendModelList(List<Model> list) {
        addAll(list);
    }

    // Insert ==========================================================================================================

    public void insertModel(int position, Model model) {
        add(position, model);
    }

    public void insertModels(int position, Model[] models) {
        if (isValidPosition(position)) {
            for (Model model : models) {
                add(position++, model);
            }
        }
    }

    public void insertModelList(int position, List<Model> list) {
        if (isValidPosition(position)) {
            for (Model model : list) {
                add(position++, model);
            }
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

    // Remove ==========================================================================================================

    public Model removePosition(int position) {
        return isValidPosition(position) ? remove(position) : null;
    }

    public boolean removeModel(Model model) {
        return removeElement(model);
    }

    public Model[] removePositions(int[] positions) {
        Model[] models = new Model[positions.length];
        for (int i = 0; i < positions.length; i++) {
            models[i] = remove(positions[i]);
        }
        return models;
    }

    public boolean[] removeModels(Model[] models) {
        boolean[] removed = new boolean[models.length];
        for (int i = 0; i < models.length; i++) {
            removed[i] = removeElement(models[i]);
        }
        return removed;
    }

    public List<Model> removePositionList(List<Integer> positions) {
        List<Model> modelList = new ArrayList<>();
        for (int position : positions) {
            modelList.add(remove(position));
        }
        return modelList;
    }

    public List<Boolean> removeModelList(List<Model> models) {
        List<Boolean> removeList = new ArrayList<>();
        for (Model model : models) {
            removeList.add(removeElement(model));
        }
        return removeList;
    }

    // Index ===========================================================================================================

    public int getModelIndex(Model model) {
        return indexOf(model);
    }

    public int getModelIndex(int position, Model model) {
        return isValidPosition(position) ? indexOf(model, position) : -1;
    }

    // Size ============================================================================================================

    public int getModelCount() {
        return getSize();
    }

    // Clear ===========================================================================================================

    public void clearModels() {
        removeAllElements();
    }

    /*==================================================================================================================
    PRIVATE METHODS
    ==================================================================================================================*/

    private boolean isValidPosition(int position) {
        return position > 0 && position < getSize();
    }
}

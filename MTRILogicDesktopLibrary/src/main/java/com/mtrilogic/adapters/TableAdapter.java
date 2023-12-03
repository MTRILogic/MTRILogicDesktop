package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.ColumnModel;
import com.mtrilogic.abstracts.Model;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class TableAdapter extends DefaultTableModel {

    private final Class<Model> clazz = Model.class;

    /*==================================================================================================================
    CONSTRUCTORS
    ==================================================================================================================*/

    public TableAdapter() {
        super();
    }

    public TableAdapter(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public TableAdapter(List<ColumnModel> columnModelList, int rowCount) {
        super(new Vector<>(columnModelList), rowCount);
    }

    public TableAdapter(ColumnModel[] columnModels, int rowCount) {
        super(columnModels, rowCount);
    }

    public TableAdapter(List<List<Model>> dataModelList, List<ColumnModel> columnModelList) {
        super(new Vector<>(dataModelList.stream()
                .map(Vector::new)
                .collect(Collectors.toList())), new Vector<>(columnModelList));
    }

    public TableAdapter(Model[][] dataModels, ColumnModel[] columnModels) {
        super(dataModels, columnModels);
    }

    /*==================================================================================================================
    PUBLIC OVERRIDE METHODS
    ==================================================================================================================*/

    @Override
    public boolean isCellEditable(int row, int column) {
        return clazz.cast(getValueAt(row, column)).isEnabled();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        ColumnModel columnModel = (ColumnModel) clazz.cast(columnIdentifiers.get(columnIndex));
        return columnModel.getClazz();
    }

    @Override
    public String getColumnName(int column) {
        ColumnModel columnModel = (ColumnModel) clazz.cast(columnIdentifiers.get(column));
        return columnModel.getName();
    }

    /*==================================================================================================================
    PUBLIC METHODS
    ==================================================================================================================*/

    public void addColumnModels(ColumnModel columnModel, Model[] models) {
        addColumn(columnModel, models);
    }

    public void addColumnModelList(ColumnModel columnModel, List<Model> modelList) {
        addColumn(columnModel, new Vector<>(modelList));
    }

    public void addRowModels(Model[] rowModels) {
        addRow(rowModels);
    }

    public void addRowModelList(List<Model> rowModelList) {
        addRow(new Vector<>(rowModelList));
    }

    // Insert ==========================================================================================================

    public void insertRowModels(int position, Model[] models) {
        if (isValidRowPosition(position)) {
            insertRow(position, models);
        }
    }

    public void insertRowModelList(int position, List<Model> modelList) {
        if (isValidRowPosition(position)) {
            insertRow(position, new Vector<>(modelList));
        }
    }

    // Get =============================================================================================================

    public Model getModel(int row, int column) {
        return clazz.cast(getValueAt(row, column));
    }

    public List<List<Model>> getDataModelList() {
        return getWildCardDataVector().stream()
                .map(vector -> vector.stream()
                        .map(obj -> (Model)obj)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    // Set =============================================================================================================

    public void setModel(int row, int column, Model model) {
        setValueAt(model, row, column);
    }

    public void setDataModels(Model[][] dataModels, String[] columnNames) {
        setDataVector(dataModels, columnNames);
    }

    public void setDataModelList(List<List<Model>> dataModelList, List<String> columnNameList) {
        setDataVector(new Vector<>(dataModelList.stream()
                .map(Vector::new)
                .collect(Collectors.toList())), new Vector<>(columnNameList));
    }

    public void setColumnNames(String[] columnNames) {
        setColumnIdentifiers(columnNames);
    }

    public void setColumnModelList(List<String> columnNameList) {
        setColumnIdentifiers(new Vector<>(columnNameList));
    }

    // Delete ==========================================================================================================

    public void deleteRowModel(int position) {
        removeRow(position);
    }

    /*==================================================================================================================
    PRIVATE METHODS
    ==================================================================================================================*/

    @SuppressWarnings("rawtypes") // necessary :/
    private Vector<Vector<?>> getWildCardDataVector() {
        Vector<Vector> dataVector = getDataVector();
        Vector<Vector<?>> wildcardDataVector = new Vector<>();
        for (Vector<?> vector : dataVector) {
            wildcardDataVector.add(vector);
        }
        return wildcardDataVector;
    }

    private boolean isValidRowPosition(int position){
        return position >= 0 && position < getRowCount();
    }
}

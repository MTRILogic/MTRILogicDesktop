package com.mtrilogic.classes;

import com.mtrilogic.abstracts.ColumnModel;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.abstracts.TableItem;
import com.mtrilogic.adapters.TableAdapter;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class DefaultTable extends JTable {

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

    public DefaultTable() {
        super();
    }

    public DefaultTable(TableAdapter adapter) {
        super(adapter);
    }

    public DefaultTable(TableAdapter adapter, TableColumnModel columnModel) {
        super(adapter, columnModel);
    }

    public DefaultTable(TableAdapter adapter, TableColumnModel columnModel, ListSelectionModel selectionModel) {
        super(adapter, columnModel, selectionModel);
    }

    public DefaultTable(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    public DefaultTable(List<List<Model>> dataModelList, List<ColumnModel> columnModelList) {
        super(new Vector<>(dataModelList.stream()
                .map(Vector::new)
                .collect(Collectors.toList())), new Vector<>(columnModelList));
    }

    public DefaultTable(Model[][] dataModels, ColumnModel[] columnModels) {
        super(dataModels, columnModels);
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final  <M extends Model> M getCellModel(int row, int column, Class<M> clazz) {
        return clazz.cast(getValueAt(row, column));
    }

    public final TableAdapter getTableAdapter() {
        return (TableAdapter) getModel();
    }

    public final void setTableAdapter(TableAdapter adapter) {
        setModel(adapter);
    }

    public final <M extends Model> TableItem<M> getDefaultItem(Class<TableItem<M>> clazz) {
        return clazz.cast(getDefaultRenderer(String.class));
    }

    public final <M extends Model> void setDefaultItem(Class<?> clazz, TableItem<M> item) {
        setDefaultRenderer(clazz, item);
    }
}

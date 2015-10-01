/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.ame.util;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Marcus Becker
 */
public class ProjectObject implements Serializable {

    private String name;
    private Dimension grid;
    private GridValue defaultValue;
    private String[] initValues;

    private List<GridValue[][]> grids = Collections.emptyList();
    private List<GridValue> values = new ArrayList<>(20);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dimension getGrid() {
        return grid;
    }

    public void setGrid(Dimension grid) {
        this.grid = grid;
    }

    public GridValue getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(GridValue defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String[] getInitValues() {
        return initValues;
    }

    public void setInitValues(String[] initValues) {
        this.initValues = initValues;
    }

    public List<GridValue> getValues() {
        return values;
    }

    public void setValues(List<GridValue> values) {
        this.values = values;
    }

    public List<GridValue[][]> getGrids() {
        return grids;
    }

    public void setGrids(List<GridValue[][]> grids) {
        this.grids = grids;
    }

}

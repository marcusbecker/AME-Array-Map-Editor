/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.ame.util;

import java.awt.Color;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Marcus Becker
 */
public class GridValue implements Serializable{

    private int id;
    private String plain;
    private ImageIcon imageIcon;
    private Color color;

    private String tabName;

    public GridValue() {
    }

    public GridValue(int id, String plain, ImageIcon image) {
        this.id = id;
        this.plain = plain;
        this.imageIcon = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlain() {
        return plain;
    }

    public void setPlain(String plain) {
        this.plain = plain;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon image) {
        this.imageIcon = image;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    @Override
    public String toString() {
        return "GridValue{" + "id=" + id + ", plain=" + plain + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GridValue other = (GridValue) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public boolean isImage() {
        return getImageIcon() != null && getImageIcon().getImage() != null;
    }

    public Image getImage() {
        return getImageIcon().getImage();
    }

}

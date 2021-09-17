/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import model.Area;

/**
 *
 * @author cgpre
 */
public class AreaController {
    private Area area;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public AreaController() {
    }

    public AreaController(Area area) {
        this.area = area;
    }
    
    
}

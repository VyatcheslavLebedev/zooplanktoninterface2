package com.impfields3.zooplanktoninterface2;

import java.util.List;

public class GraphicsListNormalized {

    private List<Point> exList;
    private List<Point> sxlist;
    private List<Point> stList;
    private List<Point> gxList;

    public GraphicsListNormalized() {
    }

    public GraphicsListNormalized(List<Point> exList, List<Point> sxlist, List<Point> stList, List<Point> gxList) {
        this.exList = exList;
        this.sxlist = sxlist;
        this.stList = stList;
        this.gxList = gxList;
    }

    public List<Point> getExList() {
        return exList;
    }

    public void setExList(List<Point> exList) {
        this.exList = exList;
    }

    public List<Point> getSxlist() {
        return sxlist;
    }

    public void setSxlist(List<Point> sxlist) {
        this.sxlist = sxlist;
    }

    public List<Point> getStList() {
        return stList;
    }

    public void setStList(List<Point> stList) {
        this.stList = stList;
    }

    public List<Point> getGxList() {
        return gxList;
    }

    public void setGxList(List<Point> gxList) {
        this.gxList = gxList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impfields3.zooplanktoninterface2;


import org.nfunk.jep.JEP;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author impfi
 */
public class Parser {

    private static final double XMIN = -90.0;
    private static final double XMAX = 0;
    private static final double TMAX = 1;
    private static final double TMIN = 0;

    public GraphicsList parseFunctions(String ex,String sx,String st, String gx){
        JEP parser = new JEP();
        parser.addStandardFunctions();
        parser.addStandardConstants();

        GraphicsList gl = new GraphicsList();
        List<Point> exList = new ArrayList<>();
        List<Point> sxList = new ArrayList<>();
        List<Point> gxList = new ArrayList<>();

        double x = XMIN;
        double stepForX = (XMAX-XMIN)/249;

        for (int i = 0; i < 100; i++){
            parser.addVariable("x",x);
            parser.parseExpression(ex);
            exList.add(new Point(x,parser.getValue()));
            parser.parseExpression(sx);
            sxList.add(new Point(x,parser.getValue()));
            parser.parseExpression(gx);
            gxList.add(new Point(x,parser.getValue()));
            x = x + stepForX;
        }

        gl.setExList(exList);
        gl.setSxlist(sxList);
        gl.setGxList(gxList);

        List<Point> stList = new ArrayList<>();

        double t = TMIN;
        double stepForT = (TMAX -TMIN)/100;

        for(int i = 0;i < 100;i++){
            parser.addVariable("t",t);
            parser.parseExpression(st);
            stList.add(new Point(t,parser.getValue()));
            t = t +stepForT;
        }

        gl.setStList(stList);

        return gl;
    }
}

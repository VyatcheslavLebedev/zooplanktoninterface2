package com.impfields3.zooplanktoninterface2;

import java.util.ArrayList;
import java.util.List;

public class DataNormalizer {

    public  GraphicsListNormalized normalize(GraphicsList gl){
        GraphicsListNormalized gln = new GraphicsListNormalized();
        List<Point> exListN = new ArrayList<Point>();
        List<Point> sxListN = new ArrayList<Point>();
        List<Point> stListN = new ArrayList<Point>(gl.getStList());
        List<Point> gxListN = new ArrayList<Point>();
        for(int i = 0; i<100; i++){
           exListN.add(new Point(gl.getExList().get(i).getX(),gl.getExList().get(i).getY()/270.0));
           sxListN.add(new Point(gl.getSxlist().get(i).getX(),gl.getSxlist().get(i).getY()/270.0));
           gxListN.add(new Point(gl.getGxList().get(i).getX(),gl.getGxList().get(i).getY()/2025 + 1));
           stListN.add(new Point(gl.getStList().get(i).getX(),gl.getStList().get(i).getY()/2));
        }

        gln.setExList(exListN);
        gln.setSxlist(sxListN);
        gln.setStList(stListN);
        gln.setGxList(gxListN);

        return gln;
    }
}

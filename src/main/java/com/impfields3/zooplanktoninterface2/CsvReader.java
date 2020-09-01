/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impfields3.zooplanktoninterface2;

import au.com.bytecode.opencsv.CSVReader;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author impfi
 */
public class CsvReader {

    public GraphicsList read(String pathToFile, Double alpha,Double gamma,Double beta, Double sigma) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(pathToFile));
        GraphicsList gl = new GraphicsList();
        List<Point> exList = new ArrayList<>();
        List<Point> sxList = new ArrayList<>();
        List<Point> gxList = new ArrayList<>();
        List<Point> stList = new ArrayList<>();
        int count = 0;
        String line= "";
        while((line = br.readLine()) != null){
            String[] csvline = line.split(",");
            if (count == 0){
               exList.add(new Point(0,Double.parseDouble(csvline[0])));
               sxList.add(new Point(0,Double.parseDouble(csvline[1])));
               stList.add(new Point(0,Double.parseDouble(csvline[2])));
               gxList.add(new Point(0,Double.parseDouble(csvline[3])));
               alpha = Double.parseDouble(csvline[4]);
               gamma = Double.parseDouble(csvline[5]);
               beta = Double.parseDouble(csvline[6]);
               sigma = Double.parseDouble(csvline[7]);
            }
            else{
                exList.add(new Point(0,Double.parseDouble(csvline[0])));
                sxList.add(new Point(0,Double.parseDouble(csvline[1])));
                stList.add(new Point(0,Double.parseDouble(csvline[2])));
                gxList.add(new Point(0,Double.parseDouble(csvline[3])));
            }
            count++;
        }

        gl.setExList(exList);
        gl.setSxlist(sxList);
        gl.setStList(stList);
        gl.setGxList(gxList);

        return gl;

    }
    
}

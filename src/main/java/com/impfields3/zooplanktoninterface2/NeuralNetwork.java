package com.impfields3.zooplanktoninterface2;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.common.io.ClassPathResource;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.factory.Nd4j;

import java.io.File;
import java.io.IOException;

public class NeuralNetwork {

   public String predict(GraphicsListNormalized gln,double alpha,double gamma,double beta, double sigma) throws IOException {

       File net = new File("mynet.zip");
       MultiLayerNetwork model;
       model = MultiLayerNetwork.load(net,true);
       alpha = (alpha-1)/49;
       gamma = (gamma-1)/(50-1);
       beta = (beta- 0.01)/(0.1-0.01);
       sigma = (sigma - 0.01)/(0.1-0.01);
       double [] array = new double[404];
       for (int i = 0; i<100; i++){
           array[i] = gln.getExList().get(i).getY();
       }

       for (int i = 100; i < 200; i++){
           array[i] = gln.getSxlist().get(i - 100).getY();
       }

       for (int i = 200; i < 300; i++){
           array[i] = gln.getStList().get(i-200).getY();
       }

       for (int i = 300; i<400; i++){
           array[i] = gln.getGxList().get(i - 300).getY();
       }

       array[400] = alpha;
       array[401] = beta;
       array[402] = sigma;
       array[403] = gamma;

       int[] shape = {1,404};
       INDArray indArray = Nd4j.create(array,shape);

       //INDArray output = model.output(indArray);
        int[] res = model.predict(indArray);
        if (res[0] == 1) {
            return "Колебания есть";
        }
        else {
            return "Колебаний нет";
        }

   }


}

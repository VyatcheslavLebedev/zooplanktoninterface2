package com.impfields3.zooplanktoninterface2;

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
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
       double [] array = new double[1000];
       for (int i = 0; i<249; i++){
           array[i] = gln.getExList().get(i).getY();
       }

       for (int i = 249; i<498; i++){
           array[i] = gln.getSxlist().get(i - 249).getY();
       }

       for (int i = 498; i< 747; i++){
           array[i] = gln.getStList().get(i-498).getY();
       }

       for (int i = 747; i<996; i++){
           array[i] = gln.getGxList().get(i - 747).getY();
       }

       array[996] = alpha;
       array[997] = beta;
       array[998] = sigma;
       array[999] = gamma;

       int[] shape = {1,1000};
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

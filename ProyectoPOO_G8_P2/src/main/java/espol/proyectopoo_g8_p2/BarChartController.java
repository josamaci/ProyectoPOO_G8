/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Visitante;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class BarChartController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    private List<Visitante> visitantes = Visitante.cargarVisitante();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Visitantes");
        
        int visita0 = 0;
        int visita1 = 0;
        int visita2 = 0;
        int visita3 = 0;
        int visita4 = 0;
        int visita5 = 0;
        int visita6 = 0;
        int visita7 = 0;
        int visita8 = 0;
        int visita9 = 0;
        int visita10 = 0;
        int visita11 = 0;
        int visita12 = 0;
        int visita13 = 0;
        int visita14 = 0;
        int visita15 = 0;
        int visita16 = 0;
        int visita17 = 0;
        int visita18 = 0;
        int visita19= 0;
        int visita20 = 0;
        int visita21 = 0;
        int visita22 = 0;
        int visita23 = 0;
        
        for(Visitante v:visitantes){
            switch(v.getFechaIngreso().getHour()){
                case 0 :
                    visita0 += 1;
                case 1 :
                    visita1 += 1;
                case 2 :
                    visita2 += 1;
                case 3 :
                    visita3 += 1;
                case 4 :
                    visita4 += 1;
                case 5 : 
                    visita5 += 1;
                case 6 :
                    visita6 += 1;
                case 7 : 
                    visita7 += 1;
                case 8 :
                    visita8 += 1;
                case 9 : 
                    visita9 += 1;
                case 10 : 
                    visita10 += 1;
                case 11 : 
                    visita11 += 1;
                case 12 :
                    visita12 += 1;
                case 13 :
                    visita13 += 1;
                case 14 :
                    visita14 += 1;
                case 15 : 
                    visita15 += 1;
                case 16 :
                    visita16 += 1;
                case 17 : 
                    visita17 += 1;
                case 18 :
                    visita18 += 1;
                case 19 : 
                    visita19 += 1;
                case 20 : 
                    visita20 += 1;
                case 21 : 
                    visita21 += 1;
                case 22 :
                    visita22 += 1;
                case 23 :
                    visita23 += 1;
                
            } 
        }
        series1.getData().add(new XYChart.Data("0", visita0));
        series1.getData().add(new XYChart.Data("1", visita1));
        series1.getData().add(new XYChart.Data("2", visita2));
        series1.getData().add(new XYChart.Data("3", visita3));
        series1.getData().add(new XYChart.Data("4", visita4));
        series1.getData().add(new XYChart.Data("5", visita5));
        series1.getData().add(new XYChart.Data("6", visita6));
        series1.getData().add(new XYChart.Data("7", visita7));
        series1.getData().add(new XYChart.Data("8", visita8));
        series1.getData().add(new XYChart.Data("9", visita9));
        series1.getData().add(new XYChart.Data("10", visita10));
        series1.getData().add(new XYChart.Data("11", visita11));
        series1.getData().add(new XYChart.Data("12", visita12));
        series1.getData().add(new XYChart.Data("13", visita13));
        series1.getData().add(new XYChart.Data("14", visita14));
        series1.getData().add(new XYChart.Data("15", visita15));
        series1.getData().add(new XYChart.Data("16", visita16));
        series1.getData().add(new XYChart.Data("17", visita17));
        series1.getData().add(new XYChart.Data("18", visita18));
        series1.getData().add(new XYChart.Data("19", visita19));
        series1.getData().add(new XYChart.Data("20", visita20));
        series1.getData().add(new XYChart.Data("21", visita21));
        series1.getData().add(new XYChart.Data("22", visita22));
        series1.getData().add(new XYChart.Data("23", visita23));
        
        
        
        
        barChart.getData().addAll(series1);
        
        
        
    }    
    
}

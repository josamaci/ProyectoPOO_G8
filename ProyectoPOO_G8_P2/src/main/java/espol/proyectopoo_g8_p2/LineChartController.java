package espol.proyectopoo_g8_p2;

import espol.proyectopoo_g8_p2.backend.Visitante;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class LineChartController implements Initializable {

    @FXML
    private LineChart<?, ?> lineChart;
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
        XYChart.Series series = new XYChart.Series();
        
        for(Visitante v:visitantes){
            switch(v.getFechaIngreso().getHour()){
                case 0 :
                    
                case 1 : 
                case 2 :
                case 3 :
                case 4 :
                case 5 : 
                case 6 :
                case 7 : 
                case 8 :
                case 9 : 
                case 10 : 
                case 11 : 
                case 12 :
                case 13 :
                case 14 :
                case 15 : 
                case 16 :
                case 17 : 
                case 18 :
                case 19 : 
                case 20 : 
                case 21 : 
                case 22 :
                case 23 :
                
            }
        }
        
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        series.getData().add(new XYChart.Data(13, 23));
        series.getData().add(new XYChart.Data(14, 14));
        series.getData().add(new XYChart.Data(15, 15));
        series.getData().add(new XYChart.Data(16, 24));
        series.getData().add(new XYChart.Data(17, 34));
        series.getData().add(new XYChart.Data(18, 36));
        series.getData().add(new XYChart.Data(19, 22));
        series.getData().add(new XYChart.Data(20, 45));
        series.getData().add(new XYChart.Data(21, 43));
        series.getData().add(new XYChart.Data(22, 17));
        series.getData().add(new XYChart.Data(23, 29));
        series.getData().add(new XYChart.Data(24, 25));
        
        lineChart.getData().addAll(series);
        
    }    
    
}

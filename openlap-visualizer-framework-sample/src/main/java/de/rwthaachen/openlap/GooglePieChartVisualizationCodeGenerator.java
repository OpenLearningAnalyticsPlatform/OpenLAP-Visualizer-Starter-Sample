package de.rwthaachen.openlap;

import DataSet.OLAPColumnDataType;
import DataSet.OLAPDataColumnFactory;
import DataSet.OLAPDataSet;
import de.rwthaachen.openlap.visualizer.framework.VisualizationCodeGenerator;
import de.rwthaachen.openlap.visualizer.framework.model.TransformedData;
import exceptions.OLAPDataColumnException;

public class GooglePieChartVisualizationCodeGenerator extends VisualizationCodeGenerator {

    public GooglePieChartVisualizationCodeGenerator(){
    }

    @Override
    protected void initializeDataSetConfiguration() {
        this.setInput(new OLAPDataSet());
        this.setOutput(new OLAPDataSet());
        try {
            this.getInput().addOLAPDataColumn(
                    OLAPDataColumnFactory.createOLAPDataColumnOfType("xAxisStrings", OLAPColumnDataType.STRING, true)
            );
            this.getInput().addOLAPDataColumn(
                    OLAPDataColumnFactory.createOLAPDataColumnOfType("yAxisValues", OLAPColumnDataType.INTEGER, true)
            );
        } catch (OLAPDataColumnException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String visualizationCode(TransformedData<?> transformedData) {
        TransformedGooglePieChartData transformedGooglePieChartData = (TransformedGooglePieChartData)transformedData.getDataContent();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<div id=\"chart\" style=\"width: 900px; height: 500px;\"></div>");
        stringBuilder.append("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>" +
                "<script type=\"text/javascript\">");
        stringBuilder.append("google.charts.load('current', {'packages':['corechart']});" +
                "google.charts.setOnLoadCallback(drawChart);\n" +
                "function drawChart() {" +
                "var data = google.visualization.arrayToDataTable([");
        int count=0;
        for(String xValue : transformedGooglePieChartData.getLabels()) {
            if(count == transformedGooglePieChartData.getLabels().size())
                stringBuilder.append("['" + xValue + "','" + transformedGooglePieChartData.getFrequencies().get(count)+"']");
            else
                stringBuilder.append("['" + xValue + "','" + transformedGooglePieChartData.getFrequencies().get(count)+"'],");
            count++;
        }
        stringBuilder.append(" ]);"+
                "var options = {" +
                "title: 'Wiki Posts by Platform'" +
                "};" +
                "var chart = new google.visualization.PieChart(document.getElementById('chart'));" +
                "chart.draw(data, options);" +
                "}" +
                "</script>");
        return stringBuilder.toString();
    }
}

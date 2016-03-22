package de.rwthaachen.openlap;

import DataSet.OLAPColumnDataType;
import DataSet.OLAPDataSet;
import de.rwthaachen.openlap.visualizer.framework.DataTransformer;
import de.rwthaachen.openlap.visualizer.framework.model.TransformedData;

import java.util.ArrayList;

public class PieChartDataTransformer implements DataTransformer {

     public TransformedData<?> transformData(OLAPDataSet olapDataSet) {
        TransformedGooglePieChartData transformedGooglePieChartData = new TransformedGooglePieChartData();
        olapDataSet.getColumnsAsList(true).forEach(olapDataColumn -> {
            //in this Data transformer y axis contains only INTEGERS
            if (olapDataColumn.getConfigurationData().getType().equals(OLAPColumnDataType.INTEGER)) {
                ArrayList<String> frequencies = new ArrayList<>();
                for (Object data : olapDataColumn.getData()) {
                    frequencies.add(data.toString());
                }
                transformedGooglePieChartData.setFrequencies(frequencies);
            } else {
                transformedGooglePieChartData.setLabels(olapDataColumn.getData());
            }
        });
        TransformedData<TransformedGooglePieChartData> transformedData = new TransformedData<>();
        transformedData.setDataContent(transformedGooglePieChartData);
        return transformedData;
    }
}


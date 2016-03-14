package de.rwthaachen.openlap;

import DataSet.OLAPDataSet;
import de.rwthaachen.openlap.visualizer.framework.model.TransformedData;
import de.rwthaachen.openlap.visualizer.framework.DataTransformer;

public class DataTransformerSample implements DataTransformer {

    public TransformedData<?> transformData(OLAPDataSet olapDataSet) {
        return new TransformedData();
    }
}

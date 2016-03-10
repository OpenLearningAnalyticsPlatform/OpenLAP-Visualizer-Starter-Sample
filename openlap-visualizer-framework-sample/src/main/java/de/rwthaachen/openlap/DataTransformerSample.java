package de.rwthaachen.openlap;

import DataSet.OLAPDataSet;
import de.rwthaachen.openlap.visualizer.framework.model.TransformedData;
import de.rwthaachen.openlap.visualizer.framework.DataTransformer;

/**
* This class servces as an example of a DataTransformer. The transformData function should process the provided
* OLAPDataSet and return a TransformedData<?> object which can be used by the visualization code
*/
public class DataTransformerSample implements DataTransformer {

    public TransformedData<?> transformData(OLAPDataSet olapDataSet) {
        return new TransformedData();
    }
}

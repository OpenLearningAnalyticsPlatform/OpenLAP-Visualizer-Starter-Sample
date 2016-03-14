package de.rwthaachen.openlap;

import DataSet.OLAPDataSet;
import de.rwthaachen.openlap.visualizer.framework.model.TransformedData;
import de.rwthaachen.openlap.visualizer.framework.VisualizationCodeGenerator;

public class VisualizationCodeGeneratorSample extends VisualizationCodeGenerator {

    @Override
    protected void initializeDataSetConfiguration() {
        this.setInput(new OLAPDataSet());
        this.setOutput(new OLAPDataSet());        
    }

    @Override
    protected String visualizationCode(TransformedData<?> transformedData) {
        return "";
    }
}
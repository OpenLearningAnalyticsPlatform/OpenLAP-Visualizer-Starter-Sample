package de.rwthaachen.openlap;

import DataSet.OLAPDataSet;
import de.rwthaachen.openlap.visualizer.framework.model.TransformedData;
import de.rwthaachen.openlap.visualizer.framework.VisualizationCodeGenerator;

/**
* A sample class which serves as an example of a VisualizationCodeGenerator. 
*
* The initializeDataSetConfiguration method should contain the input OLAPDataSet configuration (the actual data is not required). 
* The client (AnalyticsEngine) will use this input configuration to verify if the VisualizationCodeGenerator can accept the 
* OLAPDataSet it wants to send. If and only if the input configuration matches that what the client (AnalyticsEngine) wants to 
* send the actual data will be sent. The output OLAPDataSet configuration for a Visualization Method (VisualizationCodeGenerator) is 
* not important.
*
* The visualizationCode method should return the actual visualization code as a String to be sent back to the client by making
* use of the provided TransformedData<?>.
*/
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
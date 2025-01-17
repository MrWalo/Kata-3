package software.ulpgc.kata3.apps.windows;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.architecture.model.Barchart;

public class JFreeBarchartAdapter {

    public static JFreeChart adapt(Barchart barchart){
        JFreeChart chart = ChartFactory.createBarChart(
                barchart.title(),
                barchart.xAxis(),
                barchart.yAxis(),
                datasetOf(barchart));

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(-3);
        renderer.setMaximumBarWidth(0.2);
        return chart;
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String category : barchart.keySet()) {
            dataset.addValue(barchart.get(category),category,category );
        }
        return dataset;
    }
}

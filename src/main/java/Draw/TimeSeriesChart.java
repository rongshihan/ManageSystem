package Draw;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import basic.Count;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class TimeSeriesChart {
    int pie_count = 0;
    public JFreeChart TimeSeriesChart(DefaultPieDataset dataset){
        //dataset = createDataset();
        JFreeChart chart = ChartFactory.createPieChart(
                "浏览量统计",
                 dataset,
                true,
                false,
                false);
        //设置百分比
        PiePlot pieplot = (PiePlot) chart.getPlot();
        DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象，主要是设置小数问题
        NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象
        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
        pieplot.setLabelGenerator(sp1);//设置饼图显示百分比

        //没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);

        pieplot.setIgnoreNullValues(true);//设置不显示空值
        pieplot.setIgnoreZeroValues(true);//设置不显示负值

        chart.getTitle().setFont(new Font("宋体",Font.TYPE1_FONT,20));//设置标题字体
        PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象
        piePlot.setLabelFont(new Font("宋体",Font.TYPE1_FONT,15));//解决乱码
        chart.getLegend().setItemFont(new Font("黑体",Font.TYPE1_FONT,15));

        //片区颜色
        for (int i = 0;i<pie_count;i++) {
            pieplot.setSectionPaint(i, new Color(i*10+100, i*10+110, i*10+120));
        }
        //片区外廓
        pieplot.setSectionOutlinesVisible(false);//可见性
        //取出片区
        for (int i = 0;i<pie_count;i++) {
            pieplot.setExplodePercent(i, 0.02);
        }

        pieplot.setLabelGap(0.01);

        pieplot.setInteriorGap(0.05D);

        pieplot.setLegendItemShape(new
                Rectangle(10, 10));// 图例形状

        pieplot.setIgnoreNullValues(true);

        pieplot.setLabelBackgroundPaint(null);// 去掉标签背景色

        pieplot.setLabelShadowPaint(null);// 去掉标签阴影

        pieplot.setLabelOutlinePaint(null);// 去掉标签边框

        pieplot.setShadowPaint(null);//去掉阴影

        piePlot.setOutlinePaint(null);

        piePlot.setBackgroundPaint(Color.white);
        // 0:category 1:value:2 :percentage

        pieplot.setLabelGenerator(new
                StandardPieSectionLabelGenerator("{0}:{2}"));// 显示标签数据
        //没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);

        pieplot.setIgnoreNullValues(true);//设置不显示空值
        pieplot.setIgnoreZeroValues(true);//设置不显示负值

        return chart;
    }
    public DefaultPieDataset createDataset(List<Count> counts) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Iterator iterator = counts.iterator();
        while (iterator.hasNext()) {
            pie_count++;
            Count count = (Count) iterator.next();
            dataset.setValue(count.getBrandmodel(),count.getCount());
        }
        return dataset;
    }
}

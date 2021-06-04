package Draw;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import basic.Count;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class BarChart {
    public JFreeChart BarChart(CategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart3D(
                "浏览量统计", // 图表标题
                "车名", // 目录轴的显示标签
                "浏览量", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,           // 是否显示图例(对于简单的柱状图必须是false)
                false,          // 是否生成工具
                false           // 是否生成URL链接
        );

        //从这里开始
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
        CategoryAxis domainAxis=plot.getDomainAxis();//水平底部列表
        domainAxis.setLabelFont(new Font("黑体",Font.TYPE1_FONT,12));         //水平底部标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.TYPE1_FONT,12));  //垂直标题
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
        rangeAxis.setLabelFont(new Font("黑体",Font.TYPE1_FONT,12));
        chart.getLegend().setItemFont(new Font("黑体", Font.TYPE1_FONT, 12));
        chart.getTitle().setFont(new Font("宋体",Font.TYPE1_FONT,20));//设置标题字体

        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.gray);
        renderer.setSeriesPaint(1, Color.orange);
        renderer.setDrawBarOutline(false);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT));
        renderer.setItemLabelAnchorOffset(10);

        //设置距离图片左端距离
        domainAxis.setUpperMargin(0.2);
        //设置距离图片右端距离
        domainAxis.setLowerMargin(0.2);
        //数据轴精度
        NumberAxis na = (NumberAxis) plot.getRangeAxis();
        na.setAutoRangeIncludesZero(true);
        DecimalFormat df = new DecimalFormat("#0.000");
        //数据轴数据标签的显示格式
        na.setNumberFormatOverride(df);
        //设置柱的透明度
        plot.setForegroundAlpha(1.0f);
        //设置横轴倾斜
        CategoryAxis categoryaxis = plot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(Math.PI / 6));

        //设置图像区域背景色
        plot.setBackgroundPaint(Color.white);
        //水平轴网格线颜色
        plot.setRangeGridlinePaint(Color.lightGray);

        return chart;
    }
    public CategoryDataset setDataSet(List<Count> counts) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(counts==null||counts.size()==0){
            dataset.addValue(0, "空", "空");
            return dataset;
        }
        else {
            Iterator iterator = counts.iterator();
            while (iterator.hasNext()) {
                Count count = (Count) iterator.next();
                dataset.addValue(count.getCount(), count.getShopuser_id(), count.getBrandmodel());
            }
            return dataset;
        }
    }
}
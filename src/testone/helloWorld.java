package testone;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class helloWorld {
    /**
     * 初始化未来三天的销量
     */
    public static Map<Date, Double> initSalesPlanMap() {
        Map<Date, Double> salesPlanMap = new HashMap<>();
        long now = System.currentTimeMillis() / 1000l;
        long daySecond = 60 * 60 * 24;
        long dayTime = now - (now + 8 * 3600) % daySecond;
//今天的销量计划-10
        salesPlanMap.put(initDateByDay(0), 10.00);
//明天的销量计划-20
        salesPlanMap.put(initDateByDay(1), 20.00);
//后台的销量计划-30
        salesPlanMap.put(initDateByDay(2), 30.00);
        return salesPlanMap;
    }
    /**
     * 根据offset获取对应天的数据
     */
    public static double getSalesPlan(int offset) {
        Map<Date, Double> dateDoubleMap = initSalesPlanMap();
        Date date = initDateByDay(offset);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        date = calendar.getTime();
        Double result = dateDoubleMap.get(date);
        return result;
    }
    /**
     * 获得当天零时零分零秒
     *
     * @return
     */
    public static Date initDateByDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }
    public static void main(String[] args) {
//输出明天的销量计划,预期结果=20
        System.out.println(getSalesPlan(0));
    }
}

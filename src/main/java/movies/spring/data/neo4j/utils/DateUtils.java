package movies.spring.data.neo4j.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Create on 2018/7/31 11:02
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class DateUtils {

    private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean isFormatLedge(String dateStr) {
        try {
            Calendar.getInstance().setTime(format.parse(dateStr));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Long getDateLong(String dateStr) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(format.parse(dateStr));
            return cal.getTimeInMillis();
        } catch (Exception e) {
            return 0L;
        }
    }
}

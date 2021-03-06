package org.csf.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Andrew Boytsov
 * @date 06.04.2018
 */

public final class DateUtils {

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

}

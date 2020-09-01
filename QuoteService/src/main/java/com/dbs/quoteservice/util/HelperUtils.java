package com.dbs.quoteservice.util;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;

/**
 * @author pvishnoi
 *
 */
public class HelperUtils {

	public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

	public static final Comparator<Map.Entry<String, Long>> SORT_BY_VALUE = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
	
	public static final Comparator<Map.Entry<String, Long>> SORT_BY_KEY = Comparator.comparing(Map.Entry::getKey);
}

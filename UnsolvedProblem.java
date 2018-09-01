package com.ninatest.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnsolvedProblem {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm");
		int resultMinutes = 0;
		String meetingString = "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nFri 05:00-10:00\nSat 01:00-23:00\nSun 01:00-21:00\n";

		String everyMeeting[] = meetingString.split("\\r?\\n");
		Map<String, List<String>> dayMap = new HashMap<String, List<String>>();

		String[] weeks = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun" };
		for (String week : weeks) {
			dayMap.put(week, new ArrayList<String>());
		}

		for (int i = 0; i < everyMeeting.length; i++) {
			System.out.println(everyMeeting[i] + " - Ddd: " + everyMeeting[i].split(" ")[0] + ", times: "
					+ everyMeeting[i].split(" ")[1]);

			dayMap.get(everyMeeting[i].split(" ")[0]).add(everyMeeting[i].split(" ")[1]);
		}

		for (Object key : dayMap.keySet()) {
			try {
				List<Date> oneDayTime = new ArrayList<Date>();
				Date oneDayStart = format.parse("00:00");
				Date oneDayEnd = format.parse("23:59");
				oneDayTime.add(oneDayStart);
				
				for (int i = 0; i < dayMap.get(key).size(); i++) {
					String start = (everyMeeting[i].split(" ")[1]).split("-")[0];
					String end = (everyMeeting[i].split(" ")[1]).split("-")[1];

					oneDayTime.add(format.parse(start));
					oneDayTime.add(format.parse(end));

				}
				
				oneDayTime.add(oneDayEnd);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(dayMap.toString());

	}

}

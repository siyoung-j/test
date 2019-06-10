package com.zero.zeta.plugin;

import java.util.Calendar;

public class Zenkins {
	
	public static void main(String[] args) {
		
		System.out.println("젠킨스 연동 완료");
		
		Calendar c = Calendar.getInstance();

		String nowTime = String.format("%d-%02d-%02d %02d:%02d:%02d"
										, c.get(Calendar.YEAR)
										, c.get(Calendar.MONTH) + 1
										, c.get(Calendar.DAY_OF_MONTH)
										, c.get(Calendar.HOUR_OF_DAY)
										, c.get(Calendar.MINUTE)
										, c.get(Calendar.SECOND));
		
		System.out.println("현재 시각 : " + nowTime);
		
	}

}

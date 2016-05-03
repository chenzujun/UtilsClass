package com.common.utils;

public enum EnumTest {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6) {
        @Override
        public boolean isRest() {
            return true;
        }
    },
    SUN(0) {
        @Override
        public  String[] getAlertPhones() {
			return new String[]{"18101610431","13925198907"};
		}
    };
 
    private int value;
 
    private EnumTest(int value) {
        this.value = value;
    }
 
    public int getValue() {
        return value;
    }
 
    public boolean isRest() {
        return false;
    }
    
    public  String[] getAlertPhones() {
		return new String[]{"14025190000","14125190000"};
	}
}
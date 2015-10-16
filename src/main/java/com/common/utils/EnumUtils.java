package com.common.utils;

public interface EnumUtils {

	public enum Numeric {
		ZERO("零", 0),ONE("一", 1),TWO("二", 2), THREE("三", 3),
		FOUR("四", 4),FIVE("五", 5),SIX("六", 6),SEVEN("七", 7),
		EIGHT("八", 8),NINE("九", 9),TEN("十", 10);
        
        private String name;
        private int index;

        private Numeric(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public static String getName(int index) {
            for (Numeric c : Numeric.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }
        
        public static int getValue(String name) {
            for (Numeric c : Numeric.values()) {
                if (c.getName().equals(name)) {
                    return c.index;
                }
            }
            return 0;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}

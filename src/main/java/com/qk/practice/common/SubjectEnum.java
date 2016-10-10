package com.qk.practice.common;

public enum SubjectEnum {
	
	IOS("IOS"), 
	C_PLUS("C++"),
	C("C"),
	ANDROID("Android"),
	JAVA("Java"),
	TBD("TBD");
	
    private String name;

    private SubjectEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

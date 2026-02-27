package com.capgemini.springbootbasic;

import java.util.*;

public class University {
	public String name ; 
	public String loc ; 
	public List<Student> list ;
	@Override
	public String toString() {
		return "University [name=" + name + ", loc=" + loc + ", list=" + list + "]";
	}
}

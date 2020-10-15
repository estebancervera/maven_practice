package com.cerverae.calidad.dobles;

public class Dependency {

	private final SubDependency subDependency;
	
	public Dependency(SubDependency subDependency) {
		super();
		this.subDependency = subDependency;
	}

	
	public String getClassName() {
		return this.getClass().getSimpleName();
	}
	
	public String getSubDependencyClassName() {
		return subDependency.getClassName();
	}
	
	public int addTwo(int i) {
		return i + 2;
	}
	
	public int multiply(int i , int j) {
		return 0;
	}
	
	public String getClassNameUpperCase() {
		return getClassName().toUpperCase();
	}
}

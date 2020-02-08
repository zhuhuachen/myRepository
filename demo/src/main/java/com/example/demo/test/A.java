package com.example.demo.test;

import java.io.File;

public class A {
public static void main(String[] args) {

	String path2 = Thread.currentThread().getContextClassLoader ().getResource("").getPath();
	File f=new File(path2+"../../chromedriver.exe");
	System.err.println(f.getPath());
	}
}

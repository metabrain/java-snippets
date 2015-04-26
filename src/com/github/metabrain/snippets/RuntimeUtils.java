package com.github.metabrain.snippets;

public class RuntimeUtils {

	public static void sleep(int TIMEOUT) {
		try {
			Thread.sleep(TIMEOUT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

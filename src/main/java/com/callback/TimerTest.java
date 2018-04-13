package com.callback;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {
	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(10000, listener);
		t.start();
		
		JOptionPane.showConfirmDialog(null, "Quit program?");
		System.exit(0);
	}
}

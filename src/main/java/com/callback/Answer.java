package com.callback;

public class Answer {

	public void answerTheQuestion(CallBack callBack, String question){
		System.out.println("问题是："+question);
		
		for (int i = 0; i < 1000; i++) {
			// do something
		}
		
		String answer = "3";
		
		callBack.solve(answer);
	}
}

package com.callback;

public class Request implements CallBack {

	private Answer anwser;
	
	public Request(Answer anwser){
		this.anwser=anwser;
	}
	
	public void askQuestion(final String question){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				anwser.answerTheQuestion(Request.this, question);
			}
		}).start();
		
		this.play();
	}
	
	public void play(){
		System.out.println("问完了轻松了额");
	}
	
	@Override
	public void solve(String result) {
		System.out.println("被问者的答案是："+result);
	}

}

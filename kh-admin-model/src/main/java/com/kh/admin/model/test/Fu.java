package com.kh.admin.model.test;

class Fu extends Object{
	public String name = "爸爸";
	public void say(){
       		System.out.println("我来自20世纪");
       	}

	public void talk(){
		System.out.println("我是爸爸");
	}
}

class Zi  extends Fu {
	public String name = "儿子";

	@Override
	public void say() {
       		System.out.println("我来自21世纪");
        	}

    public void add(){
		super.say();
		super.talk();
        System.out.println("add");
    }
}

class Test01 {

    public static void main(String[] args) {

		Zi zi = new Zi();

		Fu f = new Zi();

		f.say();
		f.talk();

		((Zi)f).add();


	}
}

package br.com.test;

import br.com.wsrest.lista.ResourceFileList;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceFileList  list=new ResourceFileList();
		for(String key: list.getList().keySet()){
			System.out.println(key);
		}
	}

}

package br.com.wsrest.lista;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceFileList {
	public Map<String, String> listResource = new HashMap<String, String>();
	private final static String CAMINHO_PASTA = "C:/Users/RodrigoTenorio/pastadeTeste";
	private File file;
	
	
	public ResourceFileList() {
		this.file = new File(CAMINHO_PASTA);
		criarListFile();
	}

	private void criarListFile() {
		for (File f : file.listFiles()) {
			if (f.isFile()) {
				addFile(f.getName()) ;
			}
		}
	}

	public void addFile(String fileName) {
		this.listResource.put(fileName, CAMINHO_PASTA+fileName);
	}

	public String getFile(String fileName) {
		return this.listResource.get(fileName);
	}

	public void deleteFile(String fileName) {
		this.listResource.remove(fileName);
	}
	
	public Map<String, String> getList(){
		
		return this.listResource;
	}
	
}

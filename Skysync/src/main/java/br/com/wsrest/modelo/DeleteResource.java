package br.com.wsrest.modelo;

import java.io.File;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/delete")
public class DeleteResource {
	private File file;
	private Response response;
	private final static String CAMINHO_PASTA = "C:/Users/RodrigoTenorio/";

	@POST
	@Path("/resourceDelete")
	public Response getParamento(@FormParam("fileName") String fileName) {
		return this.deleteFile(fileName);
	}

	@DELETE
	@Produces("text/html")
	public Response deleteFile(String uri) {
		String msg;
		uri = CAMINHO_PASTA + uri;
		this.file = new File(uri);
		if (this.file.delete())	msg = "Sucesso";
		else msg = "francasso";
		return response.status(200).entity("<html>"+"<head>"+msg+"</head>"+"</html>").build();
	}
}

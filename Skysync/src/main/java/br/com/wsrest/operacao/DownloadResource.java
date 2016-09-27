/**
 * @author RodrigoTenorio
 */
package br.com.wsrest.operacao;

import java.io.File;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class DownloadResource {
	private File file;
	private ResponseBuilder response;
	private final static String CAMINHO_PASTA = "C:/Users/RodrigoTenorio/";

	/**
	 * @Path = Caminho para acessar o método via http 
	 * @Produces("/*")=Determinamos o media types que vamos usar para receber a resposta
	 * @FormParam captura de HTML.
	 * @FormParam fileName
	 */
	@POST
	@Path("/resource")
	@Produces("*/*")
	public Response getParamento(@FormParam("fileName") String fileName) {
		fileName=CAMINHO_PASTA+fileName;
		return this.getResource(fileName);
	}

	/**
	 * DOWNLOAD de Arquivos. 
	 * @Produces("/*") =Determinamos o media types que vamos usar para receber a resposta
	 * @GET = Método HTTP
	 * @return
	 */
	@GET
	@Produces("*/*")
	public Response getResource(String uri) {
		this.file = new File(uri);
		this.response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment;filename=" + file.getName());
		return response.build();
	}
}

/**
 * @author RodrigoTenorio
 * data:12/08/2016
 */
package br.com.wsrest.operacao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/upload")
public class UploadResource {

	private final static String CAMINHO_PASTA = "C:/Users/RodrigoTenorio/pastadeTeste/";

	/**
	 * 
	 * @param lerArray=para ler o arry de byte do arq.
	 * @param fileDetail=obter o nome do arquivo ou cabeçalho detalhe 
	 * @return
	 */
	@POST
	@Path("/resource")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response postResource(@FormDataParam("file") InputStream lerArray,
			                     @FormDataParam("file") FormDataContentDisposition detalheArq) {

		String uploadArquivoCaminho = CAMINHO_PASTA + detalheArq.getFileName();

		
		salvarLocalArquivo(lerArray, uploadArquivoCaminho);

		String endereco = "Feito Upoload para : " + uploadArquivoCaminho;

		return Response.status(200).entity(endereco).build();

	}

	
	private void salvarLocalArquivo(InputStream uploadEntrada, String uploadArquivoCaminho) {

		try {
			OutputStream out = new FileOutputStream(new File(uploadArquivoCaminho));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadArquivoCaminho));
			while ((read = uploadEntrada.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}

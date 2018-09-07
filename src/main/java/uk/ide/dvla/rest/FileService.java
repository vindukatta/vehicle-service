package uk.ide.dvla.rest;

import uk.ide.dvla.json.JsonUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by indukatta on 06/09/2018.
 */

@Path("/getFiles")
public class FileService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(FileService.class);
	private static String folderPath = ".\\src\\main\\resources\\testfiles\\";

	/**
	 * Get method to return list of files in the json format
	 * @return JsonString filename : mimetype : size : file extension for each file
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListOfFiles() throws IOException {
		List<String> listOfFiles = new ArrayList<String>();
		final File folder = new File(folderPath);
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {

			} else {
				String fileAttr = fileEntry.getName() + " : " + Files.probeContentType(fileEntry.toPath()) + " : " + Long.toString(fileEntry.length()) + " : " + FilenameUtils.getExtension(fileEntry.getName());
				listOfFiles.add(fileAttr);
			}
		}
		LOGGER.info(String.valueOf(listOfFiles));
		return Response.ok(JsonUtils.toString(listOfFiles)).build();
	}


	/**
	 * Get method to return the exact file
	 * @param fileName
	 * @return excelFile
	 */
	@GET
	@Path("/file")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public StreamingOutput  getFile(@QueryParam("fileName") String fileName) throws IOException {

		File file = new File(folderPath + fileName);		    	
		LOGGER.info(String.valueOf(file.getName()));		        
		return new FileStreamingOutput(file);
	}


	/**
	 * Get method to return the excel file
	 * @param fileName
	 * @return excelFile
	 */
	@GET
	@Path("/getExcelFile")
	@Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public Response  getExcelFile(@QueryParam("fileName") String fileName) throws IOException {
		File file = new File(folderPath + fileName);	    	
		LOGGER.info(String.valueOf(file.getName()));
		return Response.ok().entity(new FileInputStream(file)).build();
	}
}



package uk.ide.dvla.rest;

import uk.ide.dvla.json.JsonUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
	    
	 /**
	  * Get method to return list of files in the json format
	  * returns filename : mimetype : size : file extension for each file
	  */
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getListOfFiles() throws IOException {
	    	List<String> listOfFiles = new ArrayList<String>();
	    	final File folder = new File(".\\src\\main\\resources\\testfiles");
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
		  * returns file
		  */
		    @GET
		    @Path("/file")
		    @Produces(MediaType.APPLICATION_JSON)
		    //public Response getFile(@QueryParam("fileName") String fileName) throws IOException {
		    public Response getFile() throws IOException {
		    	//List<String> listOfFiles = new ArrayList<String>();
		    	File file = new File(".\\src\\main\\resources\\testfiles\\VehicleExcel.xlsx");
		    	
		        LOGGER.info(String.valueOf(file.getName()));
		        return Response.ok().entity(new FileInputStream(file)).build();
		    }
}

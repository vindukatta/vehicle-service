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
		    @Produces(MediaType.APPLICATION_OCTET_STREAM)
		    //@Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
		    public StreamingOutput  getFile(@QueryParam("fileName") String fileName) throws IOException {
		    	File file = new File(".\\src\\main\\resources\\testfiles\\" + fileName);
		    	
		        LOGGER.info(String.valueOf(file.getName()));
		        //return Response.ok().entity(new FileInputStream(file)).build();
		        /*ResponseBuilder response = Response.ok((Object) file);
				response.header("Content-Disposition",
					"attachment; filename=\"VehicleExcel.xlsx\"");
				return response.build();*/
		        return new FileStreamingOutput(file);
		    }
		    
		    
		    /**
			  * Get method to return the exact file
			  * returns file
			  */
			    @GET
			    @Path("/getExcelFile")
			    @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
			    public Response  getExcelFile(@QueryParam("fileName") String fileName) throws IOException {
			    	File file = new File(".\\src\\main\\resources\\testfiles\\" + fileName);	    	
			        LOGGER.info(String.valueOf(file.getName()));
			        return Response.ok().entity(new FileInputStream(file)).build();
			    }
}



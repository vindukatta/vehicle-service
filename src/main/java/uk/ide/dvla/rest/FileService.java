package uk.ide.dvla.rest;

import uk.ide.dvla.json.JsonUtils;
import org.apache.commons.io.FilenameUtils;
import org.glassfish.jersey.server.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by indukatta on 06/09/2018.
 */

@Path("/getFiles")
public class FileService {
	
	 private static Logger LOGGER = LoggerFactory.getLogger(FileService.class);
	    
	 private static Map<String, FileDetails> files = new HashMap();
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
	    
	    @GET
	    @Path("/getFiles1")
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<FileDetails> getListOfFiles1() throws IOException {
	    	
	    	
	    	
	    	FileDetails file1 = new FileDetails();
	    	file1.setFileName("Test.txt");
	    	file1.setFileType("txt");
	    	
	    	FileDetails file2 = new FileDetails();
	    	file2.setFileName("Test2.txt");
	    	file2.setFileType("txt");
	    	
	    	//list.add(file1);
	    	//list.add(file2);
	    	
	    	 files.put("11", file1);
	    	 files.put("11", file2);
	    	 List<FileDetails> list = new ArrayList<FileDetails>(files.values());
	    	return list;        
	    }
	    /**
		  * Get method to return the exact file
		  * returns file
		  */
		    @GET
		    @Path("/file")
		    @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
		    //public Response getFile(@QueryParam("fileName") String fileName) throws IOException {
		    public StreamingOutput  getFile() throws IOException {
		    	//List<String> listOfFiles = new ArrayList<String>();
		    	File file = new File(".\\src\\main\\resources\\testfiles\\VehicleExcel.xlsx");
		    	
		        LOGGER.info(String.valueOf(file.getName()));
		        //return Response.ok().entity(new FileInputStream(file)).build();
		        /*ResponseBuilder response = Response.ok((Object) file);
				response.header("Content-Disposition",
					"attachment; filename=\"VehicleExcel.xlsx\"");
				return response.build();*/
		        return new FileStreamingOutput(file);
		    }
}



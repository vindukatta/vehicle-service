package uk.ide.dvla;

import static io.restassured.RestAssured.given;

import org.glassfish.jersey.client.ClientResponse;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Arrays;

/**
 * Created by indukatta on 06/09/2018.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileTest {

	  private static String testURI = "http://localhost:7003/getFiles";
	  
	  
	  /**
	   * RestAssured test file to test the GET method
	   */
	  
	  @Test
	    public void getFilesList(){
	        System.out.println("Test 1 : getFileDetails");
	        RestAssured.baseURI = testURI;
	       Response apiResponse = given().contentType("application/json").when().get().then().contentType(ContentType.JSON).extract().response();
	       // Response apiResponse = given().when().get();
	        int responseStatus = apiResponse.statusCode();
	        Assert.assertEquals(200,responseStatus);
	        System.out.println("File details : " + apiResponse.asString());
	        System.out.println("File details : " + apiResponse.statusCode());
	        
//	        Client client = ClientBuilder.newBuilder().build();
//	        WebTarget target = client.target("http://localhost:7003/getFiles/file");
//	        javax.ws.rs.core.Response response = target.path("C:\\Users\\Indu Katta\\git\\Vehi.xslx").request().get();
//	   System.out.println(response.getLength());
	  
	       
	        System.out.println("Test Completed");
	    }
	  
	  @Test
	    public void getFileDetails(){
	        System.out.println("Test 1 : getFileDetails");
	        RestAssured.baseURI = testURI;
	      // Response apiResponse = given().contentType("application/json").when().get();
	       // Response apiResponse = given().when().get();
	       // int responseStatus = apiResponse.statusCode();
	       // Assert.assertEquals(200,responseStatus);
	       // System.out.println("File details : " + apiResponse.asString());
	       // System.out.println("File details : " + apiResponse.statusCode());
	        
//	        Client client = ClientBuilder.newBuilder().build();
//	        WebTarget target = client.target("http://localhost:7003/getFiles/file");
//	        javax.ws.rs.core.Response response = target.path("C:\\Users\\Indu Katta\\git\\Vehi.xslx").request().get();
//	   System.out.println(response.getLength());
	  
	       
	        System.out.println("Test Completed");
	    }
	  
	
}

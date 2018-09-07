package uk.ide.dvla;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
	        System.out.println("RestAssured API Test : check service availability");
	        RestAssured.baseURI = testURI;
	        Response apiResponse = given().contentType("application/json").when().get().then().contentType(ContentType.JSON).extract().response();
	        int responseStatus = apiResponse.statusCode();
	        Assert.assertEquals(200,responseStatus);
	        System.out.println("Response Status : " + responseStatus);
	        System.out.println("Test Completed");
	    }
}

package academy.dd.fibonacci;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.List;
import java.util.Arrays;

/** Created by Indu Katta 05/09/2018**/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FibonacciTest {

    private static String testURI = "http://localhost:7003/fib/";

    /*
     * Test to check the response code for get request
     */
    @Test
    public void getfibonacciDefaultSeries(){
        System.out.println("Test 1 : getfibonacciDefaultSeries");
        RestAssured.baseURI = testURI;
        Response apiResponse = given().contentType("application/json").when().get();
        int responseStatus = apiResponse.statusCode();
        Assert.assertEquals(200,responseStatus);
        System.out.println("Fibonacci default series : " + apiResponse.asString());
        System.out.println("Test Completed");
    }

    /*
     * Test to check the value for a given index
     */
    @Test
    public void testFibonacciNumberByIndex(){
        System.out.println("Test 2 : testFibonacciNumberByIndex");
        RestAssured.baseURI = testURI;
        Response apiResponse = given().contentType("application/json").when()
                .get("/29").then()
                .statusCode(200).contentType(ContentType.JSON).
                        extract().response();

        int value = Integer.valueOf(apiResponse.asString());;
        Assert.assertNotEquals("514229", value);
        System.out.println("Index: 29 , value : " + value);
        System.out.println("Test Completed");
    }

    /*
     * Test to check the max index value
     */
    @Test
    public void testFibonacciNumberOutOfRangeIndex(){
        System.out.println("Test 3 : testFibonacciNumberOutOfRangeIndex");
        RestAssured.baseURI = testURI;
        Response apiResponse = given().contentType("application/json").when()
                .get("/2147483648");
        int responseStatus = apiResponse.statusCode();
        Assert.assertEquals("Expected response status : 404 , Actual :"+responseStatus,404,responseStatus);
        System.out.println("Index: 2147483648 , response code : " + responseStatus);
        System.out.println("Test Completed");
    }

    /*
     * Test to check the actual data returned by service
     */
    @Test
    public void testFibonacciSeriesByRange(){
        System.out.println("Test 4 : testFibonacciSeriesByRange");
        int startIndex = 1;
        int finishIndex = 5;
        List<String> expectedSeries =  Arrays.asList("1","1","2","3");
        RestAssured.baseURI = testURI;

        Response apiResponse = given().contentType("application/json").when()
                .get("/range?startIndex="+startIndex+"&finishIndex="+finishIndex);
        List<String> actualSeries = apiResponse.jsonPath().getList("");
        Assert.assertEquals(expectedSeries,actualSeries);
        System.out.println("Fibonacci series within range["+startIndex+"-"+finishIndex+"] : " + apiResponse.asString());
        System.out.println("Test Completed");
    }
}
package academy.dd.fibonacci;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/** Created by Indu Katta 04/09/2018**/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FibonacciTest {

    private static String testURI = "http://localhost:7003/fib/";

    @Test
    public void FibonacciTest(){

        System.out.println("Test case to automate get request: /fib");
        RestAssured.baseURI = testURI;
        System.out.println("RestAssured BaseURI amended to : ["+testURI+"]");
        Response apiResponse = given().contentType("application/json").when().get();
        int responseStatus = (int) apiResponse.statusCode();
        System.out.println("Response status : " + responseStatus);
        Assert.assertEquals(200,responseStatus);
        String fibonacciList = apiResponse.asString();
        System.out.println("Fibonacci default series : " + fibonacciList);
    }

    @Test
    public void FibonacciTestIndex(){

        System.out.println("Test case to automate get request: /fib/range");
        int startIndex = -10;
        int finishIndex = 10;
        RestAssured.baseURI = testURI;
        System.out.println("RestAssured BaseURI amended to : ["+testURI+"]");

        Response apiResponse = given().contentType("application/json").when()
                .get("/range?startIndex="+startIndex+"&finishIndex="+finishIndex);

        int responseStatus = (int) apiResponse.statusCode();
        System.out.println("Response status : " + responseStatus);
        Assert.assertEquals(200,responseStatus);
        String fibonacciList = apiResponse.asString();
        System.out.println("Fibonacci series within range["+startIndex+"-"+finishIndex+"] : " + fibonacciList);
    }

    @Test
    public void FibonacciTestRange(){

        System.out.println("Test case to automate get request: /fib/{index} & verifies the application failure " +
                "with inavalid boundary value");

        RestAssured.baseURI = testURI;
        System.out.println("RestAssured BaseURI amended to : ["+testURI+"]");

        Response apiResponse = given().contentType("application/json").when()
                .get("/2147483647");
        int responseStatus = (int) apiResponse.statusCode();
        System.out.println("Response status : " + responseStatus);
        Assert.assertEquals("Response status check. Expected[200], Actual["+responseStatus+"]",200,responseStatus);
    }
}

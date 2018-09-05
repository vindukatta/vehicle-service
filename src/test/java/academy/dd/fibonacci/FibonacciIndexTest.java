package academy.dd.fibonacci;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

/** Created by Indu Katta 04/09/2018**/

public class FibonacciIndexTest {

    private static String testURI = "http://localhost:7003/fib/";

    @Test
    public void FibonacciIndexTest(){

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
}

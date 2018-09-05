package academy.dd.fibonacci;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

/** Created by Indu Katta 04/09/2018**/

public class FibonacciRangeTest {

    private static String testURI = "http://localhost:7003/fib/";

    @Test
    public void FibonacciRangeTest(){

        System.out.println("Test case to automate get request: /fib/{index} & verifies the application failure " +
                "with inavalid boundary value");

        RestAssured.baseURI = testURI;
        System.out.println("RestAssured BaseURI amended to : ["+testURI+"]");

        Response apiResponse = given().contentType("application/json").when()
                .get("/2147483648");
        int responseStatus = (int) apiResponse.statusCode();
        System.out.println("Response status : " + responseStatus);
        Assert.assertEquals("Response status check. Expected[200], Actual["+responseStatus+"]",200,responseStatus);
    }
}

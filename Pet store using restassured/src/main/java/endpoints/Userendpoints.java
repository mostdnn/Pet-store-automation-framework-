package endpoints;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import paylod.UserPojo;

import java.util.ArrayList;
import java.util.List;

public class Userendpoints {

    public static Response createuser(UserPojo paylod){


            Response response= given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(paylod)
                    .when()
                    .post(roots.posturl);
            return response;
    }

    public static Response readuser(String UserName){
        Response response = RestAssured.given()
                .baseUri(Routes.base_uri)
                .basePath(Routes.get_basePath)
                .pathParam("username",userName)
                .accept(ContentType.JSON)
                .when()
                .get(roots.geturl);
        return response;

    }
    public static Response updateuser(String UserName, UserPojo paylod){


        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",UserName)
                .body(paylod)
                .when()
                .put(roots.updateUrl);
        return response;
    }
    public static Response deleteuser(String UserName){


        Response response= given()
                .pathParam("username",UserName)
                .when()
                .delete(roots.deleteUrl);
        return response;
    }

    public static Response login(String UserName , String Password){
        Response response=given()
                .queryParam("username",UserName,"password")
                .when()
                .get(roots.loginURL);
        return response;
    }
    public static Response logout(){
        Response response=given()
                .when()
                .get(roots.logoutURL);
        return response;
    }
    public static Response createlistofuserarray(List<UserPojo> paylod){


        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(paylod)
                .when()
                .post(roots.createuserlistarrayURL);
        return response;
    }




}

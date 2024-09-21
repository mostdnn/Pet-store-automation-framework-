package endpoints;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import paylod.petsPOJO;

import java.io.File;

public class petsendpoints {

    public static Response uploadimage(petsPOJO payload,long petid){
        String filePath="C:\\Users\\11\\IdeaProjects\\Automationcourse\\src\\main\\resources\\petphoto.jpg";
        Response response=given()
                .pathParam("petId", petid)
                .multiPart("file", new File(filePath))
                .when()
                .post("/pet/{petId}/uploadImage");
        return response;

    }

    public static Response Addnewpet(petsPOJO payload){
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(roots.addpetURL);
        return response;
    }

    public static Response updatewpet(petsPOJO payload){
        Response response=given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(roots.updatepetpetURL);
        return response;
    }

    public static Response findpetbystatus(String Status){
        Response response=given()
                .queryParam("status",Status)
                .when()
                .get(roots.findpetbystatusURL);
        return response;
    }
    public  static  Response findpetbyid(long petid){
        Response response=given()
                .pathParam("petId",petid)
                .when()
                .get(roots.findpetbyidURL);
        return response;

    }
public static Response deletepet(long petid){
        Response response =given()
                .pathParam("petId",petid)
                .when()
                .delete(roots.deletepetURL);
        return response;
}
    public static Response uploadimage(long petid){
        File file = new File("C:\\Users\\11\\IdeaProjects\\Automationcourse\\src\\main\\resources\\petphoto.jpg");
        Response response =given()
                .contentType(ContentType.MULTIPART)
                .multiPart(file)
                .pathParam("petId",petid)
                .when()
                .post(roots.uploadimageURL);
        return response;
    }

}

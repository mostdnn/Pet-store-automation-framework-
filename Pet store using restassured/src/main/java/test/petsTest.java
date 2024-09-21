package test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import paylod.petsPOJO;
import endpoints.petsendpoints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class petsTest {
Faker faker;
String[] statusValues;
long id;
petsPOJO petpayload;
    @BeforeTest
    public void setupdata(){

        faker=new Faker();
        petpayload= new petsPOJO();

        petpayload.setIdpet((int) faker.number().randomNumber());
        long ID =petpayload.setIdpet((long) faker.number().randomNumber());

        petsPOJO.Category category = new petsPOJO.Category();
        category.setId((int) faker.number().randomNumber());
        category.setName(faker.lorem().word());
        petpayload.setCategory(category);

        petpayload.setName(faker.name().firstName());

        List<String> photoUrls = Arrays.asList(faker.internet().image());
        petpayload.setPhotoUrls(photoUrls);

        petsPOJO.Tag tag = new petsPOJO.Tag();
        tag.setId((int) faker.number().randomNumber());
        tag.setName(faker.lorem().word());
        List<petsPOJO.Tag> tags = Arrays.asList(tag);
        petpayload.setTags(tags);
        petpayload.setStatus("available");
    }
    @Test(priority = 1)
    public void uploadimagetest(){
        petpayload.setIdpet(id);
        Response response=petsendpoints.uploadimage(this.petpayload.getIdpet());
        response.then().log().all().assertThat().statusCode(200);
    }


    @Test(priority = 2)
    public  void addpettest(){


        Response response=petsendpoints.Addnewpet(this.petpayload);
        response.then().log().all().assertThat().statusCode(200).extract().response();
        JsonPath jsonPath = response.jsonPath();
         id = jsonPath.getLong("id");
        System.out.println(id);

      

    }

    @Test(priority = 3)
    public  void updatepettest(){


        Response response=petsendpoints.updatewpet(this.petpayload);
        response.then().log().all().assertThat().statusCode(200);

    }


    @Test(priority = 4)
    public  void findbystatusavialabletest(){



        Response response=petsendpoints.findpetbystatus(this.petpayload.getStatus());
        response.then().log().all().assertThat().statusCode(200);

    }
@Test(priority = 5)
    public  void findbystatuspendingtest(){

       // update the status to pending
        petpayload.setStatus("pending");


        Response response=petsendpoints.findpetbystatus(this.petpayload.getStatus());
        response.then().log().all().assertThat().statusCode(200);

    }
@Test(priority = 6)
    public  void findbystatussoldtest(){

        // update the status to sold
        petpayload.setStatus("sold");


        Response response=petsendpoints.findpetbystatus(this.petpayload.getStatus());
        response.then().log().all().assertThat().statusCode(200);
    }
    @Test(priority = 7)
    public void findbyidtest(){
        petpayload.setIdpet(id);
        Response response=petsendpoints.findpetbyid(this.petpayload.getIdpet());
        response.then().log().all().assertThat().statusCode(200);

    }
@Test(priority = 8)
    public void deletepettest(){
    petpayload.setIdpet(id);
    Response response =petsendpoints.deletepet(petpayload.getIdpet());
    response.then().log().all().assertThat().statusCode(200);

}


}

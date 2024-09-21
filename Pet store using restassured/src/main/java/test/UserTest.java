package test;
import com.github.javafaker.Faker;
import endpoints.Userendpoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import paylod.UserPojo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UserTest {

    Faker faker;
    UserPojo userpaylod;


    @BeforeTest
    public void setupdata(){
        faker=new Faker();
        userpaylod=new UserPojo();
        userpaylod.setId(faker.idNumber().hashCode());
         userpaylod.setUsername(faker.name().username());
        userpaylod.setFirstName(faker.name().firstName());
        userpaylod.setLastName(faker.name().lastName());
        userpaylod.setEmail(faker.internet().safeEmailAddress());
        userpaylod.setPassword(faker.internet().password(5,10));
        userpaylod.setPhone(faker.phoneNumber().cellPhone());



    }
    @Test(priority = 1)
    public void Testcreateuser(){
        Response response= Userendpoints.createuser(userpaylod);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }
@Test(priority = 2)
    public void TestGetusersbyName(){
        String d=userpaylod.setUsername(faker.name().username());
        Response response=Userendpoints.readuser();
        response.then().log().all().assertThat().statusCode(200);

    }


    @Test(priority = 3)
            public void TestUpdatedata() {
             // update the data
        userpaylod.setEmail(faker.internet().safeEmailAddress());
        userpaylod.setLastName(faker.name().lastName());


        Response response = Userendpoints.updateuser(this.userpaylod.getUsername(),userpaylod);
        response.then().log().all().assertThat().statusCode(200);
        // checking data after update

        Response responseafterupdate=Userendpoints.readuser(this.userpaylod.getUsername());
        responseafterupdate.then().log().all().assertThat().statusCode(200);

    }

    @Test(priority = 4)
    public void TestDeleteUserbyname(){
        Response response = Userendpoints.deleteuser(this.userpaylod.getUsername());
        response.then().log().all().assertThat().statusCode(200);

    }
    // get user after delete
    @Test(priority = 5)
    public void getAfterdelete(){
        Response response=Userendpoints.readuser(this.userpaylod.getUsername());
        response.then().log().all().assertThat().statusCode(404);

    }
    @Test(priority = 6)
    public void logintest(){
        Response response=Userendpoints.login(this.userpaylod.getUsername(),this.userpaylod.getPassword());
        response.then().log().all().assertThat().statusCode(200);


    }


    @Test(priority = 7)
    public void logouttest(){
        Response response=Userendpoints.logout();
        response.then().log().all().assertThat().statusCode(200);
    }
    @Test(priority = 8)
    public void creatuserarrayttest(){

        List<UserPojo> users = new ArrayList<>();

        UserPojo user = new UserPojo();
        user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setPassword(faker.internet().password(5,10));
        user.setPhone(faker.phoneNumber().cellPhone());
        users.add(user);
        Response response=Userendpoints.createlistofuserarray(users);
        response.then().log().all().assertThat().statusCode(200);
    }



    }



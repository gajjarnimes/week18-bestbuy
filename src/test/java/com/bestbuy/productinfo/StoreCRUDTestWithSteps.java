package com.bestbuy.productinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)

public class StoreCRUDTestWithSteps extends TestBase {

    static String name = "MiniSota" + TestUtils.getRandomValue();
    static String type = "BigBen" + TestUtils.getRandomValue();
    static String address = "Ringdale drive" + TestUtils.getRandomValue();
    static String address2 = "";
    static String city = "Lakeland" + TestUtils.getRandomValue();
    static String state = "Montocarlo" + TestUtils.getRandomValue();
    static String zip = "50540" + TestUtils.getRandomValue();
    static double lat = 45.999999;
    static double lng = -94.449888;
    static String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8" + TestUtils.getRandomValue();
    static String createdAt = "2021-11-17T17:57:05.708Z" + TestUtils.getRandomValue();
    static String updatedAt = "2021-11-17T17:57:05.708Z" + TestUtils.getRandomValue();

    static int storeId;

    @Steps
    StoreSteps storeSteps;

    @Title("This will create new stroe")
    @Test
    public void test01() {
        HashMap<Object,Object>servicesData = new HashMap<>();
        ValidatableResponse response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours, createdAt, updatedAt);
        response.log().all().statusCode(201);
        storeId =response.log().all().extract().path("id");

    }

        @Title("Verify the store is added successfully")
        @Test
        public void test02(){

            HashMap<String,Object> storeMap=storeSteps.getStoreInfoByName(name);
            Assert.assertThat(storeMap,hasValue(name));

        }

        @Title("Update the store detail and verify the updated detail")
         @Test
    public void test03(){
        name=name + "_added";
        storeSteps.updateStore(storeId,name,type,address,address2,city,state,zip,lat,lng,hours,createdAt,updatedAt)
                .log().all().statusCode(200);

        HashMap<String,Object>storeMap= storeSteps.getStoreInfoByName(name);
        Assert.assertThat(storeMap,hasValue(name));

        }
        @Title("Delete the store and verify the store is deleted")
       @Test
    public void test04(){
        storeSteps.getStoreId(storeId).statusCode(204);
        storeSteps.deleteStore(storeId).statusCode(404);
        }

    }




package com.bestbuy.productinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;


import java.util.HashMap;

public class StoreSteps {

    @Step("Creating Store with name:{0},type:{1},address:{2},address2:{3},city:{4},state:{5},zip:{6},lat:{7},lng:{8},hours:{9},createdAt:{10},updatedAt:{11}")

    public ValidatableResponse createStore(String name,String type,String address,String address2,String city,String state,String zip,
                                           double lat,double lng,String hours,String createdAt,String updatedAt){

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        storePojo.setCreatedAt(createdAt);
        storePojo.setUpdatedAt(updatedAt);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoints.CREATE_STORES)
                .then();
    }
    @Step("Getting store details with name:{0}")

     public HashMap<String,Object>getStoreInfoByName(String name){
        String p1 ="findAll{it.name =='";
        String p2 = "'}.get(0)";
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_STORES)
                .then().statusCode(200)
                .extract()
                .path(p1+name+p2);
    }
    @Step("Updating store details with storeId:{0},name:{1},type:{2},address:{3},address2:{4},city:{5},state:{6},zip:{7},lat:{8},lng:{9},hours:{10},createdAt:{11},updatedAt:{12}")

    public ValidatableResponse updateStore(int storeId,String name,String type,String address,String address2,String city,String state,
                                           String zip,double lat,double lng, String hours,String createdAt,String updatedAt){

        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);
        storePojo.setCreatedAt(createdAt);
        storePojo.setUpdatedAt(updatedAt);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .put(EndPoints.UPDATE_STORE_BY_ID)
                .then();
    }
    @Step("Deleting store detail with storeId :{0}")

    public ValidatableResponse deleteStore(int storeId){
        return SerenityRest.given().log().all()
                .pathParam("storeId",storeId)
                .when()
                .delete(EndPoints.DELETE_STORE_BY_ID)
                .then();
    }
    @Step("Getting store detail with storeId:{0}")

    public ValidatableResponse getStoreId(int storeId){
        return SerenityRest.given().log().all()
                .pathParam("storeId",storeId)
                .when()
                .get(EndPoints.GET_SINGLE_STORE_BY_ID)
                .then();
    }




}

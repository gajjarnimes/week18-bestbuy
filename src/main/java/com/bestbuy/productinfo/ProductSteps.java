package com.bestbuy.productinfo;

import com.bestbuy.constants.EndPoints;
import com.bestbuy.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ProductSteps {
    @Step("Create product with name:{0},type:{1},price:{3},upc:{4},shipping:{5},description:{6},manufacturer:{7},model:{8},url:{9},image:{10},createdAt:{11},updatedAt:{12}")

    public ValidatableResponse createProduct(String name, String type, double price, String upc, int shipping, String description, String manufacturer, String model, String url, String image, String createdAt, String updatedAt) {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setUpc(upc);
        productPojo.setShipping(0);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);
        productPojo.setCreatedAt(createdAt);
        productPojo.setUpdatedAt(updatedAt);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post(EndPoints.CREATE_PRODUCTS)
                .then();
    }
    @Step("Getting the product detail with name :{0}")

    public HashMap<String,Object>getproductDetailByName(String name) {
        String p1 = "findAll{it.name =='";
        String p2 = "'}.get(0)";

        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_PRODUCTS)
                .then().statusCode(200)
                .extract()
                .path(p1 + name + p2);
    }
    @Step("Updating product detail with productId:{0}, name:{1},type:{2},price:{3},upc:{4},shipping:{5},description:{6},manufacturer:{7},model:{8},url:{9},image:{10},createdAt:{11},updatedAt:{12}")

    public ValidatableResponse updateProduct(int productId, String name, String type, double price, String upc, int Shipping, String description, String manufacturer, String model, String url, String image, String createdAt, String updatedAt){

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setUpc(upc);
        productPojo.setShipping(0);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);
        productPojo.setCreatedAt(createdAt);
        productPojo.setUpdatedAt(updatedAt);
        return SerenityRest.given().log().all()
                .header("Content-Type","application/json")
                .pathParam("productId",productId)
                .body(productPojo)
                .when()
                .put(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();
    }
    @Step("Deleting product detail with productId:{0}")

    public ValidatableResponse deleteProduct(int productId){
        return SerenityRest.given().log().all()
                .pathParam("productId",productId)
                .when()
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }
    @Step("Getting product details with productId :{0}")

    public ValidatableResponse getProductById(int productId) {
        return SerenityRest.given().log().all()
                .pathParam("productId", productId)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT_BY_ID)
                .then();
    }

}

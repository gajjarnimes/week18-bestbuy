package com.bestbuy.productinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ProductCRUDTestWithSteps extends TestBase {

    static String name = "Duracell-AA Batteries(16-pack)" + TestUtils.getRandomValue();
    static String type = "HardMetal" + TestUtils.getRandomValue();
    static Double price = 12.98;
    static String upc = "099999999999"+ TestUtils.getRandomValue();
    static int shipping = 15;
    static String description = "Compatible with select electronic devices"+TestUtils.getRandomValue();
    static String manufacturer = "Duracell"+ TestUtils.getRandomValue();
    static String model = "DC1800BAZ"+ TestUtils.getRandomValue();
    static String url = " http://www.bestbuy.com/site/duracell-aa-batteries-16-pack/45459.p?id=1051384074145&skuId=45459&cmp=RMXCC"+ TestUtils.getRandomValue();
    static String image="http://img.bbystatic.com/BestBuy_US/images/products/4545/45459_sa.jpg" +TestUtils.getRandomValue();
    static String createdAt = "2023-01-02 T17:21:03.298Z"+ TestUtils.getRandomValue();
    static String updatedAt ="2023-01-02 T17:21:03.298Z" + TestUtils.getRandomValue();

    static int productId;

    @Steps
    ProductSteps productSteps;

    @Title("It will create New Product")
    @Test

    public void test01(){
        ValidatableResponse response = productSteps.createProduct(name,type,price,upc,shipping,description,manufacturer,model,url,image,createdAt,updatedAt);
        response.log().all().statusCode(400);
        productId = response.log().all().extract().path("id");

    }
    @Title("Verify if the product is added successfully")
    @Test
    public void test02(){
        HashMap<String , Object>productMap= productSteps.getproductDetailByName(name);
        Assert.assertThat(productMap,hasValue(name));

    }
    @Title("Update the product details and verify the updated details")
    @Test
    public void test03(){

        type = type +"_updated";
        productSteps.updateProduct(productId,name,type,price,upc,shipping,description,manufacturer,model,url,image,createdAt,updatedAt)
                .log().all().statusCode(400);

        HashMap<String,Object>productMap1 = productSteps.getproductDetailByName(type);
        Assert.assertThat(productMap1,hasValue(type));


    }
    @Title("Delete the product and verify the product is deleted")
    @Test
    public void test04(){
        productSteps.getProductById(productId).statusCode(404);
        productSteps.deleteProduct(productId).statusCode(204);
    }
}

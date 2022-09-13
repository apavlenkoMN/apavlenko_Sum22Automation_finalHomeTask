package com.provectus.tests.backend;

import backend.UserAPI;
import backend.enteties.UserController;
import okhttp3.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class StoreAPITest {

    @Test (priority = 10)
    public void UserCreate() throws IOException {

        UserAPI newOrder = new UserAPI();

        UserController user = new UserController();
        user.setId(8);
//        user.setPetId(2234);
//        store.setQuantity(12);
//        store.setStatus("available");
//        store.setComplete(true);
        Integer responseCode = newOrder.formUser(user);

        System.out.println("Asserts different field values");
        Assert.assertEquals(responseCode.toString(), "200");


//        Assert.assertEquals(store.getId().toString(), "8");
//        Assert.assertEquals(store.getPetId().toString(), "2234");
//        Assert.assertEquals(store.getQuantity().toString(), "12");





    }


    @Test (priority = 20)
    public void getOrderTest() throws IOException {


        UserAPI newOrder = new UserAPI();

        newOrder.getOrderById(8);
        //newOrder.returnField("8", "petId");

        System.out.println("Assert if it exist");
        Assert.assertEquals(newOrder.returnField("8", "petId"), "2234");

    }

    @Test (priority = 30)
    public void getInventoryTest() throws IOException {

        UserAPI inventory = new UserAPI();

        JSONObject responseJson = inventory.getInventory();
        System.out.println(responseJson);

        System.out.println("Assert that not empty");
        Assert.assertNotNull(responseJson.get("available").toString());

    }

    @Test (priority = 40)
    public void deleteOrderTest() throws IOException {

        UserAPI newOrder = new UserAPI();

        Response responseJson = newOrder.deleteOrder(8);
        System.out.println(responseJson);



        System.out.println("Asserts code?");
        //System.out.println(newOrder.getOrderById(8));
        Assert.assertEquals(Integer.toString(responseJson.code()), "200");

    }




}

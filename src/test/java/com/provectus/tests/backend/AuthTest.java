package com.provectus.tests.backend;

import backend.AuthAPI;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthTest {

    @Test (priority = 10)
    public void SignIn() throws IOException {
//
//        UserAPI newOrder = new UserAPI();
//
//        UserController user = new UserController();
//        user.setId(8);
////        user.setPetId(2234);
////        store.setQuantity(12);
////        store.setStatus("available");
////        store.setComplete(true);
//        Integer responseCode = newOrder.formUser(user);
//
//        System.out.println("Asserts different field values");
//        Assert.assertEquals(responseCode.toString(), "200");
//
//
//        Assert.assertEquals(store.getId().toString(), "8");
//        Assert.assertEquals(store.getPetId().toString(), "2234");
//        Assert.assertEquals(store.getQuantity().toString(), "12");

        AuthAPI auth = new AuthAPI();

        //auth.createDefaultUser();
//        auth.signUp("apa2", "apa1234567");
        auth.signIn("apa", "apaapaapa");
        //System.out.println(auth.signIn("apa", "apaapaapa"));

        //auth.signUp("apa2", "apa1234567");




    }
//
//
//    @Test (priority = 20)
//    public void getOrderTest() throws IOException {
//
//
//        UserAPI newOrder = new UserAPI();
//
//        newOrder.getOrderById(8);
//        //newOrder.returnField("8", "petId");
//
//        System.out.println("Assert if it exist");
//        Assert.assertEquals(newOrder.returnField("8", "petId"), "2234");
//
//    }




}

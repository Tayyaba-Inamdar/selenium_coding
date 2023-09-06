package com.cc.testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.*;
import java.net.*;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class TC_C {

    @Test
    public void get_data() throws IOException {
      String jurl = "https://data.sfgov.org/resource/p4e4-a5a7.json";
          Response response =  RestAssured.get(jurl);
          response.print();

    }
}

package com.thoughtworks.spotify;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Spotify {

    String tokenValue;
    String userId = "";
    Long count =0l;
    String playlist_id ="";

    @BeforeMethod
    public void setUp() {
        tokenValue = "Bearer BQCVUeHp0e8LS3Yuy7wXh1jL3_tX5awiuGKquGx2TYZKpiJgUdhzrRimr-GXpq8m52ToxiEONA1Of8A6Q9KxsLpTtZ7ZqTEEdjrBuSNQVu_p22UzfDTsgG2cIHsA0m-XOmka_DCnNKo2WZroxA8CWh5etX5LwOqftlxaBT-8XH7pi0lok_kRb7T4e-6Bytvi3Dyj6aAE4pM92p215zri3NXYZQH8sBa4j0ytDnJrPx41ymYI6t-ynVFg99wqX5r9wdUKRdCH5CCP2LH3X69jTMZyO-ZzcA";
    }

    @Test
    public void givenSpotify_WhenTokenIsCorrect_ShouldReturnSuccessCode() throws ParseException {
        //checking successfully login
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", tokenValue)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.then().assertThat().statusCode(200);

        //Get id
        Response response1 = RestAssured.given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .header("Authorization", tokenValue)
                .when()
                .get("https://api.spotify.com/v1/me");
        JSONObject object = (JSONObject) new JSONParser().parse((response1.asString()));
        String id = (String) object.get("id");
        userId = id;
        System.out.println("ID====>" + id);

        //Get all playlist
        Response response3 = RestAssured.given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .header("Authorization", tokenValue)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");
        JSONObject object3 = (JSONObject) new JSONParser().parse((response3.asString()));
        count = (Long) object3.get("total");
        System.out.println("count====>" + count);


        //created playlist
        JSONObject playListData = new JSONObject();
        playListData.put("name", "Old song");
        playListData.put("description", "my pold song");
        playListData.put("public", false);

        Response response4 = RestAssured.given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .header("Authorization", tokenValue)
                .pathParam("user_id", userId)
                .body(playListData.toJSONString())
                .when()
                .post("https://api.spotify.com/v1/users/{user_id}/playlists");
//        response4.prettyPrint();
        JSONObject object4 = (JSONObject) new JSONParser().parse((response4.asString()));
        playlist_id = (String) object4.get("id");
        System.out.println("playlistid====>" + playlist_id);

        //update
        JSONObject playListData1 = new JSONObject();
        playListData1.put("name", "Old song");
        playListData1.put("description", "my pold song");
        playListData1.put("public", false);
        Response response5 = RestAssured.given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .header("Authorization", tokenValue)
                .body(playListData1.toJSONString())
                .when()
                .post("https://api.spotify.com/v1/playlists/playlist_id");

        //Display updated list
        Response response6 = RestAssured.given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .header("Authorization", tokenValue)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");
        response6.prettyPrint();

    }}
//



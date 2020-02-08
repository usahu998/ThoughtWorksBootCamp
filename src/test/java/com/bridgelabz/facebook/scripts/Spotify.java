package com.bridgelabz.facebook.scripts;

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
        tokenValue = "Bearer BQAmAwTQIaHLVbIGF8H3HlGB1YlfUDEBlwcha0OC2B4ekGUZzfPoZr6Xa_1f-8gSKfBMgoCya6qVYF8Nd9SmZpJYv33bsSqh-nbnwCob_eZuik8rKmuRdXayJgZEVvxCpCiKtDU6rsLgHBtWGWVQdcHQI1dMqkumHGPm8lwV4vdkWYwgw3-9NLdPzKp4PySplxx7QDIYJ7iASbin0dLtyrlytQa5cDba8vMbDawAj4fcExgFRH8l4BwgeTlUAroNCj5zO1XiSPTIN0lju7FvQmd13kiQmQ";
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
        Long total = (Long) object3.get("total");
        count =total;
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
        String playlistId = (String) object4.get("id");
        playlist_id =playlistId;
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



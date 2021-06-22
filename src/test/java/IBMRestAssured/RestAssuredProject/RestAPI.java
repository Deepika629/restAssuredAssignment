package IBMRestAssured.RestAssuredProject;

import org.apache.commons.io.IOUtils;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dataprovider.dataproviderexcel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import pojoclassassignment.Category;

import pojoclassassignment.Rootbody;
import pojoclassassignment.Tags;

import static org.hamcrest.Matchers.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RestAPI {
	
	
	
	@DataProvider(name="exceldataset")
	public Object[][] getdatafromexcel() throws IOException
	{
		Object[][] data = dataproviderexcel.getdatafromExcel();

		return data;
			
	}
	
	@Test(enabled=true, dataProvider="exceldataset")
	public void tescasedataset(String name, String status, String cat_id, String cat_name, String tag_id, String tag_name) throws JsonProcessingException
	{
		RestAssured.baseURI = "http://localhost:3000";
		
		Rootbody rootbodyobj = new Rootbody();
		Category categoryobj = new Category();
		Tags tagsobj = new Tags();
		List<String> photoURLsobj = new ArrayList<String>();
		
		
		rootbodyobj.setName(name);
		rootbodyobj.setStatus(status);
				
		categoryobj.setId(cat_id);
		categoryobj.setName(cat_name);
		
		tagsobj.setId(tag_id);
		tagsobj.setName(tag_name);
		
		photoURLsobj.add("pic1");
		photoURLsobj.add("pic2");
		
		
		rootbodyobj.setCategory(categoryobj);	
		rootbodyobj.setTags(tagsobj);	
		rootbodyobj.setPhotoUrls(photoURLsobj);
		
		ObjectMapper mapperobject = new ObjectMapper();
		
		String jsonbody = mapperobject.writerWithDefaultPrettyPrinter().writeValueAsString(rootbodyobj);
		System.out.println(jsonbody);
		
		
		given()
		.body(jsonbody.toString())
		.headers("content-type", "Application/JSON").
		when()
		.post("petdetails").
		then()
		.log().all();
	
		
		
	}
	
	
}
	



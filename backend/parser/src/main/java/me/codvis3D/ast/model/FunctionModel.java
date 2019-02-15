package me.codvis.ast;

import org.json.JSONObject;

public class FunctionModel extends Model{
	private String name;

	FunctionModel(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	@Override
	public JSONObject getParsedCode(){	
		JSONObject parsedCode = new JSONObject();

		parsedCode.put("name", this.name);
		return parsedCode;
	}
}
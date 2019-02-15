package me.codvis.ast;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;

public class FileModel extends Model{
	private String fileName;
	private List<FunctionModel> functions;
	private List<NamespaceModel> namespaces;
	private List<UsingNamespaceModel> usingNamespace;

	FileModel(String fileName){
		this.fileName = fileName;
		this.functions = new ArrayList<>();
		this.namespaces = new ArrayList<>();
	}

	public void addFunction(FunctionModel function){
		this.functions.add(function);
	}

	public void addNamespace(NamespaceModel namespace){
		this.namespaces.add(namespace);
	}

	public void setFunctions(List<FunctionModel> functions){
		this.functions = functions;
	}

	public List<FunctionModel> getFunctions(){
		return this.functions;
	}

	@Override
	public JSONObject getParsedCode(){
		JSONObject parsedCode = new JSONObject();

		parsedCode.put("file_name", this.fileName);

		List<JSONObject> parsedFunctions = this.convertClassListJsonObjectList(this.functions, "function");
		if (parsedFunctions.size() > 0) {
			parsedCode.put("functions", parsedFunctions);
		}

		List<JSONObject> parsedNamespaces = this.convertClassListJsonObjectList(this.namespaces, "namespace");
		if (parsedFunctions.size() > 0) {
			parsedCode.put("namespaces", parsedNamespaces);
		}
		
		return parsedCode;
	}

}
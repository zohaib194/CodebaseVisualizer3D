package me.codvis.ast;

import java.util.List;
import java.util.ArrayList;

import java.util.Stack;

import org.json.JSONObject;

/**
 * Class for abstracting a code unit.
 */
public class Model {

	/**
	 * Adds a model in current scope.
	 *
	 * @param      model       The model
	 * @param      scopeStack  The scope stack identifying current scope position
	 *
	 * @return     index in list for its type where model was added for current scope. If not a list it will return 0.
	 */
	protected <T extends Model> int addModelInCurrentScope(T model, Stack<ModelIdentifier> scopeStack){
		System.out.println("addModelInCurrentScope not implemented");
		System.exit(1);
		return 0;
	}

	/**
	 * Converts a list of objects extending model, to a list of JSON objects giving same JSON id to each object.
	 *
	 * @param      objectList   The object list to convert to JSONObject.
	 * @param      objectNames  The object names to give as id in JSON to give to each object.
	 *
	 * @return     List of given objects as JSONObject.
	 */
	protected <T extends Model> List<JSONObject> convertClassListJsonObjectList(List<T> objectList, String objectNames){
		if (objectList.size() > 0) {
			List<JSONObject> parsedObjects = new ArrayList<>();

			for (T object : objectList) {
				JSONObject parsedObject = new JSONObject();
				parsedObject.put(objectNames, object.getParsedCode());
				parsedObjects.add(parsedObject);
			}

			return parsedObjects;
		}
		return null;
	}

	/**
	 * Gets the parsed code as JSONObject.
	 *
	 * @return     The parsed code as JSONObject.
	 */
    public JSONObject getParsedCode() {
    	return null;
    }
}
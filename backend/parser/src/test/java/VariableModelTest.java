package me.codvis.ast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import me.codvis.ast.VariableModel;

import com.ginsberg.junit.exit.ExpectSystemExitWithStatus;

public class VariableModelTest {
	private String varType = "int";
	private String varName = "i";

	@Test
	public void testHasFunctions() {
		VariableModel model = new VariableModel();

		assertFalse(model.hasType(), "Wrong type: " + model.hasType() + " from empty VariableModel");
		assertFalse(model.hasName(), "Wrong name: " + model.hasName() + " from empty VariableModel");

		model = new VariableModel(varName, varType);

		assertTrue(model.hasType(), "Wrong type: " + model.hasType() + " from filled VariableModel");
		assertTrue(model.hasName(), "Wrong name: " + model.hasName() + " from filled VariableModel");
	}

	@Test
	public void testGetParsedCode() {
		VariableModel model = new VariableModel();

		JSONObject jsonObj = model.getParsedCode();

		assertNotEquals(varType, jsonObj.getString("type"), "Non empty type for empty VariableModel");
		assertNotEquals(varType, jsonObj.getString("name"), "Non empty name for empty VariableModel");

		model = new VariableModel(varName, varType);

		jsonObj = model.getParsedCode();

		assertEquals(varType, jsonObj.getString("type"), "Incorrect type for VariableModel");
		assertEquals(varName, jsonObj.getString("name"), "Incorrect name for VariableModel");
	}

	@Test
	@ExpectSystemExitWithStatus(1)
	public void testAddDataInModel() {
		VariableModel model = new VariableModel();

		// Try adding objects with illegal types, should exit!
		model.addDataInModel(this);
	}
}
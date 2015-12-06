package stoxology.datacleanser;

import java.util.ArrayList;

import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class DataCleanserImpl implements DataCleanser {

	@Override
	public boolean CleanseData(ArrayList<String> pythonScriptNames) {
		// TODO Auto-generated method stub
		//scripts are in java resources path
		
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("import sys\nsys.path.append('pathToModiles if they're not there by default')\nimport yourModule");
		// execute a function that takes a string and returns a string
		PyObject someFunc = interpreter.get("funcName");
		PyObject result = someFunc.__call__(new PyString("Test!"));
		String realResult = (String) result.__tojava__(String.class);

		
		return false;
	}
}

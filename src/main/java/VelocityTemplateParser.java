import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityTemplateParser {
	public static String generateHTML() throws Exception
	{

		// initialize velocity engine
		VelocityEngine ve = new VelocityEngine();
		ve.init();

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", "Guruvansh");
		map.put("id", 1);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "Sandeep");
		map.put("id", 2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "Rahul");
		map.put("id", 3);
		list.add(map);
		
		// add that list to a VelocityContext
		VelocityContext context = new VelocityContext();
		context.put("empList", list);

		// get the Template
		Template t = ve.getTemplate("src/main/resources/htmlTemplate.vm");

		// render the template into a Writer, here a StringWriter
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		return writer.toString();
	}
}
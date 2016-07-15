package mappings;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

import database.DatabaseManager;

public class Ersteller {

	public static void main(String[] args) throws IOException {

		String packageName = "entities";
		String projektSrc = "C:/Users/5ia14lieberhard/git/Modul226/Buchungssystem/src";
		String mappingPackage = "mapping";
		saveMappingAndClassT("BudgetWithTyp", packageName, projektSrc, mappingPackage);
		saveMappingAndClass("Intervall", packageName, projektSrc, mappingPackage);
		saveMappingAndClass("Budget", packageName, projektSrc, mappingPackage);
		saveMappingAndClass("Person", packageName, projektSrc, mappingPackage);
		saveMappingAndClass("Typ", packageName, projektSrc, mappingPackage);
		saveMappingAndClass("Dauerauftrag", packageName, projektSrc, mappingPackage);
	}

	public static void saveMappingAndClass(String tableName, String packageName, String projektSrc, String mappingPackage) throws IOException {
		String sql = "Select * From " + tableName;

		Result sendQuery = ResultSupport.toResult(DatabaseManager.getDatabaseManager().sendQuery(sql));
		String[] i = sendQuery.getColumnNames();
		HashMap<String, String> test = new HashMap<>();
		SortedMap[] s = sendQuery.getRows();
		for (SortedMap o:s) {
			for (String name : i) {
				String classname = o.get(name).getClass().getName();
				if (test.containsKey(name)) {
					if (!test.get(name).matches(classname)) {
						throw new RuntimeException("Fehler") ;
					}

				} else {
					test.put(name, classname);
				}
			}

		}
		test.forEach((e,f) -> System.out.println(e + ": " + f));
		Set<Entry<String, String>> entrySet = test.entrySet();
		StringBuilder mapping = new StringBuilder();
		mapping.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<sqlMapping>");
		mapping.append("\t<dbToJava name=\"standartmap" + tableName + "\" javaKlasse=\"" + packageName + "." + tableName + "\">\r\n");
		for (Entry<String, String> entry : entrySet) {
			mapping.append("\t\t<mapping column=\"" + entry.getKey() + "\" attribut=\"" + formatName(entry.getKey()) + "\"></mapping>\r\n");
		}

		mapping.append("\t</dbToJava>\r\n</sqlMapping>");
		File mappingFile = new File(projektSrc + "/" + mappingPackage.replace(".", "/") + "/map" + tableName + "_SQL.xml");
		System.out.println(mappingFile.getAbsolutePath());
		if (mappingFile.exists()) {
			throw new RuntimeException("File schon vorhanden");
		} else {
			mappingFile.createNewFile();
		}
		BufferedWriter mappingFw = new BufferedWriter(new FileWriter(mappingFile));
		mappingFw.write(mapping.toString());
		mappingFw.close();

		StringBuilder sb = new StringBuilder();
		sb.append("package " + packageName + ";");
		sb.append("\r\n\r\n");
		sb.append("public class " + tableName + " {\r\n");

		StringBuilder setterSb = new StringBuilder();
		for (Entry<String, String> entry : entrySet) {
			String clazz = formatClass(entry.getValue());
			String name = formatName(entry.getKey());
			sb.append("\tprivate " + clazz + " " + name + ";\r\n");
			setterSb.append(createGetterAndSetter(name, clazz));
		}
		sb.append("\r\n");
		sb.append(setterSb);
		sb.append("}");
		System.out.println(sb.toString());
		File classFile = new File(projektSrc + "/" + packageName.replace(".", "/") + "/" + tableName + ".java");
		System.out.println(classFile.getAbsolutePath());
		if (classFile.exists()) {
			throw new RuntimeException("File schon vorhanden");
		} else {
			classFile.createNewFile();
		}
		BufferedWriter fw = new BufferedWriter(new FileWriter(classFile));
		fw.write(sb.toString());
		fw.close();
	}

	public static void saveMappingAndClassT(String tableName, String packageName, String projektSrc, String mappingPackage) throws IOException {
		String sql = "Select * From (Select * From Budget Inner Join Typ On Budget.Typ_Id_Fs = Typ.Typ_Id) as " + tableName;

		Result sendQuery = ResultSupport.toResult(DatabaseManager.getDatabaseManager().sendQuery(sql));
		String[] i = sendQuery.getColumnNames();
		HashMap<String, String> test = new HashMap<>();
		SortedMap[] s = sendQuery.getRows();
		for (SortedMap o:s) {
			for (String name : i) {
				String classname = o.get(name).getClass().getName();
				if (test.containsKey(name)) {
					if (!test.get(name).matches(classname)) {
						throw new RuntimeException("Fehler") ;
					}

				} else {
					test.put(name, classname);
				}
			}

		}
		test.forEach((e,f) -> System.out.println(e + ": " + f));
		Set<Entry<String, String>> entrySet = test.entrySet();
		StringBuilder mapping = new StringBuilder();
		mapping.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<sqlMapping>");
		mapping.append("\t<dbToJava name=\"standartmap" + tableName + "\" javaKlasse=\"" + packageName + "." + tableName + "\">\r\n");
		for (Entry<String, String> entry : entrySet) {
			mapping.append("\t\t<mapping column=\"" + entry.getKey() + "\" attribut=\"" + formatName(entry.getKey()) + "\"></mapping>\r\n");
		}

		mapping.append("\t</dbToJava>\r\n</sqlMapping>");
		File mappingFile = new File(projektSrc + "/" + mappingPackage.replace(".", "/") + "/map" + tableName + "_SQL.xml");
		System.out.println(mappingFile.getAbsolutePath());
		if (mappingFile.exists()) {
			throw new RuntimeException("File schon vorhanden");
		} else {
			mappingFile.createNewFile();
		}
		BufferedWriter mappingFw = new BufferedWriter(new FileWriter(mappingFile));
		mappingFw.write(mapping.toString());
		mappingFw.close();

		StringBuilder sb = new StringBuilder();
		sb.append("package " + packageName + ";");
		sb.append("\r\n\r\n");
		sb.append("public class " + tableName + " {\r\n");

		StringBuilder setterSb = new StringBuilder();
		for (Entry<String, String> entry : entrySet) {
			String clazz = formatClass(entry.getValue());
			String name = formatName(entry.getKey());
			sb.append("\tprivate " + clazz + " " + name + ";\r\n");
			setterSb.append(createGetterAndSetter(name, clazz));
		}
		sb.append("\r\n");
		sb.append(setterSb);
		sb.append("}");
		System.out.println(sb.toString());
		File classFile = new File(projektSrc + "/" + packageName.replace(".", "/") + "/" + tableName + ".java");
		System.out.println(classFile.getAbsolutePath());
		if (classFile.exists()) {
			throw new RuntimeException("File schon vorhanden");
		} else {
			classFile.createNewFile();
		}
		BufferedWriter fw = new BufferedWriter(new FileWriter(classFile));
		fw.write(sb.toString());
		fw.close();
	}

	private static String formatName(String name) {
		StringBuilder sb = new StringBuilder();
		boolean b = true;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (c == '_') {
				b = false;
			} else {
				if (b) {
					c = Character.toLowerCase(c);
				}
				sb.append(c);
				b = true;
			}
		}
		return sb.toString();
	}

	private static String formatClass(String value) {
		String[] split = value.split("\\.");
		return split[split.length-1];
	}

	private static String createGetterAndSetter(String attributName, String attributClass) {
		String setter = "\tpublic void set" + Character.toUpperCase(attributName.charAt(0)) + attributName.substring(1) + "(" + attributClass + " " + attributName + ") {\r\n\t\tthis. " + attributName + " = " + attributName + ";\r\n\t}";
		String getter = "\tpublic " + attributClass + " get" + Character.toUpperCase(attributName.charAt(0)) + attributName.substring(1) + "() {\r\n\t\treturn " + attributName + ";\r\n\t}";
		return setter + "\r\n\r\n" + getter + "\r\n\r\n";
	}


}

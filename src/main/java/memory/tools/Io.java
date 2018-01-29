package memory.tools;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Io {

    public static Properties loadProperties(String fname)throws IOException{
	Properties p = new Properties();
	p.load(Io.class.getResourceAsStream("/"+fname));
	return p;
    }

    private static BufferedReader getReader(String fname) throws IOException{
	return Files.newBufferedReader(Paths.get(fname));
    }

    private static PrintWriter getWriter(String fname, boolean append)throws IOException{
	return new PrintWriter(new FileWriter(fname, append));
    }

    public static String read(String fname) throws IOException{
	BufferedReader reader = getReader(fname);
	List<String> lines = reader.lines().collect(Collectors.toList());
	return Str.concat(lines, "\n");
    }

    public static void write(String fname, String content, boolean append) throws IOException{
	PrintWriter writer = getWriter(fname, append);
	writer.printf("%s", content);
	writer.close();
    }

    public static boolean isFile(String fname){
	return new File(fname).isFile();
    }

    //shallowly gets all normal files (non dir) in a directory
    public static List<File> getFiles(String path){
	File dir = new File(path);
	List<File> lzt = new ArrayList<>();
	for (File f: dir.listFiles()){
	    if (f.isFile())
		lzt.add(f);
	}
	return lzt;
    }
    
    public static boolean exists(String fname){
	return new File(fname).exists();
    }

    //write only if file doesn't already exist
    public static boolean writeIfNew(String fname, String content)throws IOException{
	if (exists(fname)) return false;
	write(fname, content, false);
	return true;
    }

    /**
     * Create a directory with the given name. Does nothing if already exists.
     */
    public static void mkdir(String name){
	new File(name).mkdir();
    }

    /**
     * Delete a certain file. Good for normal files and empty directories.
     */
    public static void delete(String name){
	new File(name).delete();
    }

    public static List<String> ls(String name){
	return Arrays.asList(new File(name).list());
    }

}

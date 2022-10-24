import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/*
 * Tutaj tworzymy listê plików w tablicy
 */
public class Lister {
	
	int i =0;
	int index=0;
	boolean ext2;	
	Object ext;
	String dir;
	String comma = ",";
	String ext1;
	File[] files;
	File fp;
	
	public void dataHolder(ArrayList<String> storage1, String dir, File fp, String comma, Object ext) {
		
		ext1 = (String) ext;
		
	try {
	try (FileWriter write = new FileWriter(fp)) {
		try (PrintWriter outputFile = new PrintWriter (fp)) {
			File file = new File(dir); 
			
			for (index=0;index<storage1.size();index++) {
				
			 files = file.listFiles(new FilenameFilter() {	 
				 
			public boolean accept(File dir, String name) {
				
				String pref = storage1.get(index);
				if (ext1 ==null) {
					ext2=true;
				}else {
				ext2 = name.regionMatches(true, name.length()-ext1.length(),ext1 ,0, ext1.length());
				}
				return name.regionMatches(true, 0, pref, 0, pref.length()) && ext2;
						}
				});
			 
			for (int i=0;i<files.length;i++) {
				outputFile.println(files[i]+comma);	 
				}	
			}
				outputFile.close();
		}	
		write.close();
		}		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}	
}
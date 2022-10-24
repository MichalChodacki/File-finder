import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JOptionPane;
/*
 *Import data from database to ArrayListy
 */
public class Importer {
	
	String dir;
	File path;
	String fp;
	Boolean insertMe = false;
	FileWriter write;
	PrintWriter outputFile;
	
	final ArrayList<String> storage1 = new ArrayList<>();
	
	public void reader (String dir){
		
		try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
			
				while (br.ready()) {
					storage1.add(br.readLine());
				}
		}catch (NullPointerException e) {
			insertMe = true;
			System.out.println("Error! Import list in txt file");
			JOptionPane.showMessageDialog
			(null, "Error! Insert file containing list in txt!","Search error!", JOptionPane.ERROR_MESSAGE);
		}

		catch (IOException e) {
			e.printStackTrace();
					}
		}
	public void doubleRemove() {
		Set<String> set = new LinkedHashSet<>(storage1);
		storage1.clear();
		storage1.addAll(set);
	}
	public void saver(String fp) {
		try {
			try (FileWriter write = new FileWriter(fp)) {
				try (PrintWriter outputFile = new PrintWriter (fp)) {						
					for (int i=0;i<storage1.size();i++) {
						outputFile.println(storage1.get(i));						
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
	public ArrayList<String> getStorage1() {
		// TODO Auto-generated method stub
		return storage1;
	}
	public int getSize() {
		return storage1.size();
	}
	public final Boolean getInsertMe() {
		return insertMe;
	}	
	
}



	


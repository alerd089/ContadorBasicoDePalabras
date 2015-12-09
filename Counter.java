import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;


public class Counter {
	
	public static class ValueComparator implements Comparator<String> {

	    Map<String, Integer> base;
	    public ValueComparator(Map<String, Integer> base) {
	        this.base = base;
	    }    
	    public int compare(String a, String b) {
	        if (base.get(a) >= base.get(b)) {
	            return -1;
	        } else {
	            return 1;
	        } 
	    }
	}
	
	/**
	 * @param args
	 */
	public static void count(String file){
		Scanner sc = null;
		BufferedWriter bw = null;
		HashMap<String,Integer> palabraSAuxiliar = new HashMap<>();
		HashMap<String,Integer> palabraCAuxiliar = new HashMap<>();
		ValueComparator bvc =  new ValueComparator(palabraSAuxiliar);
		ValueComparator bvc2 =  new ValueComparator(palabraCAuxiliar);
		TreeMap<String,Integer> sorted_map_SAuxiliar = new TreeMap<String,Integer>(bvc);
		TreeMap<String,Integer> sorted_map_CAuxiliar = new TreeMap<String,Integer>(bvc2);
		HashSet <String> pal = new HashSet <>();
		StringTokenizer a;
		String check;
		Integer pCAuxiliar=0;
		Integer pSAuxiliar=0;
		try {
			sc = new Scanner(new File("pal.txt"));
			while(sc.hasNext()){
				check = sc.next();
				pal.add(check);
			}	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			sc = new Scanner(new File(file));
			while(sc.hasNext()){
				a = new StringTokenizer(sc.next(),",|.|:|-|;| ");
				pCAuxiliar+=a.countTokens();
				while(a.hasMoreTokens()){
					check = a.nextToken().toLowerCase();
					if(!pal.contains(check)){
						pSAuxiliar++;
						if(!palabraSAuxiliar.containsKey(check)){
							palabraSAuxiliar.put(check, 1);
						}else{
							Integer value = palabraSAuxiliar.get(check);
							palabraSAuxiliar.put(check, value+1);
						}
					}
					if(!palabraCAuxiliar.containsKey(check)){
						palabraCAuxiliar.put(check, 1);
					}else{
						Integer value = palabraCAuxiliar.get(check);
						palabraCAuxiliar.put(check, value+1);
					}
				}
			}
			sorted_map_SAuxiliar.putAll(palabraSAuxiliar);
			sorted_map_CAuxiliar.putAll(palabraCAuxiliar);
			System.out.println("Numero de palabras con auxiliar :"+pCAuxiliar);
			System.out.println("Numero de palabras sin auxiliar :"+pSAuxiliar);
			Iterator<Entry<String, Integer>> iterator = sorted_map_SAuxiliar.entrySet().iterator();
			Iterator<Entry<String, Integer>> iterator2 = sorted_map_CAuxiliar.entrySet().iterator();
			int i=0;
			System.out.println("10 palabras mas repetidas: ");
			String xs="";
			while(i<10){
				Object c=iterator.next();
				System.out.println(c.toString());
				xs+=c.toString()+"\n";
				i++;
			}
			i=0;
			bw = new BufferedWriter(new FileWriter("mitexto.reporte.txt"));
			bw.write("Total de palabras sin auxiliares: "+pSAuxiliar);
			bw.newLine();
			bw.newLine();
			bw.write("Total de palabras con auxiliares: "+pCAuxiliar);
			bw.newLine();
			bw.newLine();
			bw.write("10 palabras mas repetidas: ");
			bw.newLine();
			bw.write(xs);
			bw.newLine();
			bw.newLine();
			/*while(i<10){
				Object d=iterator.next();
				bw.write(d+"");
				bw.newLine();
				i++;
			}*/
			i=0;
			bw.write("Todas las palabras: ");
			bw.newLine();
			while(i<sorted_map_CAuxiliar.size()){
				Object c=iterator2.next();
				bw.write(c+"");
				bw.newLine();
				i++;
			}
			
			
			}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				sc.close();
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		count(args[0]);
	}

}

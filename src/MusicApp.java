package musicapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.lang.Comparable;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.*;
import java.io.*;

class InReader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    
    static String nextLine() throws IOException
    {
    	return reader.readLine();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    
    static float nextFloat() throws IOException {
    	return Float.parseFloat( next() );
    }
}
class Song implements Serializable
{
	String name, singer, duration;
	static final long serialVersionUID=1;
	public Song(String nm, String s, String d)
	{
		name=nm;
		singer=s;
		duration=d;
	}
}
public class MusicApp {
	public List<Song> initializePlaylist(String playlist) throws IOException, FileNotFoundException
	{
		Song song1=new Song("Despacito", "Justin Bieber", "235");
		Song song2=new Song("Shape Of You", "Ed Sheeran", "233");
		Song song3=new Song("Kaun Tujhe", "Palak Muchhal", "243");
		Song song4=new Song("Let Me Love You", "Justin Bieber", "216");
		Song song5=new Song("Mere Rashke Qamar", "Arijit Singh", "189");
		List<Song> songlist=new ArrayList<Song>();
		songlist.add(song1);
		songlist.add(song2);
		songlist.add(song3);
		songlist.add(song4);
		songlist.add(song5);
		serialize(playlist, songlist);
		return songlist;
	}
	public void printFiles() throws IOException
	{
		File files=new File("./src/musicapp/");
	    File[] filename=files.listFiles();
	    for (int i=0; i<filename.length; i++)
	    {
	    	if (filename[i].getName().endsWith(".java")==false)
	    		System.out.println(filename[i].getName());
	    }
	    System.out.println();
	    System.out.print("Select Playlist: ");
	}
	public static void serialize(String playlist, List<Song> songs) throws IOException
	{
        ObjectOutputStream outFile=null;
        try
        {
        	outFile=new ObjectOutputStream(new FileOutputStream("./src/musicapp/"+playlist));
        	outFile.writeObject(songs);
        }
        finally
        {
        	outFile.close();
        }
	}
	public static void deserialize(String playlist) throws IOException, ClassNotFoundException
	{
        ObjectInputStream inFile=null;
        try
        {
        	inFile=new ObjectInputStream(new FileInputStream("./src/musicapp/"+playlist));
        	List<Song> list=new ArrayList<Song>();
        	list=(List<Song>) inFile.readObject();
            for (Song sg : list)
            	System.out.println(sg.name+" "+sg.singer+" "+sg.duration);
        }
        finally
        {
        	inFile.close();
        }
	}
	public List<Song> countSongs(String playlist) throws IOException, ClassNotFoundException
	{
		ObjectInputStream inFile=null;
		List<Song> list=new ArrayList<Song>();
        try
        {
        	inFile=new ObjectInputStream(new FileInputStream("./src/musicapp/"+playlist));
        	list=(List<Song>) inFile.readObject();
    		System.out.println("Total no. of Songs in this playlist: "+list.size());
        }
        finally
        {
        	inFile.close();
        }
		return list;
	}
	public void menu()
	{
		System.out.println("Menu :");
	    System.out.println("1. Add");
	    System.out.println("2. Delete");
	    System.out.println("3. Search");
	    System.out.println("4. Show");
	    System.out.println("5. Back to Menu");
	    System.out.println("6. Exit");
	    
	    System.out.print("Select Option (1-6) : ");
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		InReader.init(System.in);
		Scanner scanner=new Scanner(System.in);
		MusicApp music=new MusicApp();
		music.printFiles();
		String playlist=InReader.next();
		List<Song> songs=music.initializePlaylist(playlist);
		System.out.println("Total no. of Songs in this playlist: "+songs.size());
		int choice=0;
		System.out.println();
		music.menu();
		do
		{
		    choice=InReader.nextInt();
		    switch(choice)
		    {
		    case 1: System.out.print("Enter a new song, singer's information, duration(sec) : ");
		            String newsong=InReader.nextLine();
		            String[] parts=newsong.split(",");
	                Song n_song=new Song(parts[0], parts[1], parts[2]);
	                songs.add(n_song);
	                System.out.println("Total no. of Songs in this playlist: "+songs.size());
	                serialize(playlist, songs);
	                break;
		    case 2: System.out.print("Enter the song name to be deleted : ");
		            String s=InReader.nextLine();
		    		boolean flag=false;
		            for (Song sg : songs)
		            {
		            	if (sg.name.equalsIgnoreCase(s)==true)
		            	{
		            		songs.remove(sg);
		            		flag=true;
		            		break;
		            	}
		            }
		            if (flag==true)
	            		System.out.println("Total no. of Songs in this playlist: "+songs.size());
		            else
		            	System.out.println("Sorry!!! Does Not Exist.");
		            serialize(playlist, songs);
		            break;
		    case 3: System.out.print("Enter the song name to search for : ");
		            String s1=InReader.nextLine();
		    		boolean flag1=false;
		            for (Song sg : songs)
		            {
		            	if (sg.name.equalsIgnoreCase(s1)==true)
		            	{
		            		System.out.println("Song Found : ");
		            		System.out.println(sg.name+" "+sg.singer+" "+sg.duration);
		            		flag1=true;
		            	}
		            }
		            if (flag1==false)
		            	System.out.println("Sorry!!! Does Not Exist.");
                    break;
		    case 4: System.out.println("All Songs In The Playlist :");
		            Song sg;
		            int i;
		            if (songs.size()==0)
		            	System.out.println("No Song Exist");
		            else
		            {
		            	for (i=0; i<songs.size()-1; i++)
		            	{
		            		sg=songs.get(i);
		            		System.out.println(sg.name+" "+sg.singer+" "+sg.duration);
			            }
		            	sg=songs.get(i);
	            		System.out.println(sg.name+" "+sg.singer+" "+sg.duration);
		            }
		            break;
		    case 5: music.printFiles();
		            playlist=InReader.next();
					songs=music.countSongs(playlist);
					music.menu();
					break;
		    }
		}while(choice!=6);
		
	}
}

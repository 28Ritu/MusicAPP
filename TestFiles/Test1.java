package testmusicapp;

import musicapp.*;
import java.io.*;
import java.lang.*;
import java.util.*;

import org.junit.Test;	
import static org.junit.Assert.*;
public class Test1 {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	MusicApp music=new MusicApp();	
	@Test	
	public void testAddSong() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		String simulatedUserInput= "MyPlaylist"+System.getProperty("line.separator")+"1"+System.getProperty("line.separator")+"Hasi Ban Gaye, Shreya Ghoshal, 200"+System.getProperty("line.separator")+"4"+System.getProperty("line.separator")+"6";
		ByteArrayInputStream in=new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		String[] args=null;
		music.main(args);
	}
}

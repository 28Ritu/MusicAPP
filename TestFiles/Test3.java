package testmusicapp;

import musicapp.*;
import java.io.*;
import java.lang.*;
import java.util.*;

import org.junit.Test;	
import static org.junit.Assert.*;
public class Test3 {
	
	MusicApp music=new MusicApp();	
	@Test	
	public void testSearchSong() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		String songname="Kaun Tujhe";
		String simulatedUserInput="MyPlaylist"+System.getProperty("line.separator")+"3"+System.getProperty("line.separator")+songname+System.getProperty("line.separator")+"6";
		ByteArrayInputStream in=new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		String[] args=null;
		music.main(args);
	}
}

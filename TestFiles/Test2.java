package testmusicapp;

import musicapp.*;
import java.io.*;
import java.lang.*;
import java.util.*;

import org.junit.Test;	
import static org.junit.Assert.*;
public class Test2 {
	
	MusicApp music=new MusicApp();	
	@Test	
	public void testDeleteSong() throws FileNotFoundException, ClassNotFoundException, IOException
	{
		String songname="Let Me Love You";
		String simulatedUserInput="MyPlaylist"+System.getProperty("line.separator")+"2"+System.getProperty("line.separator")+songname+System.getProperty("line.separator")+"4"+System.getProperty("line.separator")+"6";
		ByteArrayInputStream in=new ByteArrayInputStream(simulatedUserInput.getBytes());
		System.setIn(in);
		String[] args=null;
		music.main(args);
	}
}

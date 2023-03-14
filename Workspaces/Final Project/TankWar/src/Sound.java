import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
public class Sound 
{
	public static boolean check;
	public static Sound button= new Sound("button-28.wav");
	public static Sound cannon = new Sound("Cannon+5.wav");
	public static Sound explosion = new Sound("Bomb_Exploding.wav");
	public static Sound explode = new Sound("Bunker.wav");
	
	  private SourceDataLine line = null;
	  private byte[] audioBytes;
	  private int numBytes;

	  /**
	   * Constructs an <code>EasySound</code> for a given audio file.
	   * @param fileName the name or pathname of the audio clip file.
	   */
	  public Sound(String fileName)
	  {
		check = true;
	    File  soundFile = new File(fileName);
	    AudioInputStream audioInputStream = null;
	    try
	    {
	      audioInputStream = AudioSystem.getAudioInputStream(soundFile);
	    }
	    catch (Exception ex)
	    {
	      System.out.println("*** Cannot find " + fileName + " ***");
	      System.exit(1);
	    }

	    AudioFormat audioFormat = audioInputStream.getFormat();
	    DataLine.Info info = new DataLine.Info(SourceDataLine.class,
	                         audioFormat);
	    try
	    {
	      line = (SourceDataLine)AudioSystem.getLine(info);
	      line.open(audioFormat);
	    }
	    catch (Exception ex)
	    {
	      System.out.println("*** Audio line unavailable ***");
	      return;
	    }

	    line.start();

	    audioBytes = new byte[(int)soundFile.length()];

	    try
	    {
	      numBytes = audioInputStream.read(audioBytes, 0, audioBytes.length);
	    }
	    catch (IOException ex)
	    {
	      System.out.println("*** Cannot read " + fileName + " ***");
	      System.exit(1);
	    }
	  }

	  /**
	   * Plays this <code>EasySound</code>.
	   */
	  public void play()
	  {
	    // Our thanks to JP Fasano for helping debug audio line exceptions. 
	    if (line != null && check)
	      line.write(audioBytes, 0, numBytes);
	    else
	      System.out.println("La-la-la (the audio line is unavailable on this computer)");
	  }
	}

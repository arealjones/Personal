package DesignPatterns.Adaptor;

import DesignPatterns.Adaptor.MediaPlayerExample.MediaAdapter.AudioPlayer;
/**
 I found this example on tutorialspoint so do not copy exactly.
 Adapter pattern works as a bridge between two incompatible interfaces. */
public class MediaPlayerExample {
  /** Media Player Interface.
   -----------------------------------------------------------------------------------------------*/
  public interface MediaPlayer {
    public void play(String audioType, String fileName);
  }

  /** Media Adapter.
   -----------------------------------------------------------------------------------------------*/
  public static class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;
    public MediaAdapter(String audioType){
      if(audioType.equalsIgnoreCase("vlc") ){
        advancedMusicPlayer = new VlcPlayer();
      } else if (audioType.equalsIgnoreCase("mp4")){
        advancedMusicPlayer = new Mp4Player();
      }
    }

    /** Audio Player.
     -----------------------------------------------------------------------------------------------*/
    public static class AudioPlayer implements MediaPlayer {
      MediaAdapter mediaAdapter;
      @Override
      public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("mp3")) {  //inbuilt support to play mp3 music files
          System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) { //mediaAdapter is providing support to play other file formats
          mediaAdapter = new MediaAdapter(audioType);
          mediaAdapter.play(audioType, fileName);
        } else {
          System.out.println("Invalid media. " + audioType + " format not supported");
        }
      }
    }
    @Override
    public void play(String audioType, String fileName) {
      if(audioType.equalsIgnoreCase("vlc")) {
        advancedMusicPlayer.playVlc(fileName);
      } else if (audioType.equalsIgnoreCase("mp4")) {
        advancedMusicPlayer.playMp4(fileName);
      }
    }
  }

  /** Advanced Media Player Interface.
   -----------------------------------------------------------------------------------------------*/
  public interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
  }

  /** VLC Player.
   -----------------------------------------------------------------------------------------------*/
  public static class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
      System.out.println("Playing vlc file. Name: "+ fileName);
    }
    @Override
    public void playMp4(String fileName) {
      //do nothing
    }
  }

  /** MP4 Player.
   -----------------------------------------------------------------------------------------------*/
  public static class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
      //do nothing
    }
    @Override
    public void playMp4(String fileName) {
      System.out.println("Playing mp4 file. Name: "+ fileName);
    }
  }


  /** Testing.
   -----------------------------------------------------------------------------------------------*/
  public static void main(String[] args) {
    AudioPlayer audioPlayer = new AudioPlayer();
    audioPlayer.play("mp3", "beyond the horizon.mp3");
    audioPlayer.play("mp4", "alone.mp4");
    audioPlayer.play("vlc", "far far away.vlc");
    audioPlayer.play("avi", "mind me.avi");
  }


}

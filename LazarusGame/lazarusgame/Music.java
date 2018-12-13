package lazarusgame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {

    private Clip clip;
    private AudioInputStream audio;

    Music() {}

    public void backgroundMusic()
    {
        try {
            try {
                audio = AudioSystem.getAudioInputStream(new File("Resources/Music.mid"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            if (clip != null) {
                try {
                    clip.open(audio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playMove()
    {
        try {
            try {
                audio = AudioSystem.getAudioInputStream(new File("Resources/Move.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            if (clip != null) {
                try {
                    clip.open(audio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();
    }

    public void playButton()
    {
        try {
            try {
                audio = AudioSystem.getAudioInputStream(new File("Resources/Button.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            if (clip != null) {
                try {
                    clip.open(audio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();
    }

    public void playSquish()
    {
        try {
            try {
                audio = AudioSystem.getAudioInputStream(new File("Resources/Squished.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            if (clip != null) {
                try {
                    clip.open(audio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();
    }

    public void playWall()
    {
        try {
            try {
                audio = AudioSystem.getAudioInputStream(new File("Resources/Wall.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            if (clip != null) {
                try {
                    clip.open(audio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();
    }
    public void playCrush()
    {
        try {
            try {
                audio = AudioSystem.getAudioInputStream(new File("Resources/Crush.wav"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            if (clip != null) {
                try {
                    clip.open(audio);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        clip.start();
    }




}

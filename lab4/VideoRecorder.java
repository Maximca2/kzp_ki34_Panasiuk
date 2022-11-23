package lab4;

import java.io.FileNotFoundException;
import java.util.ArrayList;

abstract interface IVideoRecorder {
    void record();
}

public class VideoRecorder extends VideoPlayer {


    public VideoRecorder() throws FileNotFoundException {
    }
    /**
     * Write video to memory
     * @param video
     */
    public void record(ArrayList<Frame> video) {
        video.forEach((frame -> {
            super.memory.write(frame);
        }));
    }
    /**
     * Method for video play
     * @throws Exception
     */
    public void play() throws Exception {
        super.playVideo();
    }
}

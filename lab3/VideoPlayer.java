package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoPlayer {

    private PrintWriter fout;
    private final String FILE = "lab3.txt";
    private boolean isOn = false;

    private Memory memory;

    public VideoPlayer() throws FileNotFoundException {
        fout = new PrintWriter(new File(FILE));
        memory = new Memory();
    }
    /**
     * Write video to memory
     * @param frames
     */
    public void writeIntoMemory(ArrayList<Frame> frames) {
        frames.forEach((frame -> {
            memory.write(frame);
        }));
    }
    /**
     * Return frame by index from memory
     * @param index - frame index
     */
    public Frame readFromMemory(int index) throws Exception{

        if(index >= memory.getSize()) {
            throw new Exception("Wrong index");
        }

        return memory.read(index);
    }
    /**
     * Method for video play
     * @throws Exception
     */
    public void playVideo() throws Exception{
        if(!isOn) {
            throw new Exception("You need to turn on the video player");
        }

        memory.getContent().forEach((frame -> {
            ShowFrame(frame);
        }));
    }
    /**
     * Method show frame
     * @param frame
     */
    public void ShowFrame(Frame frame) {
        AtomicInteger i = new AtomicInteger();
        frame.getContent().forEach((pixel) -> {
            if(i.get() == frame.getFRAME_WIDTH()) {
                i.set(0);
                printMessage("\n");
            }else {
                printMessage(pixel.getInfo());
                i.getAndIncrement();
            }
        });
    }
    /**
     * Method turns on the VideoPlayer
     */
    public void turnOn() {
        if (isOn) {
            return;
        }
        isOn = true;
        printMessage("VideoPlayer is turned on");
    }
    /**
     * Method turns off the VideoPlayer
     */
    public void turnOff()
    {
        if(isOn)
        {
            isOn = false;
            printMessage("VideoPlayer is turned off");
        }
    }
    public void dispose()
    {
        fout.flush();
        fout.close();
    }

    // private void printlnMessage(String message)
    // {
    //     fout.println(message);
    //     System.out.println(message);
    // }
    private void printMessage(String message)
    {
        fout.print(message);
        System.out.print(message);
    }

}

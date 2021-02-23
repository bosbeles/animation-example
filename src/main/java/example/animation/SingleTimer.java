package example.animation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleTimer {

    private Timer timer;
    private TimerParams timerParams;

    public synchronized void start(TimerParams timerParams) {
        stop();
        this.timerParams = timerParams;

        AtomicInteger currentFrame = new AtomicInteger(0);
        int totalFrame = timerParams.getDuration() / timerParams.getInterval();
        timer = new Timer(timerParams.getInterval(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int frame = currentFrame.incrementAndGet();
                timerParams.getTimerFunction().accept(frame, totalFrame);
                if (frame >= totalFrame) {
                    Timer source = (Timer) e.getSource();
                    source.stop();
                }
            }
        });
        timer.start();

    }

    public synchronized void stop() {
        if (timer != null) {
            timer.stop();
            int totalFrame = timerParams.getDuration() / timerParams.getInterval();
            timerParams.getTimerFunction().accept(totalFrame, totalFrame);
        }
    }


}

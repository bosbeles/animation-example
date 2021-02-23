package example.animation;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class AnimationTimer {

    private final int totalTime;
    private final int fps;
    private final int totalFrame;
    private int delay;
    private Timer timer;
    private BiConsumer<Integer, Integer> consumer;

    public AnimationTimer(int fps, int totalTime) {
        this.fps = fps;
        this.totalTime = totalTime;
        int delay = totalTime / fps;
        if (delay == 0) delay = 10;
        this.totalFrame = totalTime / delay;

    }

    public void start(BiConsumer<Integer, Integer> consumer) {
        stop();
        this.consumer = consumer;
        AtomicInteger count = new AtomicInteger(0);
        int delay = totalTime / fps;
        if (delay == 0) delay = 10;

        timer = new Timer(delay, e -> {
            int currentFrame = count.incrementAndGet();
            consumer.accept(currentFrame, totalFrame);
            if (currentFrame >= totalFrame) {
                Timer sourceTimer = (Timer) e.getSource();
                sourceTimer.stop();
            }
        });
        timer.start();
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
            consumer.accept(totalFrame, totalFrame);
        }
    }


}

package example.animation;


import java.util.function.BiConsumer;

public final class TimerParams {

    private final int interval;
    private final int duration;
    private final BiConsumer<Integer, Integer> timerFunction;

    private TimerParams(int interval, int duration, BiConsumer<Integer, Integer> timerFunction) {

        this.interval = interval;
        this.duration = duration;
        this.timerFunction = timerFunction;
    }

    public static TimerParams of(int interval, int duration, BiConsumer<Integer, Integer> timerFunction) {
        return new TimerParams(interval, duration, timerFunction);
    }

    public BiConsumer<Integer, Integer> getTimerFunction() {
        return timerFunction;
    }

    public int getDuration() {
        return duration;
    }

    public int getInterval() {
        return interval;
    }
}

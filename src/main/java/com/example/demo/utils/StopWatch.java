package com.example.demo.utils;

public class StopWatch {
    private volatile boolean running = false;
    private volatile long startTime = -1L;
    private volatile long stopTime = -1L;
    private volatile long markTime = -1L;

    public StopWatch() {
    }

    public static StopWatch startNew() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    public synchronized long start() {
        if (this.running) {
            throw new IllegalStateException("Stopwatch already started");
        } else {
            this.startTime = System.currentTimeMillis();
            this.markTime = -1L;
            this.stopTime = -1L;
            this.running = true;
            return this.startTime;
        }
    }

    public synchronized long mark() {
        if (!this.running) {
            throw new IllegalStateException("Stopwatch hasn't been started");
        } else {
            if (this.markTime == -1L) {
                this.markTime = this.startTime;
            }

            long now = System.currentTimeMillis();
            long duration = now - this.markTime;
            this.markTime = now;
            return duration;
        }
    }

    public synchronized long stop() {
        if (!this.running) {
            throw new IllegalStateException("Stopwatch hasn't been started");
        } else {
            this.running = false;
            this.stopTime = System.currentTimeMillis();
            return this.stopTime - this.startTime;
        }
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public long getRunTime() {
        if (!this.running) {
            throw new IllegalStateException("Stopwatch hasn't been started");
        } else {
            return System.currentTimeMillis() - this.startTime;
        }
    }

    public long getLastMarkTime() {
        return this.markTime;
    }

    public boolean isRunning() {
        return this.running;
    }
}


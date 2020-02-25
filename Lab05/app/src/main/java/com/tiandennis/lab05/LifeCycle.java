package com.tiandennis.lab05;

class LifeCycle {
    private int create, start, resume, pause, stop, restart, destroy;

    LifeCycle(int create, int start, int resume, int pause, int stop, int restart, int destroy) {
        this.create = create;
        this.start = start;
        this.resume = resume;
        this.pause = pause;
        this.stop = stop;
        this.restart = restart;
        this.destroy = destroy;
    }

    void reset() {
        this.create = this.start = this.resume = this.pause = this.stop = this.restart = this.destroy = 0;
    }

    int getCreate() {
        return create;
    }

    void incrementCreate() {
        this.create++;
    }

    int getStart() {
        return start;
    }

    void incrementStart() {
        this.start++;
    }

    int getResume() {
        return resume;
    }

    void incrementResume() {
        this.resume++;
    }

    int getPause() {
        return pause;
    }

    void incrementPause() {
        this.pause++;
    }

    int getStop() {
        return stop;
    }

    void incrementStop() {
        this.stop++;
    }

    int getRestart() {
        return restart;
    }

    void incrementRestart() {
        this.restart++;
    }

    int getDestroy() {
        return destroy;
    }

    void incrementDestroy() {
        this.destroy++;
    }
}

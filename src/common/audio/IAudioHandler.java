package common.audio;

/**
 * Primary Author: Andrew McManaway
 * Code Review: Liam Byrne
 * External Tester: James Watt
 */

public interface IAudioHandler {

    /**
     * This method can be called whenever the implementer wishes to play a new track without waiting for the Queue
     * @param track The SoundTrack to be played.
     */
    void playSound(Track track);

    /**
     * This method will disable all other music playing and queued, and start a music clip that will
     * constantly loop until either another song is requested, or stop() is called.
     */
    void playLoop(Track track);

    /**
     * This method will queue a new song to be played. This could either include a check to play the song instantly,
     * or allow the implementor to call the next() method.
     * @param track The SoundTrack to be queued.
     */
    void queueMusic(Track track);

    /**
     * This method will completely skip the current song playing (if one exists), the provided song will then play,
     * forcing itself in front of the rest of the queue. This is to be used in the scenario of a song needing to be
     * played instantly in the background.
     * @param track The SoundTrack to be forcefully played.
     */
    void forceMusic(Track track);

    /**
     * This method will allow for the current background music-file to be skipped, and for the next song to be played.
     * If another song doesn't exist, the next() method will just return.
     */
    void next();

    /**
     * Allow for the implementer to change the volume for all audio-common being played.
     * @param percentage A value between 0.0f and 1.0f
     */
    void setAudioVolume(float percentage);

    /**
     * When called, all music currently playing will stop, and the queue will be emptied.
     */
    void stop();
}

package trash.homework.designpattern.lab5.one;

public abstract class Platform {
    protected VideoFileType videoFileType;

    public void setVideoFileType(VideoFileType videoFileType) {
        this.videoFileType = videoFileType;
    }

    public abstract void play(String filename);
}

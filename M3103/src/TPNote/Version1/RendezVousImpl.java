package TPNote.Version1;

import myrendezvous.Rendezvous;

import java.util.Calendar;

public class RendezVousImpl implements Rendezvous {
    private String description;
    private String title;
    private int duration;
    private Calendar time;
    private Calendar tag;

    public RendezVousImpl(String description, String title, int duration, Calendar time) {
        this.description = description;
        this.title = title;
        this.duration = duration;
        this.time = (Calendar) time.clone();
        this.tag = (Calendar) this.time.clone();
    }

    public RendezVousImpl(String title, int duration, Calendar time) {
        this(null, title, duration, time);
    }

    @Override
    public Calendar getTime() {
        return time;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Calendar getTag() {
        return tag;
    }

    @Override
    public void setTime(Calendar calendar) throws IllegalArgumentException {
        this.time = calendar;
        this.tag = (Calendar) this.time.clone();
    }

    @Override
    public void setDuration(int i) throws IllegalArgumentException {
        this.duration = i;
    }

    @Override
    public void setTitle(String s) throws IllegalArgumentException {
        this.title = s;
    }

    @Override
    public void setDescription(String s) {
        this.description = s;
    }

    public void setTag(Calendar tag) {
        this.tag = tag;
    }

    @Override
    public RendezVousImpl clone() {
        RendezVousImpl copie;
        try {
            copie = (RendezVousImpl) super.clone();
            copie.time = (Calendar) this.time.clone();
            return copie;
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException();
        }
    }
}

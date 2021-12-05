public class Clock {

    private int hour;
    private int minute;

    public Clock(int hour, int minute) {
        validTime();
        this.hour = hour;
        this.minute = minute;
    }

    public void setHour(int hour) {
        validTime();
        this.hour = hour;
    }
    public void setMinute(int minute) {
        validTime();
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }
    public int getHour() {
        return hour;
    }

    public int compare(Object obj)
    {
        if (!(obj instanceof Clock))
            return -2; // different object
        Clock other = (Clock) obj;

        if (hour > other.hour)
        {
            return 1;
        }
        else if (hour < other.hour)
        {
            return -1;
        }
        else
        {
            if (minute < other.minute)
            {
                return -1;
            }
            else if (minute > other.minute)
            {
                return 1;
            }
            else
                return 0;
        }
    }
    public boolean validTime()
    {
        if (hour < 1 || hour > 24 || minute < 1 || minute > 59)
        {
            throw new IllegalClockException();
        }
        return true;
    }
    public Clock copy()
    {
        return new Clock(hour,minute);
    }
    public String toString ()
    {
        return hour + ":" + minute;
    }

}

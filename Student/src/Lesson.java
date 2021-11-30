public class Lesson
{
    private String beginTime;
    private String endTime; //
    private String date;
    private Course course;

    public Lesson(String beginTime, String endTime, String date, Course course)//add course to diagram
    {
        this.beginTime=beginTime;
        this.endTime=endTime;
        this.date=date;
        this.course=course;
    }
    public void setBeginTime(String beginTime)
    {
        this.beginTime=beginTime;
    }
    public String getBeginTime()
    {
        return beginTime;
    }
    public void setEndTime(String endTime)
    {
        this.endTime=endTime;
    }
    public String getEndTime()
    {
        return endTime;
    }
    public Course getCourse()
    {
        return course;
    }
    public void setCourse(Course course)
    {
        this.course=course;
    }
    public boolean equals(Object obj)
    {
        if(obj instanceof Lesson)
        {
            return false;
        }
        Lesson other = (Lesson) obj;
        return beginTime.equals(other.beginTime) && endTime.equals(other.endTime) && date.equals(other.date) && course.equals(other.course);
    }
    public String toString()
    {
        return "Course: " + course + "\nStart time: " +beginTime + "\nEnd time: " + endTime + "\nDate: " + date;
    }
}

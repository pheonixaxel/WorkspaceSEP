public class Lesson
{
  private Clock beginTime;
  private Clock endTime;
  private Date date;
  private Course course;

  public Lesson(Clock beginTime ,Date date,Clock endTime, Course course)
  {
    this.beginTime = beginTime.copy();
    this.endTime = endTime.copy();
    this.date = date.copy();
    this.course = course;
  }

  public void setBeginTime(Clock beginTime)
  {
    this.beginTime = beginTime;
  }

  public Clock getBeginTime()
  {
    return beginTime;
  }

  public void setEndTime(Clock endTime)
  {
    this.endTime = endTime;
  }

  public Clock getEndTime()
  {
    return endTime;
  }

  public Course getCourse()
  {
    return course;
  }

  public void setCourse(Course course)
  {
    this.course = course;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  public Date getDate()
  {
    return date;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Lesson))
    {
      return false;
    }
    Lesson other = (Lesson) obj;
    return beginTime.equals(other.beginTime) && endTime.equals(other.endTime)
        && date.equals(other.date) && course.equals(other.course);
  }

  public String toString()
  {
    return course + "," + beginTime + "," + endTime + "," + date;
  }
}

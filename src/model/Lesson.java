package model;

import java.io.Serializable;

public class Lesson implements Serializable
{
  private Clock beginTime;
  private Clock endTime;
  private Date date;
  private Course course;
  private Teacher teacher;
  private Room room;

  public Lesson(Clock beginTime ,Date date,Clock endTime, Course course, Teacher teacher, Room room)
  {
    this.beginTime = beginTime.copy();
    this.endTime = endTime.copy();
    this.date = date.copy();
    this.course = course;
    this.teacher = teacher;
    this.room = room;
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

  public Teacher getTeacher()
  {
    return teacher;
  }

  public void setTeacher(Teacher teacher)
  {
    this.teacher = teacher;
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
    return course + "," + room + "," + teacher + "," + beginTime + "," + endTime + "," + date;
  }
}

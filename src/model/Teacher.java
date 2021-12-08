package model;

import java.io.Serializable;

public class Teacher /*extends Person*/ implements Serializable
{
  private String initials; //NEW
  public Teacher(String initials)
  {
    this.initials=initials;
    //super(initials);
  }

  public void setInitials(String initials)
  {
    //super.setName(initials);
    this.initials=initials;
  }

  public String getInitials()
  {
    return initials;
    //return super.getName();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))return false;
    Teacher other = (Teacher) obj;
    return initials.equals(other.initials);
    //return super.equals(obj);
  }

  public String toString()
  {
    return initials;
    //return super.toString();
  }
}

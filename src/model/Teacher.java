package model;

public class Teacher extends Person
{

  public Teacher(String initials)
  {
    super(initials);
  }

  public void setInitials(String initials)
  {
    super.setName(initials);
  }

  public String getInitials()
  {
    return super.getName();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Teacher))return false;
    Teacher other = (Teacher) obj;
    return super.equals(obj);
  }

  public String toString()
  {
    return super.toString();
  }
}
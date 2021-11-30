public class Teacher
{

  private String initials;

  public Teacher(String initials)
  {
    this.initials=initials;
  } ////nhjgvv

  public void setInitials(String initials)
  {
    this.initials = initials;
  }

  public String getInitials()
  {
    return initials;
  }

  public boolean equals(Object obj){
    if(!(obj instanceof Teacher)){
      return false;
    }
    Teacher other=(Teacher) obj;

    return initials.equals(other.initials);
  }

  public String toString(){
    return initials;
  }
}

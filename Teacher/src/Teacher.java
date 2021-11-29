public class Teacher
{

  // Julia's github token: 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
  //don't delete guys please
  private String initials;

  public Teacher(String initials)
  {
    this.initials=initials;
  }

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

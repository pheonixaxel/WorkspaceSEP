package model;

public abstract class Person
{
  private String name;

  public Person(String name)
  {
    this.name=name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }


  public boolean equals(Object obj)
  {
    if(!(obj instanceof Person))return false;
    Person other = (Person) obj;
    return name.equals(other.name);
  }

  public String toString()
  {
    return name;
  }
}

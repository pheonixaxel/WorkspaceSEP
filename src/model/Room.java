package model;

import java.io.Serializable;

public class Room implements Serializable
{
  private int size;
  private String id;

  public Room(String id, int size)
  {
    this.size = size;
    this.id = id;
  }

  public void setSize(int size)
  {
    this.size = size;
  }

  public int getSize()
  {
    return size;
  }

  public String getId()
  {
    return id;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Room))
    {
      return false;
    }
    Room other = (Room) obj;
    return size == other.size && id.equals(other.id);
  }

  public String toString()
  {
    return id;
  }
}

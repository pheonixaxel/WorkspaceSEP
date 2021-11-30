public class Room
{
  private int size;
  private String id;

  public Room(int size, String id)
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
    return "Room size: " + size + "\nRoom id: " + id;
  }
}

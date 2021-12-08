package model;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable
{
  private ArrayList<Room> rooms;

  public RoomList()
  {
    rooms = new ArrayList<Room>();
  }

  public void addRoom(Room room)
  {
    rooms.add(room);
  }

  public Room getRoom(String id)
  {
    for(int i=0;i<rooms.size();i++)
    {
      if(rooms.get(i).getId().equals(id))return rooms.get(i);
    }
    return null;
  }
  public Room getRoom(int index){return rooms.get(index);}
  public int size(){return rooms.size();}
}

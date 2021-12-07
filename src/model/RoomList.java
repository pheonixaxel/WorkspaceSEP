package model;

import java.util.ArrayList;

public class RoomList
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
}

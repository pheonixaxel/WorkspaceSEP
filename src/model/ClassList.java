package model;

import model.Class;

import java.io.Serializable;
import java.util.ArrayList;

public class ClassList implements Serializable//delete this comment
{
  private ArrayList<Class> classes;

  public ClassList()
  {
    classes = new ArrayList<Class>();
  }
  public ArrayList<Class> getAllClasses()
  {return classes;}
  public Class getClass(int semester, String id)
  {
    for(int i=0;i<classes.size();i++)
    {
      if(classes.get(i).getSemester()==semester && classes.get(i).getId().equals(id))
        return classes.get(i);
    }
    return null;
  }
  public void addClass(Class clas){classes.add(clas);};
}

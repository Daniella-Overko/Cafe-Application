
/***************************************************************
 * Searching class to check if which emails are in the system. 
 *
 * @author      Daniuella Overko    3795524
 * @version     CS 1083             Project: Part 2
 **************************************************************/
public class Searching<T>
{
    // method to execute a linear search
    public int linearSearch(T[] list, T target)
    {
        int index = 0;
        
        boolean found = false;
        
        // while the matching object has not been found and we still have ***objects in the array to check
        while (!found && index < list.length)
        {
            // found if they are the same, if not the same move on to the next index
            if (list[index].equals(target))
                found = true;
            else
                index++;
        }
        
        // return either the index of the matching object or null depending on whether the target was found
        if (found)
            return index;
        else
            return -1;
    }
}
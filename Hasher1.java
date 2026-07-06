import java.util.*;
import java.io.*;

public class Hasher1
{
    @Override
	public int hashCode() {
	    int result = 17;
	    result = 31 * result + (first == null ? 0 : first.hashCode());
	    result = 31 * result + (last == null ? 0 : first.hashCode());
        return result;
	}
}
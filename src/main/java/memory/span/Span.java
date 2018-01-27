package memory.span;

import java.time.LocalDateTime;
import memory.tools.*;

/**
 * Class models a timespan, or period of time. 
 * Can have an innerspan, which describes a pattern of activity.
 * For example, could be used to say timespan is only active on Mondays.
 */
public class Span{

    public LocalDateTime start, end;
    public Cycle cycle;
    
    public Span(LocalDateTime s, LocalDateTime e){
	this(s, e, null);
    }

    public Span(LocalDateTime s, LocalDateTime e, Cycle c){
	start = s;
	end = e;
	cycle = c;
	if (isCyclic())
	    c.set(s);
    }

    public boolean hasStart(){
	return start != null;
    }
    
    public boolean hasEnd(){
	return end != null;
    }

    public boolean isCyclic(){
	return cycle != null;
    }

    /**
     * Checks if the Span is active at a certain datetime.
     * @param t The specific datetime
     * @return boolean Whether it was active
     */
    public boolean isActive(LocalDateTime t){
	if (! Time.isBetween(t, start, end))
	    return false;
	if (! isCyclic())
	    return true;
	return cycle.isActive(t);
    }

    /**
     * Add a span to the list of inner spans.
     * @param in The Span to add 
     * @return boolean Whether the Span was sucessfully added
     */
    // public boolean add(Span in){
    // 	if (!overlap(in))
    // 	    return false;
    // 	if(Time.isBetween(start, in.start, in.end))
    // 	    in.start = start;
    // 	if(Time.isBetween(end, in.start, in.end))
    // 	    in.end = end;
    // 	innerSpans.add(in);
    // 	return true;
    // }
}

package memory.tools;

import java.time.LocalDateTime;

/**
 * Class models a timespan, or period of time. 
 * Can have an innerspan, which describes a pattern of activity.
 * For example, could be used to say timespan is only active on Mondays.
 */
public class Span{

    public LocalDateTime start, end;
    public Span periodicSpan;
    
    public Span(LocalDateTime s, LocalDateTime e){
	this(s, e, null);
    }

    public Span(LocalDateTime s, LocalDateTime e, Span period){
	start = s;
	end = e;
	periodicSpan = period;
    }

    public boolean hasStart(){
	return start != null;
    }
    
    public boolean hasEnd(){
	return end != null;
    }

    public boolean isPeriodic(){
	return periodicSpan != null;
    }

    /**
     * Checks if the Span is active at a certain datetime.
     * @param t The specific datetime
     * @return boolean Whether it was active
     */
    public boolean isActive(LocalDateTime t){
	if (! Time.isBetween(t, start, end))
	    return false;
	if (! isPeriodic())
	    return true;
	return periodicSpan.hasInner(t);
    }

    /**
     * Add a span to the list of inner spans.
     * @param in The Span to add 
     * @return boolean Whether the Span was sucessfully added
     */
    public boolean add(Span in){
	if (!overlap(in))
	    return false;
	if(Time.isBetween(start, in.start, in.end))
	    in.start = start;
	if(Time.isBetween(end, in.start, in.end))
	    in.end = end;
	innerSpans.add(in);
	return true;
    }
}

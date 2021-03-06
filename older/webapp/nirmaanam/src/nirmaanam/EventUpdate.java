package nirmaanam;
import java.sql.*;

public class EventUpdate{
	int id;
	String message;
	Event event;
	int timeStamp;
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	public EventUpdate()
	{
		this.id=0;
		this.message=null;
		this.event=null;
		this.timeStamp=0;
	}
	public EventUpdate(Event event, String message)
	{
		this.event=event;
		this.message=message;
	}	//timeStamp defaults to currentTime
	public EventUpdate(Event event, String message, int timeStamp)
	{
		this.event=event;
		this.message=message;
		this.timeStamp=timeStamp;
	}
	public void setMessage(String m)
	{
		this.message=m;
	}
	public void setEvent(Event e)
	{
		this.event=e;
	}
	public void setTimeStamp(int ts)
	{
		this.timeStamp=ts;
	}
	
	public String getMessage()
	{
		return message;
	}
	public Event getEvent()
	{
		return event;
	}
	public int getTimeStamp()
	{
		return timeStamp;
	}

	public EventUpdate load(int EventUpdateId) throws SQLException,EntityNotFoundException{
		Database db = Database.getDB();
		SelectQuery sq = db.select("EventUpdate").where("id",EventUpdateId).execute();
		ResultSet rs = sq.getResultSet();
		if(rs.next()){
			this.id = rs.getInt("id");
			this.message = rs.getString("message");
			this.event = new Event().load(rs.getInt("eventId"));
			this.timeStamp = rs.getInt("timeStamp");
		}
		else
			throw(new EntityNotFoundException("EventUpdate#"+EventUpdateId+" not found"));
			
		return this;
	} //Loads from the database
	
	public void store() throws SQLException,IncompleteFieldException{
		Database db = Database.getDB();
		db.checkInput(message).checkInput(event.id);	//, timestamp);
		InsertQuery iq= db.insert("EventUpdate").addParam("message",message).addParam("event",event.id).execute();
		this.id = iq.insertId();
	} //Stores into the database

}//end of class
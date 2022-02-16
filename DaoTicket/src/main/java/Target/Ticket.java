package Target;

public class Ticket {
    String TicketID,FilmName,StartTime,EndTime;
    int MovieHall,Sum;

    public Ticket(String filmName,String ticketID, int movieHall, String startTime, String endTime,int sum) {
        TicketID = ticketID;
        FilmName = filmName;
        StartTime = startTime;
        EndTime = endTime;
        MovieHall = movieHall;
        Sum=sum;
    }

    public Ticket() {
    }

    public void setTicketID(String ticketID) {
        TicketID = ticketID;
    }

    public void setFilmName(String filmName) {
        FilmName = filmName;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public void setMovieHall(int movieHall) {
        MovieHall = movieHall;
    }
    public void setSum(int sum){
        Sum=sum;
    }

    @Override
    public String toString() {
        return "--------------------"+
                "\nFilmName:"+FilmName+
                "\nTicketID:"+TicketID+
                "\nMovieHall:"+MovieHall+
                "\nStartTime:"+StartTime+
                "\nEndTime:"+EndTime+
                "\nSum:"+Sum+
                "\n--------------------";
    }
}

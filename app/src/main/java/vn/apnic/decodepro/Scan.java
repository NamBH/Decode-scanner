package vn.apnic.decodepro;

public class Scan {

    private static int mCount = 1;
    private int ID;
    private String Format;
    private String Content;
    private String Date;

    public Scan() {
        super();
    }

    public Scan (String mFormat, String mContent, String mDate) {
        this.ID = Scan.mCount++;
        this.Format = mFormat;
        this.Content = mContent;
        this.Date = mDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Scan [ID : " + ID + ", Format : " + Format + "]";
    }
}

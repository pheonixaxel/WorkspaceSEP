public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Copy constructor
    public Date(Date object) {
        day = object.day;
        month = object.month;
        year = object.year;
    }

    public void setDay(int day) {
        if (day < 1)
            throw new IllegalDateException();
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day > 31)
                throw new IllegalDateException();
        } else if (month == 2) {
            if (isLeapYear() && day > 29)
                throw new IllegalDateException();
            if (!isLeapYear() && day > 28)
                throw new IllegalDateException();
        } else {
            if (day > 30)
                throw new IllegalDateException();
        }

        this.day = day;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 1)
            throw new IllegalDateException();
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int compare(Object obj) {
        if (!(obj instanceof Date)) {
            return -2;
        }// -2 = different object

        Date other = (Date) obj;
        // -1 = before   e      0 = same        1 = after
        if (year > other.year) {
            return 1;
        } else if (year < other.year) {
            return -1;
        } else {
            if (month < other.month)
                return -1;
            else if (month > other.month)
                return 1;
            else {
                if (day < other.month)
                    return -1;
                else if (day > other.day)
                    return 1;
                else
                    return 0;
            }
        }
    }

    // Copy method
    public Date copy() {
        return new Date(day, month, year);
    }

    public String toString() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }
}

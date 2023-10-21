public class Main {
    
    Day day;

    public Main(Day day){
        this.day = day;
    }

    public static void makeDays(DAY day){

        switch (day) {
            case MONDAY:
                    System.out.println("This is monday");
                break;
            case TUESDAY:
                    System.out.println("this is tuesday");
                    break;
        
            default:
                break;
        }
    }


    public static void main(String[] args) {
        Main myday = new Main(MONDAY);
        makeDays();

    }

    
}

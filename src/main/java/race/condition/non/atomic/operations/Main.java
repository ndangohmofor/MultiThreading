package race.condition.non.atomic.operations;

public class Main {

    public static class SharedClass {
        private int x = 0;
        private int y = 0;

        public void increment(){
            x++;
            y++;
        }

        public void checkForDataRace(){
            if (y > x){
                System.out.println("y > x -> Data race detected");
            }
        }
    }
}

public class MainInterface {
    private static class Minotaurus implements Human, Bull{

        @Override
        public void walk() {

        }

        @Override
        public void talk() {

        }
    }

    public static void main(String[] args) {
        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();
        Minotaurus minos2 = new Minotaurus();
        Human man1 = new Man();
        Bull ox2 = new Ox();
        Bull[] allBulls = {ox2, minos0, minos2};
        Human [] allHumans = {man1, minos2, minos1};
    }

}

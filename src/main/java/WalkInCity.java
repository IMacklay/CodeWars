public class WalkInCity {
    public static void main(String[] args) {
        char[] walkPath = {'w', 'n', 's', 'e','w', 'n', 's', 'e','w','e'};

        System.out.println(isValidBest(walkPath));

    }

    //Позволяет ли маршрут вернуться в точку выхода
    public static boolean isValid(char[] walk) {

        if (walk.length != 10) return false;

        //Ход по вертикали или горизонталь
        int gorizont = 0;
        int vertical = 0;

        System.out.println("-------------------------------");
        System.out.println(walk.length);
        System.out.println("-------------------------------");
        for (int i=0; i<walk.length; i++){

            switch (walk[i]) {
                case 'w': gorizont++; break;
                case 'e': gorizont--; break;
                case 'n': vertical++; break;
                case 's': vertical--; break;
            }
            System.out.println(walk[i]+" -> ["+gorizont+"  ;  "+vertical+"]");
        }

        return  gorizont==0 && vertical == 0;
    }

    //Best practices
    public static boolean isValidBest(char[] walk) {
        String s = new String(walk);
        return s.chars().filter(p -> p == 'n').count() == s.chars().filter(p -> p == 's').count() &&
                s.chars().filter(p -> p == 'e').count() == s.chars().filter(p -> p == 'w').count() && s.chars().count() == 10;
    }
}

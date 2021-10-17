public class Execute {
    public static void main(String[] args) {
        int [][] sq1Arr =
            {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            };
        int [][] sq2Arr =
            {
                {1,2,3},
                {},
                {7}
            };
        int [][] sq3Arr = {};
        Square3x3 sq1 = new Square3x3(sq1Arr);
        Square3x3 sq2 = new Square3x3(sq2Arr);
        Square3x3 sq3 = new Square3x3(sq3Arr);
        Square3x3 sq4 = new Square3x3();
        Square3x3 sq5 = new Square3x3(sq1);
        /*System.out.println(sq1.toString());
        System.out.println(sq2.toString());
        System.out.println(sq3.toString());
        System.out.println(sq4.toString());
        System.out.println(sq5.toString());
        sq5.setXY(1,1,100);
        System.out.println(sq1.toString());
        System.out.println(sq5.toString());*/
        System.out.println(sq5.allThere());
        System.out.println(sq1.allThere());
        System.out.println(sq2.allThere());

    }
}

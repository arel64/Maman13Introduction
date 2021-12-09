public class Execute {
    public static void main(String[] args) {
        Sudoku s1 =new Sudoku();
        int [][] sq1Arr = {
                {4,4,12,-100000,123,12},
                {1},
                {1,2,3}
        };
        Square3x3 sq1 = new Square3x3(sq1Arr);
        int [][] sq2Arr = {
                {2}
        };
        Square3x3 sq2 = new Square3x3(sq2Arr);
        //System.out.println(sq1.toString());
        System.out.println(sq1.toString());
    }
}

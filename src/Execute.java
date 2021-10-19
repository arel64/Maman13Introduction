public class Execute {
    public static void main(String[] args) {
        Sudoku s1 =new Sudoku();
        int [][] sq1Arr = {
                {4,3,5},
                {6,8,2},
                {1,9,7}
        };
        Square3x3 sq1 = new Square3x3(sq1Arr);
        int [][] sq2Arr = {
                {2,6,9},
                {5,7,1},
                {8,3,4}
        };
        Square3x3 sq2 = new Square3x3(sq2Arr);
        int [][] sq3Arr = {
                {7,8,1},
                {4,9,3},
                {5,6,2}
        };
        Square3x3 sq3 = new Square3x3(sq3Arr);
        int [][] sq4Arr = {
                {8,2,6},
                {3,7,4},
                {9,5,1}
        };
        Square3x3 sq4 = new Square3x3(sq4Arr);
        int [][] sq5Arr = {
                {1,9,5},
                {6,8,2},
                {7,4,3}
        };
        Square3x3 sq5 = new Square3x3(sq5Arr);
        int [][] sq6Arr = {
                {3,4,7},
                {9,1,5},
                {6,2,8}
        };
        Square3x3 sq6 = new Square3x3(sq6Arr);
        int [][] sq7Arr = {
                {5,1,9},
                {2,4,8},
                {7,6,3}
        };
        Square3x3 sq7 = new Square3x3(sq7Arr);
        int [][] sq8Arr = {
                {3,2,6},
                {9,5,7},
                {4,1,8}
        };
        Square3x3 sq8 = new Square3x3(sq8Arr);
        int [][] sq9Arr = {
                {8,7,4},
                {1,3,6},
                {2,5,9}
        };
        Square3x3 sq9 = new Square3x3(sq9Arr);
        Square3x3[][] sqArr = {
                {sq1,sq2,sq3},
                {sq4,sq5,sq6},
                {sq7,sq8,sq9}
        };
        Sudoku s2 = new Sudoku(sqArr);
        System.out.println(s2.isValid());
        System.out.println(s1.isValid());
    }
}

public class Sudoku {
    private Square3x3[][] _squareCluster;
    public Sudoku(){
        this(new Square3x3[3][3]);
    }
    public Sudoku(Square3x3[][] square3x3Array){
        _squareCluster = new Square3x3[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                _squareCluster[i][j] = new Square3x3(square3x3Array[i][j]);
            }
        }
    }
}

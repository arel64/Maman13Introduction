public class Sudoku {
    private Square3x3[][] _squareCluster;
    public Sudoku(){
        _squareCluster = new Square3x3[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                _squareCluster[i][j] = new Square3x3();
            }
        }
    }
    public Sudoku(Square3x3[][] square3x3Array){
        _squareCluster = new Square3x3[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                _squareCluster[i][j] = new Square3x3(square3x3Array[i][j]);
            }
        }
    }
    public Boolean isValid(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                if(!_squareCluster[i][j].allThere()){
                    //if one square isn't valid the whole board is not valid
                    return false;
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            if(!_allTrue(_getCompleteRowValues(i),1)) return false;
            if(!_allTrue(_getCompleteColValues(i),1)) return false;
        }
        return true;
    }
    //1-9
    private boolean[] _getCompleteColValues(int absCol){
        return _getCompleteGridElement(absCol,"col");

    }
    //1-9
    private boolean[] _getCompleteRowValues(int absRow){
        return _getCompleteGridElement(absRow,"row");
    }
    private boolean[]_getCompleteGridElement(int absElement,String identifier){
        absElement = absElement -1;
        int elementInCluster = absElement%3;
        int clusterElementIndex = absElement/3;
        boolean [] values = new boolean[10];
        Square3x3 currentCluster;
        for (int i = 0; i < 3; i++) {
            if(identifier.equals("row")){
                currentCluster = new Square3x3(_squareCluster[clusterElementIndex][i]);
                currentCluster.whosThereRow(elementInCluster,values);
            }else{
                currentCluster = new Square3x3(_squareCluster[i][clusterElementIndex]);
                currentCluster.whosThereCol(elementInCluster,values);
            }
        }
        return values;
    }
    private boolean _allTrue(boolean arr[],int offset){
        for (int i = offset ; i < arr.length ; i++){
            if(!arr[i]) return false;
        }
        return true;
    }
}

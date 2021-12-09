/**
 *
 */
public class Sudoku {
    private Square3x3[][] _squareCluster;

    /**
     * Constructs a 3x3 board of 3x3 grid all init to the default value for 3x3 Square
     */
    public Sudoku(){
        _squareCluster = new Square3x3[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                _squareCluster[i][j] = new Square3x3();
            }
        }
    }

    /**
     * Constructs a board from a 2 dimensional array of 3x3 Squares
     * @param square3x3Array array to init from
     */
    public Sudoku(Square3x3[][] square3x3Array){
        _squareCluster = new Square3x3[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                _squareCluster[i][j] = new Square3x3(square3x3Array[i][j]);
            }
        }
    }

    /**
     * Check the entire board for validity
     * @return true if board is a valid finished suduko board
     */
    public boolean isValid(){
        /*
            for a board to be valid 2 things need to happen:
            (1) all the 3x3 clusters must have all 9 digits exactly once
            (2) each row and columns must have all 9 digits exactly once
         */
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                //Check every single 3x3 cluster for all the digits (1)
                if(!_squareCluster[i][j].allThere()){
                    //if one square isn't valid the whole board is not valid
                    return false;
                }
            }
        }
        //Checks for condition (2)
        for (int i = 1; i <= 9; i++) {
            if(!_allTrue(_getCompleteRowValues(i),1)) return false;
            if(!_allTrue(_getCompleteColValues(i),1)) return false;
        }
        return true;
    }

    /**
     * returns boolean array that represents which digits are present in the absolute column of the 9x9 grid
     * @param absColIndex number from 1-9 that represents a column in the sudoku board
     * @return boolean array that represents digit present in given col
     */
    private boolean[] _getCompleteColValues(int absColIndex){
        return _getCompleteGridElement(absColIndex,"col");

    }
    /**
     * returns boolean array that represents which digits are present in the row/column requested by index
     * @param absElementIndex index of row/col requested
     * @param identifier "row" if the index is for a row,else will return a col with the index
     * @return boolean array that represents digit present in given row/col
     */
    private boolean[]_getCompleteGridElement(int absElementIndex,String identifier){
        //Row number and the index in the array are offset by one(arrays start at 0!)
        int elementIndex = absElementIndex -1;

        // row/column of the cluster the element is in
        int clusterElementIndex = elementIndex/3;

        //the position of the element within it's cluster
        int elementInCluster = elementIndex%3;

        boolean [] values = new boolean[10];
        Square3x3 currentCluster;


        for (int i = 0; i < 3; i++) {
            if (identifier.equals("row")) {
                //Element is row

                //For each cluster in the row of the cluster that the absRow is in, add the digits inside the cluster's corresponding row to a boolean array
                currentCluster = new Square3x3(_squareCluster[clusterElementIndex][i]);
                currentCluster.whosThereRow(elementInCluster, values);
            } else {
                //Element is column

                //For each cluster in the col of the cluster that the absCol is in, add the digits inside the cluster's corresponding col to a boolean array
                currentCluster = new Square3x3(_squareCluster[i][clusterElementIndex]);
                currentCluster.whosThereCol(elementInCluster, values);
            }
        }
        return values;
    }

    /**
     * returns boolean array that represents which digits are present in the absolute row of the 9x9 grid
     * @param absRowIndex number from 1-9 that represents a row in the sudoku board
     * @return boolean array that represents digit present in given row
     */
    private boolean[] _getCompleteRowValues(int absRowIndex){
        return _getCompleteGridElement(absRowIndex,"row");
    }

    /**
     * Checks in a boolean array's values are all true from a specified offset
     * @param arr boolean array to check
     * @param offset offset to check from
     * @return true if all values from and including the offset index in the array are true or if offset is outside of array bounds
     */
    private boolean _allTrue(boolean arr[],int offset){
        if(offset >= arr.length) return true; //offset is outside of array bounds, return true

        //Iterator is init to array bounds
        for (int i = offset ; i < arr.length ; i++){
            if(!arr[i]) return false; // if one of the indexes in range are false return it without checking the rest
        }
        return true;
    }
}

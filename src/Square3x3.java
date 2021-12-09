/**
 *
 */
public class Square3x3 {
    final int DEFAULT_CELL_VALUE = -1;
    private int _cellArr[][];

    /**
     * Default constructor, constructs and initializes the 2-dimensional
     * array of the size 3X3, with the values of –1 in each cell.
     */
    public Square3x3(){
        _cellArr = new int[3][3];
        for (int i = 0 ; i <3 ; i++ )
            for(int j = 0 ; j< 3 ; j++)
                _cellArr[i][j] = DEFAULT_CELL_VALUE;

    }

    /**
     * Constructs a 2-dimensional array of the size 3X3, whose values are taken from the given
     * array. If the given array’s size is bigger than 3X3, only the first 3X3 cells are taken. If the
     * given array is smaller, the rest of the cells are initialized to –1.
     * @param array 2 dimensional array from
     */
    public Square3x3(int[][]array){

        _cellArr = new int[3][3];

        int dereferenceRange = array.length;


        for (int i = 0 ; i <3 ; i++ ){
            // Retrieves current iteration's second index length to combat unequal length of seconds index
            int innerDereferenceRange = 0;
            if(i<dereferenceRange)
                innerDereferenceRange = array[i].length;
            for(int j = 0 ; j< 3 ; j++){
                //Default value is inserted first, will be overridden if available
                _cellArr[i][j] = DEFAULT_CELL_VALUE;

                //Make sure iterator is within the dereference range of the second index
                if(j<innerDereferenceRange){
                    //Corresponding value exists! override default cell value placed before, after checking the value is indeed a 1-9 digit
                    if(array[i][j]>0 && array[i][j]<=9)
                        _cellArr[i][j] = array[i][j];
                }
            }
        }
    }

    /**
     * Copy constructor. Constructs a 2-dimensional array of the size 3X3, whose values are
     * taken from the array of the given Square3x3 object.
     * @param other Other 3x3 Square
     */
    public Square3x3(Square3x3 other){
        _cellArr = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3 ; j++)
                _cellArr[i][j] = other.getCell(i,j);
    }

    /**
     * Returns the value in the (row, col) cell. If the row and/or col are out of the
     * array bounds, returns –1. Legal values for row/col are 0,1,2.
     * @param row row number (0-2)
     * @param col col number (0-2)
     * @return value of cell at the [row][col] index, -1 on invalid params
     */
    public int getCell(int row,int col){

        //Check if dereference given is valid, returns -1 if not
        if(!_isValidRowCol(row,col)){
            return -1;
        }
        return _cellArr[row][col];
    }

    /**
     * Sets the cell (row, col) in the array to the given value. If the row and/or col
     * are out of the array bounds – does nothing. Legal values for row/col are
     * 0,1,2.
     * @param row row number (0-2)
     * @param col col number (0-2)
     * @param value value to set to corresponding row,col
     */
    public void setXY(int row,int col,int value){
        //Checks if row&col are valid before dereferences array
        if(_isValidRowCol(row,col)){
            _cellArr[row][col] = value;
        }
    }

    /**
     * Check if all digits(1-9) are represented in the grid
     * @return true if digits are there
     */
    public boolean allThere(){
        boolean isdigitPresent[] = new boolean[10]; //Array[0] is not used as there is no 0 in sudoku
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                int currentCellValue = getCell(i,j);

                //This is mostly not needed as values are checked on contruction of the grid, but I chose to check anyways
                if(currentCellValue <= isdigitPresent.length && currentCellValue > 0){
                    //Cell Value is 1-9
                    isdigitPresent[currentCellValue] =true;
                }
            }
        }
        //Make sure not to use the first cell as it is not in use
        for (int i = 1; i < isdigitPresent.length; i++) {
            if(!isdigitPresent[i]) return false; //If *any* digit between 1-9 is not present return false
        }
        return true;
    }
    /**
     * Marks the digits that are present in given row at the digit's index in the given array, leaves rest of cells unchanged
     * @param row row in grid to check (0-2)
     * @param values boolean array to mark corresponding values as true
     */
    public void whosThereRow (int row, boolean[] values ){
        _whosThereElement(row,values,"row");
    }

    /**
     * Marks the digits that are present in given col at the digit's index in the given array, leaves rest of cells unchanged
     * @param col row in grid to check (0-2)
     * @param values boolean array to mark corresponding values as true
     */
    public void whosThereCol (int col, boolean[] values ){
        _whosThereElement(col,values,"col");
    }

    /**
     * represents the grid as a string
     * @return string representation of the grid with tabs between columns and newlines between rows
     *
     */
    public String toString(){
        String output = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                output += getCell(i,j)+"";
                if(!(j == 2)){
                    //Make sure not to add a tab after the last element in a row
                    output +="\t";
                }
            }
            output += "\n";
        }
        return output;
    }

    /**
     * checks if row&col given are within bounds
     * @param row row index
     * @param col col index
     * @return true if row&col given are valid
     */
    private boolean _isValidRowCol(int row, int col){
        return _isValidOffset(row)&&_isValidOffset(col);
    }

    /**
     * Check if offset to grid representation is valid
     * @param offset index in grid
     * @return true if offset is valid (0-2)
     */
    private boolean _isValidOffset(int offset){
        return !(offset > 2);
    }

    /**
     * Marks the digits that are present in given row/col at the digit's index in the given array, leaves rest of cells unchanged
     * @param elementIndex element in grid to check (0-2)
     * @param values boolean array to mark corresponding values as true
     * @param identifier type of element, "row" for row, any other string with represent a col index
     */
    private void _whosThereElement (int elementIndex, boolean[] values , String identifier ){
        if(_isValidOffset(elementIndex)) {

            int currentCellValue;

            for (int i = 0; i < 3; i++) {
                if(identifier.equals("row")){
                    //Element is row, fetch it
                    currentCellValue = getCell(elementIndex,i);
                }else{
                    //Element is col, fetch it
                    currentCellValue = getCell(i,elementIndex);
                }
                /*
                    Because values can be any length, we must check that the digit is within the bounds of it
                    Also we make sure that the cell value is not the default (-1) <=9 is implicit from constructor limitations
                */
                if(currentCellValue < values.length && currentCellValue > 0){
                    values[currentCellValue] = true; //Mark digit as present
                }
            }
        }
    }
}

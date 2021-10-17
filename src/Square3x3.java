public class Square3x3 {
    final int DEFAULT_CELL_VALUE = -1;
    private int _cellArr[][];

    public Square3x3(){
        _cellArr = new int[3][3];
        for (int i = 0 ; i <3 ; i++ )
            for(int j = 0 ; j< 3 ; j++)
                _cellArr[i][j] = DEFAULT_CELL_VALUE;

    }
    public Square3x3(int[][]array){
        _cellArr = new int[3][3];
        int dereferenceRange = array.length;
        int innerDereferenceRange = 0;

        for (int i = 0 ; i <3 ; i++ ){
            if(i<dereferenceRange)
                innerDereferenceRange = array[i].length;
            for(int j = 0 ; j< 3 ; j++){
                _cellArr[i][j] = DEFAULT_CELL_VALUE;

                //Array[i] is guaranteed to be defined within this scope
                if(j<innerDereferenceRange){
                    //Give array at [i][j] is defined
                    _cellArr[i][j] = array[i][j];
                }

            }
        }
    }
    public Square3x3(Square3x3 other){
        _cellArr = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3 ; j++)
                _cellArr[i][j] = other.getCell(i,j);


    }
    public int getCell(int row,int col){
        if(!isValidRowCol(row,col)){
            return -1;
        }
        return _cellArr[row][col];
    }
    public void setXY(int row,int col,int value){
        if(isValidRowCol(row,col)){
            _cellArr[row][col] = value;
        }
    }
    public boolean allThere(){
        boolean isdigitPresent[] = new boolean[10]; //Array[0] is not user as there is no 0 in suduko
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                int currentCellValue = getCell(i,j);
                if(currentCellValue <= isdigitPresent.length && currentCellValue > 0){
                    //Cell Value is 1-9
                    isdigitPresent[currentCellValue] =true;
                }
            }
        }
        //Make sure not to use the first cell as it is not in use
        for (int i = 1; i < isdigitPresent.length; i++) {
            if(!isdigitPresent[i]) return false;
        }
        return true;
    }
    public void whosThereRow (int row, boolean[] values ){
        if(isValidOffset(row)) {
            int currentCellValue;
            for (int i = 0; i < 3; i++) {
                currentCellValue = getCell(row,i);
                if(currentCellValue < values.length && currentCellValue > 0){
                    values[currentCellValue] = true;
                }
            }
        }
    }
    public void whosThereCol (int col, boolean[] values ){
        if(isValidOffset(col)) {
            int currentCellValue;
            for (int i = 0; i < 3; i++) {
                currentCellValue = getCell(i,col);
                if(currentCellValue < values.length && currentCellValue > 0){
                    values[currentCellValue] = true;
                }
            }
        }
    }
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
    private boolean isValidRowCol(int row, int col){
        return isValidOffset(row)&&isValidOffset(col);
    }
    private boolean isValidOffset(int offset){
        return !(offset > 2);
    }
}

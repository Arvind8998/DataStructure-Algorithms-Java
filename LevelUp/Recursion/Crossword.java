public class Crossword {

    static char[][] box = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '-', '-', '-', '-', '-', '-', '+', '+' },
            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
            { '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' }, { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
            { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' }, { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
            { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

    static String[] words = { "agra", "norway", "england", "gwalior" };

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    public static boolean isValidHorizontalPlace(int i, int j, String word){
        if( (j-1 >=0 && box[i][j-1] != '+') || ( j+word.length() < box[0].length && box[i][j+word.length()] != '+') ) return false;

        for(int jj=0; jj< word.length(); jj++){
            if(j + jj >= box[0].length) return false;

            if(box[i][j+ jj] == '-' || box[i][j+ jj] == word.charAt(jj))
                continue;
            else 
                return false;
        
        }
        return true;
    }

    public static boolean isValidVerticalPlace(int i, int j, String word){
        if( (i-1 >=0 && box[i-1][j] != '+') || ( i+word.length() < box.length && box[i+word.length()][j] != '+') ) return false;

        for(int ii=0; ii< word.length(); ii++){
            if(i + ii >= box.length) return false;

            if(box[i + ii][j] == '-' || box[i+ii][j] == word.charAt(ii))
                continue;
            else 
                return false;
        
        }
        return true;
    }

    public static boolean[] placeHorizontally(int i, int j, String word){
        boolean[] placedCells = new boolean[word.length()];
        for(int jj=0; jj<word.length(); jj++){
            if(box[i][jj] == '-'){
                placedCells[jj] = true;
                box[i][jj] = word.charAt(jj);
            }
        }
        return placedCells;
    }

    public static boolean[] placeVertically(int i, int j, String word){
        boolean[] placedCells = new boolean[word.length()];
        for(int ii=0; ii<word.length(); ii++){
            if(box[ii][j] == '-'){
                placedCells[ii] = true;
                box[ii][j] = word.charAt(ii);
            }
        }
        return placedCells;
    }

    public static void unPlaceHorizontally(int i, int j, boolean[] placedCells, String word){
        for(int jj=0; jj< placedCells.length; jj++){
            if(placedCells[jj])
                box[i][jj] = '-';
            
        }
    }
    public static void unPlaceVertically( int i, int j, boolean[] placedCells, String word){
        for(int ii=0; ii< placedCells.length; ii++){
            if(placedCells[ii])
                box[ii][j] = '-';
        }
    }

    public static void crossWord(int idx) {
        if (idx == words.length) {
            print(box);
            return;
        }

        String word = words[idx];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (box[i][j] == '-' || box[i][j] == word.charAt(0)) {

                    if (isValidHorizontalPlace(i, j, word)) {
                        boolean[] hPlacedCells = placeHorizontally(i, j, word);
                        crossWord(idx + 1);
                        unPlaceHorizontally(i, j, hPlacedCells, word);
                    }

                    if(isValidVerticalPlace(i, j, word)){
                        boolean[] vPlacedCells = placeVertically(i, j, word);
                        crossWord(idx +1);
                        unPlaceVertically(i, j, vPlacedCells, word);
                    }
                }
            }
        }
    }

}